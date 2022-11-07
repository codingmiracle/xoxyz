package com.codingmiracle.xoxyz;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private long id;
    private Player p1;
    private Player p2;
    private List field;
    private boolean p1turn;

    public Game() {
        this.p1 = null;
        this.p2 = null;
        this.p1turn = true;
        field = new ArrayList<Integer>();
    }

    public Game(long id) {
        this.id = id;
        this.p2 = null;
        this.p1turn = true;
        field = new ArrayList<Integer>();
    }

    public Game(Player p1) {
        this.p1 = p1;
        this.p2 = null;
        this.p1turn = true;
    }

    public long getId() {
        return id;
    }

        public boolean JoinPlayer(Player p) {
        if(p1 == null) {
            p1 = p;
        } else if(p2 == null) {
            p2 = p;
            return true;
        }
        return false;
    }

    public int set(int x, int y, int z) {

        return -1;
    }


}
