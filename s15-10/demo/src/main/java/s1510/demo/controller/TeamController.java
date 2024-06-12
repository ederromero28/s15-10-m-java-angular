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
import s1510.demo.dtos.request.TeamRequest;
import s1510.demo.dtos.response.TeamResponse;
import s1510.demo.exception.FileNotExistException;
import s1510.demo.model.Team;
import s1510.demo.service.TeamService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RestController
@Profile(value = {"dev", "prod", "test"})
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @GetMapping("/pageble_list")
    public ResponseEntity<?> listTeam(@RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String sortBy,
                                      @RequestParam(defaultValue = "ASC") String sortOrder) {

        Page<Team> team = teamService.findByPage(page, size, sortBy, sortOrder);

        return new ResponseEntity<>(team, HttpStatus.OK);


    }

    @GetMapping
    public ResponseEntity<List<TeamResponse>> findAll() {

        List<TeamResponse> teams = teamService.findAll();

        return new ResponseEntity<>(teams, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> findById(@PathVariable @NotBlank Long id) {

        TeamResponse team = teamService.findById(id);

        return new ResponseEntity<>(team, HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<TeamResponse> create(@RequestPart @Valid TeamRequest team) {

        TeamResponse response = teamService.create(team);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping("/up_logo")
    public ResponseEntity<TeamResponse> updateLogo(@RequestParam MultipartFile file,
                                                   @PathVariable @NotBlank Long teamId) throws IOException {

        BufferedImage entry = ImageIO.read(file.getInputStream());

        if (entry == null) {
            throw new FileNotExistException(String.format("La imagen ingresada no es valida"));
        }

        TeamResponse response = teamService.updateLogo(teamId, file);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
