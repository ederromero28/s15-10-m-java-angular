package s1510.demo.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.PlayerRequest;
import s1510.demo.dtos.response.PlayerResponse;
import s1510.demo.dtos.response.TeamManagerResponse;
import s1510.demo.exception.FileNotExistException;
import s1510.demo.service.PlayerService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
@Profile(value = {"dev", "prod", "test"})
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<PlayerResponse> createPlayer(PlayerRequest playerRequest) {

        PlayerResponse newPlayer = playerService.createPlayer(playerRequest);

        return new ResponseEntity<>(newPlayer, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<PlayerResponse> updatePlayer(Long playerId,
                                                       @RequestBody PlayerRequest playerRequest) {

        PlayerResponse newPlayer = playerService.updatePlayer(playerId, playerRequest);

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

    @PutMapping("/update_image")
    public ResponseEntity<PlayerResponse> updateImage(@RequestParam MultipartFile file,
                                                      @PathVariable Long playerId) throws IOException {

        BufferedImage entry = ImageIO.read(file.getInputStream());

        if (entry == null) {
            throw new FileNotExistException(String.format("La imagen ingresada no es valida"));
        }

        PlayerResponse response = playerService.updateImage(file, playerId);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/update_team")
    public ResponseEntity<PlayerResponse> updateTeam(@RequestParam Long teamId,
                                                     @RequestParam Long playerId) {

        PlayerResponse playerUpdate = playerService.updateTeam(playerId, teamId);

        return new ResponseEntity<>(playerUpdate, HttpStatus.OK);

    }
}
