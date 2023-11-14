package at.codingmiracle.ticktacktoe.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PlayerDto {
    private String name;

    public PlayerDto(String name) {
        setName(name);
    }
}
