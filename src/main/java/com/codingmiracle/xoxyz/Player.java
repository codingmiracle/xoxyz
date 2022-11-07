package com.codingmiracle.xoxyz;

public class Player {
    private long id;
    private String name;

    public Player(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player() {
        this.name = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }
}
