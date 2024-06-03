package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import s1510.demo.repository.AwardRepository;
import s1510.demo.service.AwardService;

@Service
@Profile(value = {"dev", "prod", "test"})
@RequiredArgsConstructor
public class AwardServiceImplementation implements AwardService {

    private final AwardRepository awardRepository;
}
