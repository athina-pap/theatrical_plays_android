package com.example.theatrical_plays.Productions;

import java.io.Serializable;

public class Production implements Serializable {
    private String title;
    private String duration;
    private int id;
    private boolean checked;

    public Production(String title, String duration, int id, boolean checked) {
        this.title = title;
        this.duration = duration;
        this.id = id;
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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
