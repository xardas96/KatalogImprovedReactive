package romanovsky.katalogimprovedreactive.repository;

import org.springframework.data.repository.CrudRepository;
import romanovsky.katalogimprovedreactive.model.Category;
import romanovsky.katalogimprovedreactive.model.Entry;

public interface EntryRepository extends CrudRepository<Entry, Integer> {

    long countByCategory(Category category);

}
