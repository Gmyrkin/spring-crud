package ru.gmyrkin.crud.model;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private int old;

    public User(String firstName, String lastName, int old) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.old = old;
    }
}
