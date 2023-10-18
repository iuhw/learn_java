// 第二种情况，任务需要传入参数，并且参数数量是固定的
public class TaskWorkItem extends WorkItem {
    // 构造方法，传入任务名称、参数名称和参数数量
    public TaskWorkItem(String name, String paramName, int argsNum) {
        super(name, argsNum);
    }

    // 是否是初始任务
    @Override
    public boolean isInitTask() {
        return false;
    }

    // 获取参数
    public String getParamValue(String paramName) {
        switch (getTaskType()) {
            case 1:
                // 领导审批
                return "领导审批";
            case 2:
                // 部门经理审批
                return "部门经理审批";
            case 3:
                // 部门主管审批
                return "部门主管审批";
        }
        return null;
    }
}