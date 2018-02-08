package romanovsky.katalogimprovedreactive.repository;

import org.springframework.data.repository.CrudRepository;
import romanovsky.katalogimprovedreactive.model.ContainerCount;

import java.util.List;

public interface ContainerCountRepository extends CrudRepository<ContainerCount, Integer> {
}
