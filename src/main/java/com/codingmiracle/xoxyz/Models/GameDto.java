package com.codingmiracle.xoxyz.Models;

public class GameDto {

    private long id;
    private PlayerDto host;
    private PlayerDto guest;
    private boolean active;

    private PlayerDto winner;

    public GameDto(PlayerDto host) {
        this.setHost(host);
        this.setGuest(null);
    }

    public GameDto(long id, PlayerDto host) {
        this.setId(id);
        this.setHost(host);
        this.setGuest(null);
    }

    public GameDto(long id, PlayerDto host, PlayerDto guest, PlayerDto winner) {
        this.setId(id);
        this.setHost(host);
        this.setGuest(null);
        this.setWinner(winner);
    }

    public GameDto(long id, PlayerDto host, PlayerDto guest, boolean active, PlayerDto winner) {
        this.setId(id);
        this.setHost(host);
        this.setGuest(null);
        this.setActive(active);
        this.setWinner(winner);
    }

    public boolean isFull() {
        return this.guest != null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == GameDto.class) {
            GameDto gameDto = (GameDto) obj;
            return this.getId() == gameDto.getId();
        }
        return false;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long getId() {
        return this.id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PlayerDto getHost() {
        return host;
    }

    public void setHost(PlayerDto host) {
        this.host = host;
    }

    private void setGuest(PlayerDto guest) {
        this.guest = guest;
    }

    public PlayerDto getGuest() {
        return guest;
    }

    public void setWinner(PlayerDto winner) {
        this.winner = winner;
    }

    public PlayerDto getWinner() {
        return winner;
    }
}
