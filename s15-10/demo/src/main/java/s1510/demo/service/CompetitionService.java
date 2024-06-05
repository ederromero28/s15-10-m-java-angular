package s1510.demo.service;

import org.springframework.context.annotation.Profile;
import s1510.demo.dtos.request.CompetitionRequest;
import s1510.demo.model.Competition;

import java.util.List;
import java.util.Optional;

@Profile(value = {"dev", "prod", "test"})
public interface CompetitionService {

    Competition create(CompetitionRequest competitionCreate);

    Competition update(CompetitionRequest competitionUpdate);

    Competition delete(Long competitionId);

    boolean exists(Long id);

    List<Competition> findAll();

    Optional<Competition> findById(Long competitionId);

}