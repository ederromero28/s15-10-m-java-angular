package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.request.StageRequest;
import s1510.demo.model.Stage;
import s1510.demo.repository.StageRepository;
import s1510.demo.service.StageService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StageServiceImplementation implements StageService {
    private final StageRepository stageRepository;

    @Override
    public List<Stage> listAll() {
        return stageRepository.findAll();
    }

    @Override
    public Optional<Stage> findById(Long stageId) {
        return stageRepository.findById(stageId);
    }

    @Override
    public Stage save(StageRequest saveStage) {
        Stage stage = Stage.builder()
                .id(saveStage.id())
                .stageType(saveStage.stageType())
                .winner(saveStage.winner())
                .build();
        return stageRepository.save(stage);
    }

    @Override
    public Stage delete(Long stageId) {
        Stage stage = stageRepository.getReferenceById(stageId);
        stageRepository.deleteById(stageId);
        return stage;
    }

    @Override
    public boolean existsById(Long id) {
        return stageRepository.existsById(id);
    }
}
