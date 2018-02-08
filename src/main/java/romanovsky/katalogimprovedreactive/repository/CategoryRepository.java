package romanovsky.katalogimprovedreactive.repository;

import org.springframework.data.repository.CrudRepository;
import romanovsky.katalogimprovedreactive.model.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
