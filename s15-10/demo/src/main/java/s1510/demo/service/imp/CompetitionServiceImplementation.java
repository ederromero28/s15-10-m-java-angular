package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1510.demo.model.Competition;
import s1510.demo.repository.CompetitionRepository;
import s1510.demo.service.CompetitionService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImplementation implements CompetitionService {

    private CompetitionRepository competitionRepository;


    public Competition create(Competition competition) {
        return null;
    }

    @Override
    public Competition update(Competition competitionUpdate) {
        return null;
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
