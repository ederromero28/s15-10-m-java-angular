package s1510.demo.dtos.response;

import s1510.demo.model.Competition;

public record CompetitionResponse(

        Long id,
        String name,
        int size
) {
    public CompetitionResponse(Competition competition){
        this(
                competition.getId(),
                competition.getName(),
                competition.getStageSize()
                );
    }
}