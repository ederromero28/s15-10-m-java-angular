package s1510.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1510.demo.dtos.request.MatchRequestDTO;
import s1510.demo.dtos.response.MatchResponseDto;

import s1510.demo.service.MatchService;


import java.util.List;

@RestController
@RequestMapping(path = "match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<MatchResponseDto>> getAllMatches() {
        List<MatchResponseDto> matchList = matchService.getAllMatches();
        return new ResponseEntity<>(matchList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatchResponseDto> createMatch(@Valid @RequestBody MatchRequestDTO matchRequestDTO) {
        MatchResponseDto match = matchService.createMatch(matchRequestDTO);
        return new ResponseEntity<>(match, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDto> getMatchById(@PathVariable Long id, @RequestBody MatchRequestDTO matchRequestDTO) {
        MatchResponseDto updatedMatch = matchService.getMatchById(id);
        return new ResponseEntity<>(updatedMatch, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchResponseDto> updateMatch(@Valid @PathVariable Long id, @RequestBody MatchRequestDTO matchRequestDTO) {
        MatchResponseDto updatedMatch = matchService.updateMatch(id, matchRequestDTO);
        return new ResponseEntity<>(updatedMatch, HttpStatus.OK);
    }

}
