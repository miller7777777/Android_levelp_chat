package ru.levelp.chat;


public class Contact {

    private String id;
    private String name;
    private String description;

    public Contact(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
