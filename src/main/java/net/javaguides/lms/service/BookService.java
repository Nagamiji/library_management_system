package net.javaguides.lms.service;

import net.javaguides.lms.entity.Book;
import net.javaguides.lms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> bookData = bookRepository.findById(id);
        if (bookData.isPresent()) {
            Book book = bookData.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            book.setStatus(bookDetails.getStatus());
            book.setAvailable(bookDetails.getAvailable());
            book.setStartDate(bookDetails.getStartDate());
            book.setReturnDate(bookDetails.getReturnDate());
            book.setUser(bookDetails.getUser());
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
