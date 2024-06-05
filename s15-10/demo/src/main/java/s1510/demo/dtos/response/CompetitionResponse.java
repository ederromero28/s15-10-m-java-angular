package s1510.demo.dtos.response;

import org.springframework.context.annotation.Profile;
import s1510.demo.model.Award;
import s1510.demo.model.Competition;
import s1510.demo.model.Stage;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Profile(value = {"dev", "prod", "test"})

public record CompetitionResponse(

        Long id,
        String name,
        int stageCount,
        LocalDate dateStart,
        LocalDate dateEnd,
        Set<Award> awards,
        List<Stage> stages
) {
    public CompetitionResponse(Competition competition) {
        this(
                competition.getId(),
                competition.getName(),
                competition.getStageCount(),
                competition.getDateStart(),
                competition.getDateEnd(),
                competition.getAwards(),
                competition.getStages()
                );
    }
}