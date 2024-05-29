package s1510.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import s1510.demo.dtos.request.StageRequest;
import s1510.demo.dtos.response.StageResponse;
import s1510.demo.service.StageService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StageController {
    public final StageService stageService;

    @GetMapping("/stages")
    public ResponseEntity<List<StageResponse>> listStages() {
        return ResponseEntity.ok(stageService.listAll());
    }

    @GetMapping("/stage/{id}")
    public ResponseEntity<Optional<StageResponse>> getStage(@PathVariable Long id) {
        return ResponseEntity.ok(stageService.findById(id));
    }

    @DeleteMapping("/stage/{id}")
    public ResponseEntity<StageResponse> deleteStage(@PathVariable Long id) {
        StageResponse stageResponse = stageService.delete(id);
        return new ResponseEntity<>(stageResponse, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/stage")
    public ResponseEntity<StageResponse> createStage(@RequestBody @Valid StageRequest stageRequest, UriComponentsBuilder uriComponentsBuilder) {
        StageResponse stageResponse = stageService.save(stageRequest);
        URI url = uriComponentsBuilder.path("api/v1/stage/{id}").buildAndExpand(stageResponse.id()).toUri();
        return ResponseEntity.created(url).body(stageResponse);
    }

    @PutMapping("/stage")
    public ResponseEntity<StageResponse> updateStage(@RequestBody @Valid StageRequest stageRequest) {
        if (stageService.existsById(stageRequest.id())) {
            StageResponse stageResponse = stageService.save(stageRequest);
            return ResponseEntity.ok(stageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
