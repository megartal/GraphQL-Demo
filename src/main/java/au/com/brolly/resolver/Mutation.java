package au.com.brolly.resolver;

import au.com.brolly.exception.BookNotFoundException;
import au.com.brolly.model.Author;
import au.com.brolly.model.Book;
import au.com.brolly.repository.AuthorRepository;
import au.com.brolly.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

/**
 * @Author Akbar
 * @DATE 3/19/2019.
 */
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Author newAuthor(String firstName, String lastName){
        Author author = new Author(firstName, lastName);
        return authorRepository.save(author);
    }

    public Book newBook(String title, String isbn, int pageCount, Long authorId){
        Book book = new Book(title, isbn, pageCount, new Author(authorId));
        return  bookRepository.save(book);
    }

    public boolean deleteBook(Long id){
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null){
            throw new BookNotFoundException("The book to be updated was not found", id);
        }
        book.setPageCount(pageCount);
        return bookRepository.save(book);
    }
}
