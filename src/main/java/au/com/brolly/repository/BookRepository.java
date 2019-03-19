package au.com.brolly.repository;

import au.com.brolly.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author Akbar
 * @DATE 3/19/2019.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
