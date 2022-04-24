package com.example.theatrical_plays.Productions;

public class Events {
    private int id;
    private String priceRange;
    private long date;
    private String title;
    private String venueName;

    public Events(int id, String priceRange, long date, String title, String venueName) {
        this.id = id;
        this.priceRange = priceRange;
        this.date = date;
        this.title = title;
        this.venueName = venueName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
