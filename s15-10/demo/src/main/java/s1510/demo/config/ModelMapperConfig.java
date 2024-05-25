package s1510.demo.config;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@FieldDefaults(level = AccessLevel.PUBLIC)
@Configuration
public class ModelMapperConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
