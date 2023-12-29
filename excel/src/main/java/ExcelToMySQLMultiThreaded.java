import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelToMySQLMultiThreaded {
    public static void main(String[] args) throws Exception {
        String hostName = "rm-m5ex8iy7tf2rf1sw5bo.mysql.rds.aliyuncs.com:3306";
        String userName = "deshou_pre";
        String userPassword = "Q5pELr49_8KfKYas";
        String dbName = "robo_school_pre";
//        String filePath = "C:\\Users\\yxkj\\Desktop\\鸿鑫驾校切得手.xlsx";
        String filePath = "C:\\Users\\yxkj\\Desktop\\鸿鑫驾校约课信息.xlsx";
        int numThreads = 4;

        AtomicInteger totalNum = new AtomicInteger();

        // 数据库链接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://" + hostName + "/" + dbName, userName, userPassword);
        connection.setAutoCommit(true);
        System.out.println("Connection to MySQL DB successful");

        // 固定线程池
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> futures = new ArrayList<>();

        // 读文件
        FileInputStream inputStream = new FileInputStream(filePath);
//        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Workbook workbook = StreamingReader.builder().bufferSize(4096).rowCacheSize(3000).open(inputStream);
//        Sheet sheet = workbook.getSheetAt(3);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Callable<Integer> callable = () -> {
                int ct = totalNum.incrementAndGet();
                String dataRowStr = rowDataPrint(row);
                System.out.println(Thread.currentThread().getName() + " +++ " + ct + dataRowStr);
                if (dataRowStr.split(",").length != 11) {
                    System.err.println(Thread.currentThread().getName() + " +++ " + ct + dataRowStr);
                }
                if (!",,,,,,,,".equals(dataRowStr)) {
                    System.out.println(Thread.currentThread().getName() + " <<< " + ct + dataRowStr);
                    String[] dataSplit = dataRowStr.split(",");
                    System.out.println(Thread.currentThread().getName() + " insert db >>> " + ct + " " + dataSplit.length);
                    String query = "INSERT INTO hx_course_record " +
                            "(student_name, id_card, student_status, license_type, class_name, subject, coach_name, car_number, course_date, course_period) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.setString(1, dataSplit[0]);
                        statement.setString(2, dataSplit[1]);
                        if (dataSplit[2].contains("结业")) {
                            statement.setInt(3, 2);
                        } else if (dataSplit[2].contains("退学")) {
                            statement.setInt(3, 3);
                        } else {
                            statement.setInt(3, 0);
                        }
                        String[] zb = dataSplit[3].split("-");
                        statement.setString(4, zb[0]);
                        statement.setString(5, zb[1]);
                        if (dataSplit[4].contains("科二")) {
                            statement.setString(6, "subject2");
                        } else if (dataSplit[4].contains("科三")) {
                            statement.setString(6, "subject3");
                        }

                        statement.setString(7, dataSplit[7]);
                        statement.setString(8, getCoachCarMap().getOrDefault(dataSplit[7], getCoachCarMap().get("")).stream().findAny().get());
                        statement.setString(9, dataSplit[9]);
                        statement.setString(10, dataSplit[10]);
                        statement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                return ct;
            };
            Future<Integer> future = executor.submit(callable);
            futures.add(future);
        }
        executor.shutdown();


        int completedTasks = 0;
        for (Future<Integer> future : futures) {
            try {
                future.get();
                completedTasks++;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("task count = " + completedTasks);
        System.out.println("total num = " + totalNum.get());
        System.out.println("Data inserted successfully");
        inputStream.close();
        workbook.close();
        connection.close();
    }

    private static String rowDataPrint(Row row) {
        if (row != null) {
            Iterator<Cell> cellIterator = row.cellIterator();
            StringBuilder sb = new StringBuilder();
            String val = "";
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                val = getVal(cell);
                sb.append(val).append(",");
            }
            return sb.toString();
        }
        return "KONG";
    }

    private static String getVal(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date dateCellValue = cell.getDateCellValue();
                    return cn.hutool.core.date.DateUtil.formatDate(dateCellValue);
                }
                break;
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (IllegalStateException e) {
                    return "Formula";
                }
            default:
                break;
        }
        return "";
    }

    final static HashMap<String, List<String>> getCoachCarMap() {
        HashMap<String, List<String>> map = new HashMap<>();

        map.put("周正清", Arrays.asList("湘LB010学", "湘LB020学", "湘LB005学", "湘LA585学", "湘LJY62学"));
        map.put("王宪辉", Arrays.asList("湘LB716学", "湘LJP68学", "湘LB160学", "湘LA975学", "湘LA936学"));
        map.put("李碧峰", Arrays.asList("湘LB156学", "湘LB876学", "湘LB311学", "湘LJP65学", "湘LB948学"));
        map.put("李旭胜", Arrays.asList("湘LJT62学", "湘LB318学", "湘LJS92学", "湘LB216学", "湘LJS97学"));
        map.put("", Arrays.asList("湘LA681学", "湘LJP79学", "湘LJZ75学", "湘LJS52学", "湘LJP61学", "湘LB319学", "湘LJS91学", "湘L547B1", "湘L862F6", "湘L457C3", "湘L762F6", "湘L712A9", "湘L874B2", "湘L798F6", "湘L810F6", "湘LJP67学", "湘LJZ72学", "湘LJX75学", "湘LJS82学"));
        map.put("曾凡茂", Arrays.asList("湘LA557学"));
        map.put("陈光明", Arrays.asList("湘LA581学"));
        map.put("李泽辉", Arrays.asList("湘LJX52学"));
        map.put("吴广华", Arrays.asList("湘LJX11学"));
        map.put("谷文志", Arrays.asList("湘LJX09学"));
        map.put("范凌志", Arrays.asList("湘LJP71学"));
        map.put("邱周业", Arrays.asList("湘LA007学"));
        map.put("王丽", Arrays.asList("湘LB098学"));
        map.put("欧秀英", Arrays.asList("湘LB008学"));
        map.put("刘齐文", Arrays.asList("湘LA898学"));
        map.put("黄国强 ", Arrays.asList("湘LC736学"));
        map.put("吴志平 ", Arrays.asList("湘LB563学", "湘LB583学"));
        map.put("李骏 ", Arrays.asList("湘LJS79学", "湘LC876学"));
        map.put("杨增军", Arrays.asList("湘LA516学", "湘LA533学", "湘LB839学", "湘LB526学"));
        map.put("黄红卫", Arrays.asList("湘LJZ37学", "湘LJK78学", "湘LJB15学", "湘LC185学"));

        map.put("曹运林", Arrays.asList("湘LJS52学"));
        map.put("邓利华", Arrays.asList("湘LB318学"));
        map.put("邓翔", Arrays.asList("湘LB008学"));
        map.put("邓新华", Arrays.asList("湘LJT62学"));
        map.put("邓友锟", Arrays.asList("湘LJS98学"));
        map.put("高红深", Arrays.asList("湘LJX75学"));
        map.put("黄俊刚", Arrays.asList("湘LJZ72学"));
        map.put("邝新剑", Arrays.asList("湘LB311学"));
        map.put("邝允合", Arrays.asList("湘LJS82学"));
        map.put("李春", Arrays.asList("湘LJS97学"));
        map.put("李江", Arrays.asList("湘LJS91学"));
        map.put("罗发", Arrays.asList("湘LJP71学"));
        map.put("彭铎礼", Arrays.asList("湘LJP68学"));
        map.put("唐亮", Arrays.asList("湘LJP67学"));
        map.put("王凯", Arrays.asList("湘LB839学"));
        map.put("文同亮", Arrays.asList("湘LJB15学"));
        map.put("吴海涛", Arrays.asList("湘LJP79学"));
        map.put("吴林辉", Arrays.asList("湘LB319学"));
        map.put("吴日辉", Arrays.asList("湘LB948学"));
        map.put("吴勇军", Arrays.asList("湘LJP61学"));
        map.put("姚志环", Arrays.asList("湘LC336学"));
        map.put("朱惠鑫", Arrays.asList("湘LB020学"));

        return map;
    }
}