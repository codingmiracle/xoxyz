package com.codingmiracle.xoxyz.Models;

public class PlayerDto {
    private long id;
    private String name;

    public PlayerDto(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public PlayerDto(long id) {
        this.setId(id);
        this.setName(null);
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
        if(obj.getClass() == PlayerDto.class) {
            PlayerDto playerDtoObj = (PlayerDto)obj;
            return playerDtoObj.getId() == this.id;
        }
        return super.equals(obj);
    }
}
