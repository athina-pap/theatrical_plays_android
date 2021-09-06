package com.example.theatrical_plays.Actor;

public class Bio {

    String role, title;

    public Bio(String role, String title) {
        this.role = role;
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
