package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.PlayerRequest;
import s1510.demo.dtos.response.PlayerResponse;
import s1510.demo.model.Player;
import s1510.demo.repository.PlayerRepository;
import s1510.demo.service.PlayerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImplementation implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public ResponseEntity<PlayerResponse> createPlayer(PlayerRequest playerRequest, MultipartFile img) {

        return null;
    }

    @Override
    public ResponseEntity<PlayerResponse> updatePlayer(Long playerId, PlayerRequest playerRequest) {
        return null;
    }

    @Override
    public ResponseEntity<PlayerResponse> logicDelete(Long playerId) {
        return null;
    }

    @Override
    public ResponseEntity<List<PlayerResponse>> listAllPlayers() {
        List<PlayerResponse> players = playerRepository.findAll().stream().map(PlayerResponse::new).toList();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PlayerResponse>> listPlayerAvailable() {
        return null;
    }
}
