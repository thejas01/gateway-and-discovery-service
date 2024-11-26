package com.example.user_service.model;

public class User {
    private int id;
    private String name;

    // Constructors, Getters, and Setters
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}