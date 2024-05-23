package s1510.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1510.demo.model.Competition;
import s1510.demo.service.CompetitionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;



    @GetMapping
    public List<Competition> findAll() {
        return competitionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> findById(
             @PathVariable Long id) {

        Optional
    }

}
