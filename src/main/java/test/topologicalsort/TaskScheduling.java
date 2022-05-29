package test.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TaskScheduling {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        //
        // Task task0 = new Task(0, List.of());
        // Task task1 = new Task(1, List.of());
        // Task task2 = new Task(2, List.of(3));
        // Task task3 = new Task(3, List.of(1));
        // Task task4 = new Task(4, List.of(0,1));
        // Task task5 = new Task(5, List.of(0,2));
        //
        // tasks.add(task0);
        // tasks.add(task1);
        // tasks.add(task2);
        // tasks.add(task3);
        // tasks.add(task4);
        // tasks.add(task5);


        Task task0 = new Task(0, List.of(1));
        Task task1 = new Task(1, List.of(2));
        Task task2 = new Task(2, List.of());

        tasks.add(task0);
        tasks.add(task1);
        tasks.add(task2);

        List<Task> scheduledTasks = scheduleTasks(tasks);

        scheduledTasks.forEach(task -> System.out.print(task.taskId + ","));

    }

    private static List<Task> scheduleTasks(final List<Task> tasks) {
        if(tasks == null || tasks.isEmpty())
            return tasks;

        Map<Integer, Task> taskIdToTaskMap = new HashMap<>();
        Map<Task, List<Task>> adjacencyList = new HashMap<>();
        Map<Task, Integer> inDegreeMap = new HashMap<>();

        tasks.forEach(task -> {
            taskIdToTaskMap.put(task.taskId, task);
            inDegreeMap.put(task, 0);
        });

        final List<Task> dependentTasks = new ArrayList<>();
        tasks.forEach(task -> {
            final List<Integer> dependentTaskIds = task.dependentTaskIds;

            dependentTaskIds.forEach(dependentTaskId -> {
                Task dependentTask = taskIdToTaskMap.get(dependentTaskId);
                inDegreeMap.put(dependentTask, inDegreeMap.get(dependentTask) + 1);
                dependentTasks.add(dependentTask);
            });
            adjacencyList.put(task, dependentTasks);
        });

        //Add the source tasks to queue
        Queue<Task> queue = new LinkedList<>();

        adjacencyList.forEach((task, dependents) -> {
            if(isSource(task, inDegreeMap))
                queue.add(task);
        });

        List<Task> scheduledTasks = new ArrayList<>();
        while (!queue.isEmpty()){
            Task curr = queue.poll();
            scheduledTasks.add(curr);

            List<Task> dependents = adjacencyList.get(curr);
            dependents.forEach(dependent -> {
                Integer currInDegree = inDegreeMap.get(dependent);
                Integer newInDegree = currInDegree - 1;
                inDegreeMap.put(dependent, newInDegree);
                if(newInDegree == 0){
                    queue.add(dependent);
                }
            });
        }

        // Graph has cycle. Cannot schedule
        if(scheduledTasks.size() != tasks.size())
            return List.of(new Task(-1, null));

        return scheduledTasks;

    }

    private static boolean isSource(Task task, Map<Task, Integer> inDegreeMap){
        return inDegreeMap.get(task) == 0;
    }

    private static class Task{
        int taskId;
        // List of tasks on which current task depends on i.e all these dependent tasks should be run first before current task can be started
        List<Integer> dependentTaskIds;

        public Task(int taskId, List<Integer> dependentTaskIds){
            this.taskId = taskId;
            this.dependentTaskIds = dependentTaskIds;
        }

        @Override
        public String toString(){
            return "" + this.taskId;
        }
    }
}
