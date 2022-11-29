package com.codingmiracle.xoxyz;

public class Player {
    private long id;
    private String name;
    private static long idgen = 0;

    public Player(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player() {
        this.name = null; this.id = generateId();
    }

    public Player(String name) {
        this.name = name;
        this.id = generateId();
    }

    public Player(long id) {
        this.id = id;
        this.name = null;
    }

    public static long generateId() {
        return idgen++;
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

    public static boolean isPlayerId(String value) {
        return value.matches("^[0-9]*$");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == Player.class) {
            Player playerObj = (Player)obj;
            return playerObj.getId() == this.id;
        }
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
