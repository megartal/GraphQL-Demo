package au.com.brolly.repository;

import au.com.brolly.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author Akbar
 * @DATE 3/19/2019.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
