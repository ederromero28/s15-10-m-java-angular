package s1510.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.dtos.response.SportResponse;
import s1510.demo.model.Sport;
import s1510.demo.service.imp.SportServiceImplementation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportServiceImplementation sportService;

    @GetMapping
    public List<Sport> findAll(){
        return sportService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> findById(@PathVariable Long id){

        Optional<Sport> sport = sportService.findById(id);
        return sport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody @Valid SportRequest sportDTO){
        Sport sport =sportService.create(sportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SportResponse(sport));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid SportRequest sportDTO){
        Sport sport = sportService.update(id, sportDTO);
        return ResponseEntity.ok(new SportResponse(sport));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Sport> delete(@PathVariable Long id){
//        return sportService.delete(id);
//    }

    @DeleteMapping("/disabled/{id}")
    public ResponseEntity<?> disabled(@PathVariable Long id){
        sportService.disabled(id);
        return new ResponseEntity<>("Desactivado", HttpStatus.OK);
    }

    @PatchMapping("/enabled/{id}")
    public ResponseEntity<?> enabled(@PathVariable Long id){
        sportService.enabled(id);
        return new ResponseEntity<>("Activado", HttpStatus.OK);
    }

}



