package s1510.demo.dtos.response;

import org.springframework.context.annotation.Profile;
import s1510.demo.model.Sport;

@Profile(value = {"dev", "prod", "test"})

public record SportResponse(
        Long id,
        String name,
        Integer teamSize,
        Integer rounds,
        Boolean status) {

    public SportResponse(Sport sport){
        this(sport.getId() ,sport.getName(), sport.getTeamSize(), sport.getRounds(), sport.getStatus());
    }
}
