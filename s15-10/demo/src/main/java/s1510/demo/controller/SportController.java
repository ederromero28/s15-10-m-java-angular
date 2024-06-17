package s1510.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.dtos.response.SportResponse;
import s1510.demo.exception.ResourceNotFoundException;
import s1510.demo.service.SportService;

import java.util.List;

@RestController
@Profile(value= {"dev","prod","test"})
@RequestMapping("/sport")
public class SportController {

    private final SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping
    public ResponseEntity<List<SportResponse>> findAll(){
        if (sportService.findAll().isEmpty()) throw new ResourceNotFoundException("No Sports records found");
        return ResponseEntity.ok(sportService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(sportService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody SportRequest sportRequest){
        sportService.create(sportRequest);
        return new ResponseEntity<>("Sport created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody SportRequest sportRequest){
        sportService.update(id, sportRequest);
        return new ResponseEntity<>("Updated Sport", HttpStatus.OK);
    }

    @DeleteMapping("/disabled/{id}")
    public ResponseEntity<?> disabled(@PathVariable Long id){
        sportService.disabled(id);
        return new ResponseEntity<>("Disabled", HttpStatus.OK);
    }

    @PatchMapping("/enabled/{id}")
    public ResponseEntity<?> enabled(@PathVariable Long id){
        sportService.enabled(id);
        return new ResponseEntity<>("Activated", HttpStatus.OK);
    }

}



