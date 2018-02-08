package romanovsky.katalogimprovedreactive.repository;

import org.springframework.data.repository.CrudRepository;
import romanovsky.katalogimprovedreactive.model.ContainerType;

import javax.transaction.Transactional;
import java.util.List;

public interface ContainerTypeRepository extends CrudRepository<ContainerType, Integer> {
}
