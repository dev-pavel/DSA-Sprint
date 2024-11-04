package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void testAddTask() {
        TaskList taskList = new TaskList();
        taskList.addTask("Finish project");

        // Check if the task is added by printing it out or accessing it.
        assertEquals("Finish project (Status: Pending)", taskList.getHead().toString());
    }

    @Test
    public void testMarkTaskAsCompleted() {
        TaskList taskList = new TaskList();
        taskList.addTask("Write tests");

        assertTrue(taskList.markTaskAsCompleted("Write tests"));
        assertTrue(taskList.getHead().isCompleted());

        // Try to mark a non-existent task
        assertFalse(taskList.markTaskAsCompleted("Non-existent task"));
    }

    @Test
    public void testPrintTasks() {
        TaskList taskList = new TaskList();
        taskList.addTask("Task 1");
        taskList.addTask("Task 2");
        taskList.markTaskAsCompleted("Task 1");

        // Printing tasks can be validated by checking the toString representation of each task
        assertEquals("Task 1 (Status: Completed)", taskList.getHead().toString());
        assertEquals("Task 2 (Status: Pending)", taskList.getHead().getNext().toString());
    }
}

