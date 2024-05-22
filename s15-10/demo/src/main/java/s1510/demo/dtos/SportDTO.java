package s1510.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SportDTO implements Serializable {

    @NotBlank
    private String name;
    private Integer teamSize;
    private Integer rounds;

}

