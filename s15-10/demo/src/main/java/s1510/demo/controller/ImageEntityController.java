package s1510.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s1510.demo.utils.CloudinaryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageEntityController {

    private final CloudinaryService cloudinaryService;
}
