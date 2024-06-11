package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s1510.demo.controller.StageController;
import s1510.demo.dtos.request.CompetitionRequest;
import s1510.demo.dtos.request.StageRequest;
import s1510.demo.enums.StageType;
import s1510.demo.model.Competition;
import s1510.demo.model.Stage;
import s1510.demo.repository.CompetitionRepository;
import s1510.demo.repository.StageRepository;
import s1510.demo.service.CompetitionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile(value = {"dev", "prod", "test"})
@RequiredArgsConstructor
public class CompetitionServiceImplementation implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private StageRepository stageRepository;


    @Override
    public Competition create(CompetitionRequest competitionCreate) {
        Competition competition = new Competition();
        competition.setName(competitionCreate.name());
        competition.setStageCount(competitionCreate.stageCount());
        competition.setDateStart(competitionCreate.dateStart());
        competition.setDateEnd(competitionCreate.dateEnd());
//        competition.setAwards(competitionCreate.awards());
//        competition.setStages(competitionCreate.stages());
        for (int i = 0; i < competition.getStageCount(); i++) {
            Stage stage = new Stage();
            stageRepository.saveAndFlush(stage);
            competition.addStage(stage);
        }

        return competitionRepository.save(competition);
    }

    @Override
    public Competition update(CompetitionRequest competitionUpdate) {
        Competition competition = new Competition();
        competition.setName(competitionUpdate.name());
        competition.setStageCount(competitionUpdate.stageCount());
        competition.setDateStart(competitionUpdate.dateStart());
        competition.setDateEnd(competitionUpdate.dateEnd());
//        competition.setAwards(competitionUpdate.awards());
//        competition.setStages(competitionUpdate.stages());
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
