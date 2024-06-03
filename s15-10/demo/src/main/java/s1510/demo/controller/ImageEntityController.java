package s1510.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1510.demo.helpers.CloudinaryService;

@RestController
@Profile(value = {"dev", "test"})
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageEntityController {

    private final CloudinaryService cloudinaryService;
}
