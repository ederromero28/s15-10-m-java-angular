package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.request.CompetitionRequest;
import s1510.demo.model.Competition;
import s1510.demo.repository.CompetitionRepository;
import s1510.demo.service.CompetitionService;

import java.util.List;
import java.util.Optional;

@Service
@Profile(value = {"dev", "prod", "test"})
@RequiredArgsConstructor
public class CompetitionServiceImplementation implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;


    @Override
    public Competition create(CompetitionRequest competitionCreate) {
        Competition competition = new Competition();
        competition.setName(competitionCreate.name());
        competition.setStageSize(competitionCreate.size());
        return competitionRepository.save(competition);
    }

    @Override
    public Competition update(CompetitionRequest competitionUpdate) {
        Competition competition = new Competition();
        competition.setName(competitionUpdate.name());
        competition.setStageSize(competitionUpdate.size());
        return competitionRepository.save(competition);
    }

    @Override
    public Competition delete(Long competitionId) {
        Competition competition = competitionRepository
                .getReferenceById(competitionId);
        competitionRepository.deleteById(competitionId);
        return competition;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    public Optional<Competition> findById(Long competitionId) {
        return competitionRepository.findById(competitionId);
    }


}
