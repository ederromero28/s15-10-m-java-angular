package s1510.demo.dtos.response;

import s1510.demo.model.Sport;

public record SportResponse(String name, Integer teamSize, Integer rounds) {

    public SportResponse (Sport sport){
        this(sport.getName(), sport.getTeamSize(), sport.getRounds());
    }
}
