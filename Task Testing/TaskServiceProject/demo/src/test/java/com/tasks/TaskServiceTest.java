package com.tasks;

//imports
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    //Lone field
    private TaskService taskService;

    @BeforeEach //setup reset
    public void setUp() { 
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() { //add task successfully
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("12345"));
    }

    @Test
    public void testAddTaskDuplicateId() {//task fail on duplicate IDs
        Task task1 = new Task("12345", "Test Task", "This is a test task description.");
        Task task2 = new Task("12345", "Another Task", "This is another test task description.");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {//exception pass on second task
            taskService.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {//Delete task test
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        taskService.addTask(task);
        taskService.deleteTask("12345");
        assertThrows(IllegalArgumentException.class, () -> {//Throws exception on deleted ID retrieval attempt
            taskService.getTask("12345");
        });
    }

    @Test
    public void testDeleteTaskNonExistent() { //attempts to delete non existent task
        assertThrows(IllegalArgumentException.class, () -> { //no ID, no work
            taskService.deleteTask("12345");
        });
    }

    @Test
    public void testUpdateTaskName() { //Successful name update
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        taskService.addTask(task);
        taskService.updateTaskName("12345", "Updated Name");
        assertEquals("Updated Name", taskService.getTask("12345").getName());
    }

    @Test
    public void testUpdateTaskDescription() { //Successful description update
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        taskService.addTask(task);
        taskService.updateTaskDescription("12345", "Updated Description");
        assertEquals("Updated Description", taskService.getTask("12345").getDescription());
    }

    @Test
    public void testUpdateTaskNonExistent() { //Attempts to update name/description of nonexistent task
        assertThrows(IllegalArgumentException.class, () -> {//name exception
            taskService.updateTaskName("12345", "Updated Name");
        });
        assertThrows(IllegalArgumentException.class, () -> {//description exception
            taskService.updateTaskDescription("12345", "Updated Description");
        });
    }
}
