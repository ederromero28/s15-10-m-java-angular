package s1510.demo.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1510.demo.dtos.request.PlayerRequest;
import s1510.demo.dtos.response.PlayerResponse;
import s1510.demo.service.PlayerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<PlayerResponse> createPlayer(@RequestBody PlayerRequest playerRequest) {

        PlayerResponse newPlayer = playerService.createPlayer(playerRequest);

        return new ResponseEntity<>(newPlayer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PlayerResponse> updatePlayer(@PathVariable @NotBlank Long playerId, @RequestBody PlayerRequest playerRequest) {

        PlayerResponse newPlayer = playerService.updatePlayer(playerId,playerRequest);

        return new ResponseEntity<>(newPlayer, HttpStatus.OK);
    }

    @PatchMapping("/logic_delete")
    public ResponseEntity<PlayerResponse> logicDelete(@PathVariable @NotBlank Long playerId) {
        PlayerResponse playerResponse = playerService.logicDelete(playerId);

        return new ResponseEntity<>(playerResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PlayerResponse>> listAllPlayers() {
        List<PlayerResponse> playersFound = playerService.listAllPlayers();
        return new ResponseEntity<>(playersFound, HttpStatus.OK);
    }

    @GetMapping("/list_available")
    public ResponseEntity<List<PlayerResponse>> listPlayerAvailable() {
        List<PlayerResponse> playersAvailableFound = playerService.listPlayerAvailable();
        return new ResponseEntity<>(playersAvailableFound, HttpStatus.OK);
    }
}
