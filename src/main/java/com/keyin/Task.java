package com.keyin;

public class Task {
    private final String description;
    private boolean isCompleted;
    private Task next;  // Reference to the next task in the linked list

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
        this.next = null;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Task getNext() {
        return next;
    }

    public void setNext(Task next) {
        this.next = next;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return description + " (Status: " + (isCompleted ? "Completed" : "Pending") + ")";
    }
}
