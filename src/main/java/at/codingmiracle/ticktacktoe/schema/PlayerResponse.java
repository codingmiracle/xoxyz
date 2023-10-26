package at.codingmiracle.ticktacktoe.schema;

import lombok.*;

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
