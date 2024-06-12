package s1510.demo.dtos.response;

import org.springframework.context.annotation.Profile;
import s1510.demo.model.Team;

import java.util.List;

@Profile(value = {"dev", "prod", "test"})

public record TeamResponse(Long id,
                           String name,
                           String email,
                           List<String> awards,
                           ImageEntityResponse image,
                           List<PlayerResponse> players) {

    public TeamResponse(Team team, List<String> awards) {
        this(team.getId(),
                team.getName(),
                team.getEmail(),
                awards,
                new ImageEntityResponse(team.getLogo()),
                team.getPlayers().stream().map(PlayerResponse::new).toList());
    }

    public TeamResponse(Team team) {
        this(team.getId(),
                team.getName(),
                team.getEmail(),
                null,
                null,
//                new ImageEntityResponse(team.getLogo()),
                null
//                team.getPlayers().stream().map(PlayerResponse::new).toList()
        );
    }

}
