package s1510.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@Profile(value = {"dev", "prod", "test"})
public interface GenericRepo<T, ID> extends JpaRepository<T, ID> {

}
