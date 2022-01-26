package com.example.theatrical_plays.Productions;

public class Production {
    private String title;
    private String duration;
    private int id;

    public Production(String title, String duration, int id) {
        this.title = title;
        this.duration = duration;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
