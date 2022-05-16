package com.example.theatrical_plays.Productions;

import java.io.Serializable;

public class Production implements Serializable {
    private String title;
    private String duration, producer, desc, url;
    private int id;
    private boolean checked;

    public Production(String title, String duration, String desc, String producer, int id, boolean checked, String url) {
        this.title = title;
        this.duration = duration;
        this.id = id;
        this.checked = checked;
        this.desc = desc;
        this.producer = producer;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
