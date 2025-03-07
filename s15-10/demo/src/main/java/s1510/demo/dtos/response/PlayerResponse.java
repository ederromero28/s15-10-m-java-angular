package s1510.demo.dtos.response;

import org.springframework.context.annotation.Profile;
import s1510.demo.model.Player;

@Profile(value = {"dev", "prod", "test"})

public record PlayerResponse(Long id,
                             String name,
                             String email,
                             String contactEmail,
                             String phone,
			     String country
			     ) {

    public PlayerResponse(Player player) {
        this(player.getId(),
                player.getName(),
                player.getEmail(),
                player.getContactEmail(),
                player.getPhone(),
		player.getCountry());
    }
}
