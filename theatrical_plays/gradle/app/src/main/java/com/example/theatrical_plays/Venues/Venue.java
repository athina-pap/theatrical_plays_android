package com.example.theatrical_plays.Venues;

import java.io.Serializable;
import java.util.ArrayList;

public class Venue implements Serializable {
    int id;
    String address;
    String title;
    public Venue(int id, String address, String title) {
        this.id = id;
        this.address = address;
        this.title = title;
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
}
