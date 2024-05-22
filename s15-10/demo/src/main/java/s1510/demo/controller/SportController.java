package s1510.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1510.demo.dtos.SportDTO;
import s1510.demo.model.Sport;
import s1510.demo.service.imp.SportServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportServiceImpl sportService;

    @GetMapping
    public List<Sport> findAll(){
        return sportService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> findById(@PathVariable Long sportId){

        Optional<Sport> sport =sportService.findById(sportId);
        if (sport.isPresent()){
            return ResponseEntity.ok(sport.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sport> create (@RequestBody @Valid SportDTO sportDTO){
        Sport sport =sportService.create(sportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(sport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sport> update(@PathVariable Long id, @RequestBody @Valid SportDTO sportDTO){
        Sport sport = sportService.update(id, sportDTO);
        return ResponseEntity.ok(sport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sport> delete(@PathVariable Long id){
        return sportService.delete(id);
    }

}
