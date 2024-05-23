package s1510.demo.service;

import s1510.demo.dtos.request.StageRequest;
import s1510.demo.model.Stage;

import java.util.List;
import java.util.Optional;

public interface StageService {
    List<Stage> listAll();
    Optional<Stage> findById(Long stageId);
    Stage save(StageRequest saveStage);
    Stage delete(Long stageId);
    boolean existsById(Long id);
}
