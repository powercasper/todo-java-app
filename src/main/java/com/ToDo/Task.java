package com.ToDo;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean isCompleted;
    private boolean isModified;

    public Task(String title, String description, boolean isCompleted, boolean isModified) {
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
        this.isModified = isModified;
    }

    public Task(){}

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean isTaskModified) {
        isModified = isTaskModified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted() {
        isCompleted = true;
    }

    public void completeTask() {
        setCompleted();
        setModified(true);
    }

    public void setUnCompleted() {
        isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printTaskDetails() {
        System.out.println(
            "com.ToDo.Task Details: \n" +
            "com.ToDo.Task ID: " + getId() + ",\n" +
            "com.ToDo.Task Title: " + getTitle() + ",\n" +
            "com.ToDo.Task Description: " + getDescription() + ",\n" +
            "Is com.ToDo.Task Completed: " + isCompleted() + ",\n" +
            "Is com.ToDo.Task Modified: " + isModified() + ",\n"
        );
    }

}