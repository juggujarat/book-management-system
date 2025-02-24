package book_management._system.service;

import book_management._system.dto.BookRequest;
import book_management._system.dto.BookResponse;
import book_management._system.entity.Book;
import book_management._system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public BookResponse createBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setIsbn(bookRequest.getIsbn());
        book.setPrice(bookRequest.getPrice());

        Book savedBook = bookRepository.save(book);
        return new BookResponse(savedBook.getTitle(), savedBook.getAuthor(), savedBook.getIsbn(), savedBook.getPrice());
    }


    public Optional<BookResponse> getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(b -> new BookResponse(b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPrice()));
    }


    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> new BookResponse(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPrice()))
                .collect(Collectors.toList());
    }


    public Optional<BookResponse> updateBook(Long id, BookRequest bookRequest) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();

            if (bookRequest.getTitle() != null) {
                book.setTitle(bookRequest.getTitle());
            }
            if (bookRequest.getAuthor() != null) {
                book.setAuthor(bookRequest.getAuthor());
            }
            if (bookRequest.getIsbn() != null) {
                book.setIsbn(bookRequest.getIsbn());
            }
            if (bookRequest.getPrice() > 0) {
                book.setPrice(bookRequest.getPrice());
            }
            bookRepository.save(book);

            return Optional.of(new BookResponse(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPrice()));
        }
        return Optional.empty();
    }


    public boolean deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return true;
        }
        return false;
    }
}
