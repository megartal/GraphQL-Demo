package au.com.brolly.resolver;

import au.com.brolly.model.Author;
import au.com.brolly.model.Book;
import au.com.brolly.repository.AuthorRepository;
import au.com.brolly.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

/**
 * @Author Akbar
 * @DATE 3/19/2019.
 */
public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Iterable<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public long countBooks(){
        return bookRepository.count();
    }

    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public long countAuthors(){
        return authorRepository.count();
    }
}
