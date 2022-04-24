package com.example.theatrical_plays.Venues;

import java.io.Serializable;
import java.util.ArrayList;

public class Venue implements Serializable {
    int id;
    String address;
    String title;
    Boolean checked;


    public Venue(int id, String address, String title, Boolean checked) {
        this.id = id;
        this.address = address;
        this.title = title;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

}
