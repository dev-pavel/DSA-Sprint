package com.keyin;

public class TaskList {
    private Task head;

    public TaskList() {
        this.head = null;
    }

    public Task getHead() {
        return head;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newTask);
        }
    }

    public boolean markTaskAsCompleted(String description) {
        Task current = head;
        while (current != null) {
            if (current.getDescription().equals(description)) {
                current.markAsCompleted();
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void printTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}

