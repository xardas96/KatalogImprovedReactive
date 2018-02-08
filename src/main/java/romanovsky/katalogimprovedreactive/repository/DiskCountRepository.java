package romanovsky.katalogimprovedreactive.repository;

import org.springframework.data.repository.CrudRepository;
import romanovsky.katalogimprovedreactive.model.DiskCount;

public interface DiskCountRepository extends CrudRepository<DiskCount, Integer> {
}
