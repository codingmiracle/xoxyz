package at.codingmiracle.ticktacktoe.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PlayerResponse {
    private int id;
    private String name;

    public PlayerResponse(int id, String name) {
        setId(id);
        setName(name);
    }
}
