package com.codingmiracle.xoxyz;

import java.util.Set;

public class Game {
    private long id;
    private Player host;
    private Player guest;
    private Set<Move> moves;
    private boolean hostturn;

    public Game() {
        this.host = null;
        this.guest = null;
        this.hostturn = true;
    }

    public Game(long id) {
        this.id = id;
        this.guest = null;
        this.hostturn = true;
    }

    public Game(Player host) {
        this.host = host;
        this.guest = null;
        this.hostturn = true;
    }

    public long getId() {
        return id;
    }

    public boolean JoinPlayer(Player p) {
        if(host == null) {
            host = p;
        } else if(guest == null) {
            guest = p;
            return true;
        }
        return false;
    }

    public int set(int x, int y, int z) {

        return -1;
    }

    public boolean isJoinable() {
        return host != null && guest != null;
    }

    private boolean isEqual() {
        return true;
    }

    private boolean isP1Win() {
        return true;
    }

}
