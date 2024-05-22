package s1510.demo.dtos.response;

import s1510.demo.model.Player;

public record PlayerResponse() {

    public PlayerResponse(Player player){
        this();
    }
}
