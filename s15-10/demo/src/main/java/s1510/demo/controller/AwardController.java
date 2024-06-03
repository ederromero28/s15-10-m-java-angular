package s1510.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1510.demo.service.AwardService;

@RestController
@Profile(value = {"dev", "test"})
@RequiredArgsConstructor
@RequestMapping("/awards")
public class AwardController {

    private final AwardService awardService;
}
