package s1510.demo.service;

import s1510.demo.model.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {

    List<Competition> findAll();
    Optional<Competition> findById(Long competitionId);
    ResponseEnttty<Competition> de

}
