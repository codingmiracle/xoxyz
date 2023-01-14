package com.codingmiracle.xoxyz;

public class Move {
    private final int x;
    private final int y;
    private final int z;
    private final long player;

    public Move(int x, int y, int z, long player) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public long getPlayer() {
        return player;
    }
}
