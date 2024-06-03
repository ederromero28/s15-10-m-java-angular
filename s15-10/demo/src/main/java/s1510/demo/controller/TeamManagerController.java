package s1510.demo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.TeamManagerRequest;
import s1510.demo.dtos.response.TeamManagerResponse;
import s1510.demo.exception.FileNotExistException;
import s1510.demo.model.TeamManager;
import s1510.demo.service.TeamManagerService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@Profile(value = {"dev", "prod", "test"})
@RequestMapping("/teammanager")
public class TeamManagerController {

    @Autowired
    private TeamManagerService teamManagerService;


    @GetMapping("/pageble_list")
    public ResponseEntity<?> listTeamManager(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "id") String sortBy,
                                             @RequestParam(defaultValue = "ASC") String sortOrder) {

        Page<TeamManager> teamManagers = teamManagerService.findByPage(page, size, sortBy, sortOrder);

        return new ResponseEntity<>(teamManagers, HttpStatus.OK);


    }

    @GetMapping
    public ResponseEntity<List<TeamManagerResponse>> findAll() {

        List<TeamManagerResponse> teams = teamManagerService.findAll();

        return new ResponseEntity<>(teams, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamManagerResponse> findById(@PathVariable @NotBlank Long id) {

        TeamManagerResponse teamManager = teamManagerService.findById(id);

        return new ResponseEntity<>(teamManager, HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<TeamManagerResponse> create(@RequestPart @Valid TeamManagerRequest teamManager) {

        TeamManagerResponse team = teamManagerService.create(teamManager);

        return ResponseEntity.status(HttpStatus.CREATED).body(team);

    }

    @PutMapping("/up_logo")
    public ResponseEntity<TeamManagerResponse> updateLogo(@RequestParam MultipartFile file,
                                                          @PathVariable @NotBlank Long teamId) throws IOException {

        BufferedImage entry = ImageIO.read(file.getInputStream());

        if (entry == null) {
            throw new FileNotExistException(String.format("La imagen ingresada no es valida"));
        }

        TeamManagerResponse response = teamManagerService.updateLogo(teamId, file);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
