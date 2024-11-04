package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Buy groceries");
        assertEquals("Buy groceries", task.getDescription());
        assertFalse(task.isCompleted());
    }

    @Test
    public void testMarkAsCompleted() {
        Task task = new Task("Do homework");
        task.markAsCompleted();
        assertTrue(task.isCompleted());
    }

    @Test
    public void testToString() {
        Task task = new Task("Read a book");
        assertEquals("Read a book (Status: Pending)", task.toString());
        task.markAsCompleted();
        assertEquals("Read a book (Status: Completed)", task.toString());
    }
}

