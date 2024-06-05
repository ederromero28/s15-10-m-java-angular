package s1510.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.dtos.response.SportResponse;
import s1510.demo.model.Sport;
import s1510.demo.service.SportService;
import s1510.demo.service.imp.SportServiceImplementation;

import java.util.List;
import java.util.Optional;

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
        List<SportResponse> sportList = sportService.findAll();
        return new ResponseEntity<>(sportList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportResponse> findById(@PathVariable Long id){
        SportResponse sportResponse = sportService.findById(id);
        return new ResponseEntity<>(sportResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SportResponse> create (@Valid @RequestBody SportRequest sportRequest){
        SportResponse sport = sportService.create(sportRequest);
        return new ResponseEntity<>(sport, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SportResponse> update(@Valid @PathVariable Long id, @RequestBody SportRequest sportRequest){
        SportResponse updatedSport = sportService.update(id, sportRequest);
        return new ResponseEntity<>(updatedSport, HttpStatus.OK);
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



