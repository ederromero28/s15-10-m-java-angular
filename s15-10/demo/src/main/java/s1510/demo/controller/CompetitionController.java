package s1510.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1510.demo.dtos.request.CompetitionRequest;
import s1510.demo.model.Competition;
import s1510.demo.service.CompetitionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/competitions")
class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Competition save(
            @RequestBody
            @Valid
            CompetitionRequest resource) {
        return competitionService.create(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Competition update(@PathVariable("id") Long id,
                       @RequestBody CompetitionRequest resource) {
        return competitionService.update(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Competition delete(@PathVariable("id") Long id) {
        return competitionService.delete(id);
    }


    @GetMapping
    public List<Competition> findAll() {
        return competitionService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Competition> findById(
            @PathVariable("id") Long id) {
        return competitionService.findById(id);
    }
}
