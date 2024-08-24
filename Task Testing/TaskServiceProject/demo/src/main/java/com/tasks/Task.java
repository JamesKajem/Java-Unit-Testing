package com.tasks;

public class Task {
    //Instance Variables
    private final String taskId; //Final string, task ID is only assigned once
    private String name;
    private String description;

    //Constructor
    public Task(String taskId, String name, String description) {
        //Varibles matched against requirements w exceptions
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must be non-null and no longer than 10 characters.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and no longer than 20 characters.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and no longer than 50 characters.");
        }
        //Return prep
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    //Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setName(String name) {
        if (name == null || name.length() > 20) { //Requirement check w exception
            throw new IllegalArgumentException("Name must be non-null and no longer than 20 characters.");
        }
        this.name = name;
    }


    public void setDescription(String description) {
        if (description == null || description.length() > 50) { //Requirement check w exception
            throw new IllegalArgumentException("Description must be non-null and no longer than 50 characters.");
        }
        this.description = description;
    }
}
