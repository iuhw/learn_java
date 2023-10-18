// 具体的任务子类
// 第一种情况，任务是一个动作，无需传入参数
public class ActionWorkItem extends WorkItem {
    // 构造方法，传入任务名称和任务类型
    public ActionWorkItem(String name, int taskType) {
        super(name, taskType);
    }

    // 是否是初始任务
    @Override
    public boolean isInitTask() {
        return false;
    }
}