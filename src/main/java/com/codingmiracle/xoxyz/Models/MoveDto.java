package com.codingmiracle.xoxyz.Models;

public class MoveDto {
    private final int x;
    private final int y;
    private final int z;
    private final long player;

    public MoveDto(int x, int y, int z, long playerId) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = playerId;
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

    public long getPlayerId() {
        return player;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == MoveDto.class) {
            MoveDto moveDto = (MoveDto) obj;
            return moveDto.getX() == this.getX() && moveDto.getY() == this.getY() && moveDto.getZ() == this.getZ() && moveDto.getPlayerId() == this.getPlayerId();
        }
        return super.equals(obj);
    }
}
