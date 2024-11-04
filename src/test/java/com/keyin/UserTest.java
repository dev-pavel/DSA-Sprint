package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User("Alice");
        assertEquals("Alice", user.getName());
    }

    @Test
    public void testAddTask() {
        User user = new User("Bob");
        user.addTask("Clean the house");

        // Validate task addition by checking the tasks in TaskList
        assertEquals("Clean the house (Status: Pending)", user.getTaskList().getHead().toString());
    }

    @Test
    public void testMarkTaskAsCompleted() {
        User user = new User("Charlie");
        user.addTask("Pay bills");

        // Mark the task as completed and verify
        assertTrue(user.markTaskAsCompleted("Pay bills"));
        assertTrue(user.getTaskList().getHead().isCompleted());

        // Try marking a non-existent task as completed
        assertFalse(user.markTaskAsCompleted("Non-existent task"));
    }

    @Test
    public void testPrintTasks() {
        User user = new User("Diana");
        user.addTask("Go for a walk");
        user.addTask("Read a book");

        // Ensure that tasks are correctly printed in the right order
        Task headTask = user.getTaskList().getHead();
        assertEquals("Go for a walk (Status: Pending)", headTask.toString());
        assertEquals("Read a book (Status: Pending)", headTask.getNext().toString());
    }
}
