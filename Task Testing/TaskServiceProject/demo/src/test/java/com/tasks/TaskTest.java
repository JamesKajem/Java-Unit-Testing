package com.tasks;

//JUnit & Test imports
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test //Creation of task w requirements
    public void testTaskCreation() { //Couldn't think of anything creative :(
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        assertEquals("12345", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task description.", task.getDescription());
    }

    //Creation of tasks w/out various attribute requirements fulfilled
    @Test
    public void testTaskCreationInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> { //class exception, pass to new task creation attempt
            new Task(null, "Test Task", "This is a test task description."); // null ID
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Test Task", "This is a test task description.");
        });
    }

    @Test
    public void testTaskCreationInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "This is a test task description."); // null name
        });
        assertThrows(IllegalArgumentException.class, () -> { //long name
            new Task("12345", "This name is way too long to be valid", "This is a test task description.");
        });
    }

    @Test
    public void testTaskCreationInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Task", null); //null description
        });
        assertThrows(IllegalArgumentException.class, () -> { //long description
            new Task("12345", "Test Task", "This description is way too long to be considered valid. It exceeds fifty characters.");
        });
    }

    
    //Setters testing
    @Test
    public void testSetName() { //Valid name
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testSetNameInvalid() { //Null name
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {//long name exception
            task.setName("This name is way too long to be valid");
        });
    }

    @Test
    public void testSetDescription() { //valid description
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    @Test
    public void testSetDescriptionInvalid() { //null description
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
        assertThrows(IllegalArgumentException.class, () -> { //long description exception
            task.setDescription("This description is way too long to be considered valid. It exceeds fifty characters.");
        });
    }
}
