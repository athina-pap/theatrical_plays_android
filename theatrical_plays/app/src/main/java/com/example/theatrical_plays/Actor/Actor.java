package com.example.theatrical_plays.Actor;

public class Actor {

    String name;
    int id;
    String imageUrl;


    public Actor( String name, String imageUrl, int id) {
        super();
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public Actor() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
