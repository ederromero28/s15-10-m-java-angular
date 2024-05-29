package s1510.demo.service;

import s1510.demo.dtos.request.StageRequest;
import s1510.demo.dtos.response.StageResponse;

import java.util.List;
import java.util.Optional;

public interface StageService {
    List<StageResponse> listAll();
    Optional<StageResponse> findById(Long stageId);
    StageResponse save(StageRequest saveStage);
    StageResponse delete(Long stageId);
    boolean existsById(Long id);
}
