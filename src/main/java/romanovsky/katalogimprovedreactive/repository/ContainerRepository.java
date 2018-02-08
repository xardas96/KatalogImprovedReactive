package romanovsky.katalogimprovedreactive.repository;

import org.springframework.data.repository.CrudRepository;
import romanovsky.katalogimprovedreactive.model.Container;

import javax.transaction.Transactional;
import java.util.List;

public interface ContainerRepository extends CrudRepository<Container, Integer> {
}
