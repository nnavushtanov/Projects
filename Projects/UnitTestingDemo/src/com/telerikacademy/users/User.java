package com.telerikacademy.users;

import static com.telerikacademy.users.UserConstants.USERNAME_MAX_LENGTH;
import static com.telerikacademy.users.UserConstants.USERNAME_MIN_LENGTH;

public class User {

    private String username;
    
    public User(String username) {
        setUsername(username);
    }
    
    public String getUsername() {
        return username;
    }
    
    private void setUsername(String username) {
        if (username == null) {
            throw new NullPointerException();
        } else if (username.length() > USERNAME_MAX_LENGTH ||
                username.length() < USERNAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.username = username;
    }
    
}
