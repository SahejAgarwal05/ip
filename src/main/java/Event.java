package main.java;

import main.java.ToDo;

public class Event extends ToDo {
    private String from;
    private String to;

    public Event(String name, String from, String to) {
        super(name);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        if (this.completed) {
            return "[X][E] " + this.name + " (from: " + this.from + " to: " + this.to + ")";
        } else {
            return "[ ][E] " + this.name + " (from: " + this.from + " to: " + this.to + ")";
        }
    }
}