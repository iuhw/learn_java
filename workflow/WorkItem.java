// 实现具体的任务类
// 任务类是一个抽象类，派生出不同的任务子类
public abstract class WorkItem {
    // 任务类型
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;

    // 任务名称
    private String name;

    // 任务类型
    private int taskType;

    // 构造方法，传入任务名称和任务类型
    public WorkItem(String name, int taskType) {
        this.name = name;
        this.taskType = taskType;
    }

    // 获取任务名称
    public String getName() {
        return name;
    }

    // 获取任务类型
    public int getTaskType() {
        return taskType;
    }

    // 是否是初始任务
    public abstract boolean isInitTask();
}