package com.codingmiracle.xoxyz;

public class Move {
    private int x;
    private int y;
    private long player;

    public Move(int x, int y, long player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getPlayer() {
        return player;
    }
}
