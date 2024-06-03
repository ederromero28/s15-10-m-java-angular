package s1510.demo.dtos.response;

import org.springframework.context.annotation.Profile;
import s1510.demo.model.Player;

@Profile(value = {"dev", "prod", "test"})

public record PlayerResponse(Long id,
                             String name,
                             String email,
                             String contactEmail,
                             ImageEntityResponse logo,
                             String phone) {

    public PlayerResponse(Player player) {
        this(player.getId(),
                player.getName(),
                player.getEmail(),
                player.getContactEmail(),
                new ImageEntityResponse(
                        player.getImage()),
                player.getPhone());
    }
}
