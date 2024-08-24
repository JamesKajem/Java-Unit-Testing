package com.tasks;

// Hash imports 
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    //Final instance HashMap variable
    private final Map<String, Task> taskMap = new HashMap<>();

    //Add task method
    public void addTask(Task task) {
        if (taskMap.containsKey(task.getTaskId())) { //Check for unique ID, throws exception in defense against duplicates
            throw new IllegalArgumentException("Task ID already exists.");
        }
        taskMap.put(task.getTaskId(), task); //Add task to map
    }

    //Delete task
    public void deleteTask(String taskId) {
        if (!taskMap.containsKey(taskId)) { //ID Check, opposite effect of throwing exception if the ID is NOT found
            throw new IllegalArgumentException("Task ID not found.");
        }
        taskMap.remove(taskId); // Remove task from map
    }

    //Task field updates
    //Check w Id, and reassign value from newVariable
    public void updateTaskName(String taskId, String newName) {
        Task task = getTask(taskId);
        task.setName(newName);
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = getTask(taskId);
        task.setDescription(newDescription);
    }

    public Task getTask(String taskId) {
        if (!taskMap.containsKey(taskId)) { //Unique IDs require exception on no match
            throw new IllegalArgumentException("Task ID not found.");
        }
        return taskMap.get(taskId);
    }
}
