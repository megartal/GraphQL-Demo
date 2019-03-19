package au.com.brolly.resolver;

import au.com.brolly.model.Author;
import au.com.brolly.model.Book;
import au.com.brolly.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

/**
 * @Author Akbar
 * @DATE 3/19/2019.
 */
public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book){
        return authorRepository.findOne(book.getAuthor().getId());
    }
}
