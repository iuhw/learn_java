package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author:
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {

//        printRetainURISet();

        printRetainURICount();
    }

    private static void printRetainURICount() throws IOException {
//        List<String> list1 = getURIList("C:\\Users\\yxkj\\Desktop\\1.log");
//        List<String> list2 = getURIList("C:\\Users\\yxkj\\Desktop\\2.log");
        List<String> list3 = getURIList("C:\\Users\\yxkj\\Desktop\\3.log");

        ConcurrentHashMap<String, Long> URICountMap = new ConcurrentHashMap<>();

        list3.stream().forEach(s -> {
//            if (list2.contains(s)) {
                URICountMap.put(s, URICountMap.getOrDefault(s, 0L) + 1);
//            }
        });

        URICountMap.forEach((k, v) -> {
            System.out.println(k + " _ " + v);
        });
        System.out.println("------");
        sortMapByValue(URICountMap);
    }

    private static void sortMapByValue(ConcurrentHashMap<String, Long> uriCountMap) {
        List<Map.Entry<String, Long>> list = new ArrayList<>(uriCountMap.entrySet());

        Collections.sort(list, (o1, o2) -> (int) (o2.getValue() - o1.getValue()));

        LinkedHashMap<String, Long> resMap = new LinkedHashMap<>();
        list.forEach(ele -> resMap.put(ele.getKey(), ele.getValue()));

        resMap.forEach((k, v) -> System.out.println(k + " _ " + v));
    }

    private static void printRetainURISet() throws IOException {
//        HashSet<String> set1 = getURISet("C:\\Users\\yxkj\\Desktop\\1.log");
//        HashSet<String> set2 = getURISet("C:\\Users\\yxkj\\Desktop\\2.log");
        HashSet<String> set3 = getURISet("C:\\Users\\yxkj\\Desktop\\3.log");

        HashSet<String> res = new HashSet<>();
        res.addAll(set3);
//        res.retainAll(set2);

        res.stream().forEach(s -> System.out.println(s));
    }

    static HashSet<String> getURISet(String filePath) throws IOException {
        HashSet<String> uri = new HashSet<>();
        List<String> contextList = contextList(filePath);
        if (contextList != null && contextList.size() > 0) {
            contextList.stream().forEach(s -> {
                if (s.indexOf("ReqURI") > 0) {
                    String substring = s.substring(s.indexOf("ReqURI"), s.indexOf("protocol") - 1);
                    uri.add(substring);
                }
            });
        }
        return uri;
    }

    static List<String> getURIList(String filePath) throws IOException {
        List<String> uri = new LinkedList<>();
        List<String> contextList = contextList(filePath);
        if (contextList != null && contextList.size() > 0) {
            contextList.stream().forEach(s -> {
                if (s.indexOf("ReqURI") > 0) {
                    String substring = s.substring(s.indexOf("ReqURI"), s.indexOf("protocol") - 1);
                    uri.add(substring);
                }
            });
        }
        return uri;
    }

    static List<String> contextList(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        BufferedReader reader = Files.newBufferedReader(path);
        Stream<String> stream = reader.lines();

        List<String> contextList = stream.collect(Collectors.toList());

        stream.close();

        return contextList;
    }
}
