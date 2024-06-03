package s1510.demo.dtos.response;

import org.springframework.context.annotation.Profile;
import s1510.demo.model.Sport;

@Profile(value = {"dev", "prod", "test"})

public record SportResponse(String name, Integer teamSize, Integer rounds) {

    public SportResponse(Sport sport) {
        this(sport.getName(), sport.getTeamSize(), sport.getRounds());
    }
}
