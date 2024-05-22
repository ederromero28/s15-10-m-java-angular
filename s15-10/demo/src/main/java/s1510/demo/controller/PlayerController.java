package s1510.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1510.demo.dtos.response.PlayerResponse;
import s1510.demo.service.PlayerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<?> getAllPlayer(){
        ResponseEntity<List<PlayerResponse>> player = playerService.listAllPlayers();
        return player;
    }
}
