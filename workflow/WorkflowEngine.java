// 导入必要的包

import java.util.List;

// 实现流程引擎的接口
public interface WorkflowEngine {
    // 执行流程
    void execute(List<WorkItem> workItems);

    // 获取流程任务列表
    List<WorkItem> getTaskList();

    // 判断流程是否结束
    boolean isEnd();
}







