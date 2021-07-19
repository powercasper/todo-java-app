package com.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {
    private static final List<Task> toDoList = new ArrayList<>();

    public static int incrementId(int id) {
        return id + 1;
    }

    /**
     * method to get all tasks
     * @return toDoList
     */
    public static List<Task> getToDoList() {
        return toDoList;
    }

    /**
     * method to get all tasks
     * @return toDoList
     */
    public static int getToDoListLength() {
        return getToDoList().size();
    }

    /**
     * task i will be generated, task will be updated with incremented by 1 id
     * @param task com.ToDo.Task that need to be added
     */
    public static void addToDoList(Task task) {
        int toDoListLength = getToDoListLength();
        if(toDoListLength >= 0) {
            int generatedTaskId = incrementId(toDoListLength);
            task.setId(generatedTaskId);
        }
        toDoList.add(task);
    }

    public static List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task: getToDoList()) {
            if(task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    public static List<Task> getUnCompletedTasks() {
        List<Task> unCompletedTasks = new ArrayList<>();
        for (Task task: getToDoList()) {
            if(!task.isCompleted()) {
                unCompletedTasks.add(task);
            }
        }
        return unCompletedTasks;
    }

    public static void unCompleteTaskById(int taskId) {
        List<Task> allTasks = getToDoList();
        for (Task task: allTasks) {
            if(taskId == task.getId()) {
                task.setUnCompleted();
                task.setModified(true);
            }
        }
    }

    public static Task createTask1() {
        String taskTitle = "Wash the Dishes";
        String taskDescription = "take cup and wash it";
        boolean isTaskCompleted = false;
        boolean isTaskModified = false;
        return new Task(taskTitle, taskDescription, isTaskCompleted, isTaskModified);
    }

    public static Task createTask2() {
        String taskTitle = "Wash the Car";
        String taskDescription = "take ar to car wash service";
        boolean isTaskCompleted = false;
        boolean isTaskModified = false;

        return new Task(taskTitle, taskDescription, isTaskCompleted, isTaskModified);
    }

    public static Task createTask3() {
        String taskTitle = "Mop the floor";
        String taskDescription = "put water to the bucket and use TRIAPKY";
        boolean isTaskCompleted = false;
        boolean isTaskModified = false;

        return new Task(taskTitle, taskDescription, isTaskCompleted, isTaskModified);
    }

    public static void main(String[] args) {
        System.out.println("Hello PPL");

        // посмотреть список всех задач
        // Should be empty
        List<Task> tasksList = getToDoList();
        System.out.println("tasksList: -> " + tasksList);

        // Create 3 tasks. all ill be generate with default id.
        // until it will be added to list of todo tasks
        Task taskOne =  createTask1();
        taskOne.printTaskDetails();
        Task taskTwo =  createTask2();
        taskTwo.printTaskDetails();
        Task taskThree =  createTask3();
        taskTwo.printTaskDetails();

        // добавить задачу
        // Should add task to task list.
        addToDoList(taskOne);
        System.out.println("tasksList length should be 1: Received " + tasksList.size());
        System.out.println("task1 id number: should be 1: Received " + taskOne.getId());

        addToDoList(taskTwo);
        System.out.println("tasksList length should be 2: Received " + tasksList.size());
        System.out.println("task 2 id number: should be 2: Received " + tasksList.get((tasksList.size() - 1)).getId());

        addToDoList(taskThree);
        System.out.println("tasksList length should be 3: Received " + tasksList.size());
        System.out.println("task 3 id number: should be 3: Received " + tasksList.get((tasksList.size() - 1)).getId());


        // Complete task and verify if task was completed
        System.out.println("task 2 should not be completed: expect false" + taskTwo.isCompleted());
        System.out.println("task 2 should not be Modified: expect false" + taskTwo.isModified());
        taskTwo.completeTask();
        System.out.println("task 2 should be completed: expect true --> " + taskTwo.isCompleted());
        System.out.println("task 2 should be Modified: expect false --> " + taskTwo.isModified());

        // посмотреть список выполненых задач
        // should print out only completed task.
        System.out.println(
            "Total Qty of completed tasks should be 1. Received -> " + getCompletedTasks().size() +
            "\nOnly task 2 should be completed: " + getCompletedTasks() +
            "\ntask id: " + getCompletedTasks().get(0).getId() +
            "\ntask Completed: " + getCompletedTasks().get(0).isCompleted()
        );

        // посмотреть список не выполненых задач
        System.out.println("Should be 2 Uncompleted Tasks: " + getUnCompletedTasks().size());
        System.out.println("Uncompleted Tasks: " + getUnCompletedTasks());
        System.out.println("Should be Uncompleted Tasks with id 1: " + taskOne.getId() + " " + taskOne.isCompleted());
        System.out.println("Should be Uncompleted Tasks with id 3: " + taskThree.getId() + " " + taskThree.isCompleted());


        // отметить задачу как выполнению (по номеру)
        System.out.println("task 2 should be completed: Received " + taskTwo.isCompleted());
        unCompleteTaskById(2);
        System.out.println("task 2 should not be completed: Received " + taskTwo.isCompleted());
        taskTwo.completeTask();


        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to add task? ");
        String addTask = scanner.nextLine();
        System.out.println("Do you want to add task? " + addTask);
        if(addTask.equals("yes")) {
            Task taskToAdd = new Task();
            System.out.println("Enter Task Title: ");
            String taskTitle = scanner.nextLine();
            taskToAdd.setTitle(taskTitle);

            System.out.println("Enter Task Description: ");
            String taskDescription = scanner.nextLine();
            taskToAdd.setDescription(taskDescription);

            System.out.println("Enter if task is completed: yes or no");
            String taskIsComplete = scanner.nextLine();
            if(taskIsComplete.equals("yes")) {
                taskToAdd.setCompleted();
            } else {
                taskToAdd.setUnCompleted();
            }
            taskToAdd.setModified(false);

            addToDoList(taskToAdd);
            System.out.println("TASK ADDED");
            taskToAdd.printTaskDetails();
        }

        System.out.println("Do you want to see all completed TASKS? yes/no");
        String seeCompletedTasks = scanner.nextLine();
        if(seeCompletedTasks.equals("yes")) {
            for (Task completedTask : getCompletedTasks()) {
                completedTask.printTaskDetails();
            }
        }

        System.out.println("Do you want to see all Not completed TASKS? yes/no");
        String seeNotCompletedTasks = scanner.nextLine();
        if(seeNotCompletedTasks.equals("yes")) {
            for (Task unCompletedTask : getUnCompletedTasks()) {
                unCompletedTask.printTaskDetails();
            }
        }

        System.out.println("Do you want to uncomplete task?: ");
        String uncompleteTask = scanner.nextLine();
        if(uncompleteTask.equals("yes")) {
            System.out.println("tasks that can be uncompletd: ");
            List<Integer> listOfTask = new ArrayList<>();
            for (Task completedTask : getCompletedTasks()) {
                int taskId = completedTask.getId();
                listOfTask.add(taskId);
                System.out.println("tasks id: " + taskId);
            }
            System.out.println("Provide id of the task you want to uncomplete: ");
            int taskIdToUncomplete = scanner.nextInt();
            if(listOfTask.contains(taskIdToUncomplete)) {
                unCompleteTaskById(taskIdToUncomplete);
                System.out.println("TASK WITH ID: " + taskIdToUncomplete + " Uncompleted");
            }
        }
    }
}
