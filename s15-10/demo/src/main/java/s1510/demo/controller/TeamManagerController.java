package s1510.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1510.demo.model.TeamManager;
import s1510.demo.service.TeamManagerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teammanager")
public class TeamManagerController {

    @Autowired
    private TeamManagerService teamManagerService;


    @GetMapping("/pageble_list")
    public ResponseEntity<?> listTeamManager(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "id") String sortBy,
                                             @RequestParam(defaultValue = "ASC") String sortOrder){
        Page<TeamManager> teamManagers = teamManagerService.findByPage(page,size,sortBy,sortOrder);
        return new ResponseEntity<>(teamManagers, HttpStatus.OK);

    }
    @GetMapping
    public List<TeamManager> findAll() {return teamManagerService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<TeamManager> findById(@PathVariable Long id){

        Optional<TeamManager> teamManager = teamManagerService.findById(id);
        return teamManager.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<TeamManager> create (@RequestBody @Valid TeamManager teamManager){
        TeamManager team = teamManagerService.create(teamManager);
        return ResponseEntity.status(HttpStatus.CREATED).body(team);
    }


}
