package org.launchcode.codingevents.models;

import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {
    private id;
    private static int nextId = 1;

    private String name;
    private String description;

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

}
