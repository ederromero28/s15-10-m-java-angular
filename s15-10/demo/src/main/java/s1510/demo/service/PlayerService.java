package s1510.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.PlayerRequest;
import s1510.demo.dtos.response.PlayerResponse;

import java.util.List;

public interface PlayerService {

    ResponseEntity<PlayerResponse> createPlayer(PlayerRequest playerRequest, MultipartFile img);

    ResponseEntity<PlayerResponse> updatePlayer(Long playerId,PlayerRequest playerRequest);

    ResponseEntity<PlayerResponse> logicDelete(Long playerId);

    ResponseEntity<List<PlayerResponse>> listAllPlayers();
    ResponseEntity<List<PlayerResponse>> listPlayerAvailable();
}
