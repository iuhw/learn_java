import java.util.ArrayList;
import java.util.List;

// 实现具体的工作流引擎类
public class WorkflowEngineImpl implements WorkflowEngine {
    // 存储流程任务
    private List<WorkItem> taskList = new ArrayList<>();

    // 构造方法，添加初始任务
    public WorkflowEngineImpl() {
        taskList.add(new ActionWorkItem("领导审批", 1));
        taskList.add(new ActionWorkItem("部门经理审批", 2));
        taskList.add(new ActionWorkItem("部门主管审批", 3));
    }

    // 执行流程
    @Override
    public void execute(List<WorkItem> workItems) {
        for (WorkItem workItem : workItems) {
            switch (workItem.getTaskType()) {
                case 1:
                    // 领导审批
                    processRequest(workItem);
                    break;
                case 2:
                    // 部门经理审批
                    processRequest(workItem);
                    break;
                case 3:
                    // 部门主管审批
                    processRequest(workItem);
                    break;
            }
        }
    }

    // 获取流程任务列表
    @Override
    public List<WorkItem> getTaskList() {
        return taskList;
    }

    // 判断流程是否结束
    @Override
    public boolean isEnd() {
        return taskList.isEmpty();
    }

    // 处理领导审批请求
     void processRequest(WorkItem workItem) {
        // TODO: 处理领导审批请求

        System.out.println("领导审批完成！");
    }

    // 处理部门经理审批请求
     void processRequest(WorkItem workItem) {
        // TODO: 处理部门经理审批请求

        System.out.println("部门经理审批完成！");
    }

    // 处理部门主管审批请求
     void processRequest(WorkItem workItem) {
        // TODO: 处理部门主管审批请求

        System.out.println("部门主管审批完成！");
    }
}