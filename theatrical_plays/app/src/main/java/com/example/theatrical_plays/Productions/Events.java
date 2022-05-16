package com.example.theatrical_plays.Productions;

public class Events {
    private int id;
    private String priceRange;
    private String VenueName, title, address;


    public Events(int id, String priceRange, String title, String address, String VenueName) {
        this.id = id;
        this.priceRange = priceRange;
        this.title = title;
        this.address = address;
        this.VenueName = VenueName;


    }

    public String getVenueName() {
        return VenueName;
    }

    public void setVenueName(String venueName) {
        VenueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
