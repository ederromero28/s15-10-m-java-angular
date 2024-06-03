package s1510.demo.dtos.response;

import org.springframework.context.annotation.Profile;
import s1510.demo.model.Competition;

@Profile(value = {"dev", "prod", "test"})

public record CompetitionResponse(

        Long id,
        String name,
        int size
) {
    public CompetitionResponse(Competition competition) {
        this(
                competition.getId(),
                competition.getName(),
                competition.getStageSize()
        );
    }
}