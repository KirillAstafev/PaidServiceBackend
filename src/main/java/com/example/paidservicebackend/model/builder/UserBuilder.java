package com.example.paidservicebackend.model.builder;

import com.example.paidservicebackend.model.User;

public final class UserBuilder {
    private Integer id;
    private String login;
    private String passwordHash;

    private UserBuilder() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder login(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder passwordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPasswordHash(passwordHash);
        return user;
    }
}
