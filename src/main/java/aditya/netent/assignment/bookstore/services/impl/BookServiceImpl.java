package aditya.netent.assignment.bookstore.services.impl;

import aditya.netent.assignment.bookstore.models.Book;
import aditya.netent.assignment.bookstore.repositories.BookRepository;
import aditya.netent.assignment.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean add(Book book) {
        List<Book> existingBooks = bookRepository.search("isbn", book.getIsbn().toString());
        if(existingBooks.isEmpty()) {
            book.setQuantity(1);
            return bookRepository.add(book);
        } else {
            Book existingBook = existingBooks.get(0);
            existingBook.setQuantity(existingBook.getQuantity() + 1);
            return bookRepository.update(existingBook, existingBook.getId());
        }
    }

    @Override public Book get(UUID id) {
        return bookRepository.get(id);
    }

    @Override public List<Book> search(String query, String value) {
        return bookRepository.search(query, value);
    }

    @Override
    public boolean update(Book book, UUID id) {
        return bookRepository.update(book, id);
    }
}
