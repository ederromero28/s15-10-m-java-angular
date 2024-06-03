package s1510.demo.service;

import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})
public interface AwardService {
}
