package s1510.demo.service;

import org.springframework.context.annotation.Profile;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.dtos.response.SportResponse;

import java.util.List;

@Profile(value = {"dev", "prod", "test"})
public interface SportService{

    List<SportResponse> findAll();
    SportResponse findById(Long sportId);
    SportResponse create(SportRequest saveSport);
    SportResponse update(Long sportId, SportRequest updateSport);
    void disabled(Long id);
    void enabled(Long id);

}
