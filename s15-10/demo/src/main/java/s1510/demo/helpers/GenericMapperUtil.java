package s1510.demo.helpers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = {"dev", "prod", "test"})
@Component
public class GenericMapperUtil {
    private final ModelMapper modelMapper;

    public GenericMapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, T> D mapToDto(T entity, Class<D> outclass) {
        return modelMapper.map(entity, outclass);
    }

    public <D, T> T mapToEntity(D dto, Class<T> outclass) {
        return modelMapper.map(dto, outclass);
    }
}
