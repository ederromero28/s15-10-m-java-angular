package s1510.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
