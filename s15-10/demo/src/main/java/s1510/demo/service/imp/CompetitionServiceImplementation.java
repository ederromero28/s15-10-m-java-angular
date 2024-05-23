package s1510.demo.service.imp;

import s1510.demo.model.Competition;
import s1510.demo.repository.CompetitionRepository;

import java.util.List;
import java.util.Optional;

public class CompetitionServiceImplementation {

    private CompetitionRepository competitionRepository;

    public Competition create(Competition saveCompetition) {
        Competition competition = new Competition();
        competition.
    }

    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    public Optional<Competition> findById(Long competitionId) {
        return competitionRepository.findById(competitionId);
    }





}
