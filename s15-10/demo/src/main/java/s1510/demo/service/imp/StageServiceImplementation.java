package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.request.StageRequest;
import s1510.demo.dtos.response.StageResponse;
import s1510.demo.model.Stage;
import s1510.demo.repository.StageRepository;
import s1510.demo.service.StageService;
import s1510.demo.utils.GenericMapperUtil;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StageServiceImplementation implements StageService {

    private final StageRepository stageRepository;
    private final GenericMapperUtil genericMapperUtil;

    @Override
    public List<StageResponse> listAll() {
        return stageRepository.findAll().stream()
                .map(stage -> genericMapperUtil.mapToDto(stage, StageResponse.class))
                .toList();
    }

    @Override
    public Optional<StageResponse> findById(Long stageId) {
        Stage stage = stageRepository.findById(stageId).orElse(null);
        return Optional.of(genericMapperUtil.mapToDto(stage, StageResponse.class));
    }

    @Override
    public StageResponse save(StageRequest saveStage) {
        Stage stage = Stage.builder()
                .id(saveStage.id())
                .stageType(saveStage.stageType())
                .winner(saveStage.winner())
                .build();
        return genericMapperUtil.mapToDto(stageRepository.save(stage), StageResponse.class);
    }

    @Override
    public StageResponse delete(Long stageId) {
        Stage stage = stageRepository.getReferenceById(stageId);
        stageRepository.deleteById(stageId);
        return genericMapperUtil.mapToDto(stage, StageResponse.class);
    }

    @Override
    public boolean existsById(Long id) {
        return stageRepository.existsById(id);
    }
}
