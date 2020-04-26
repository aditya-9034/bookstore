package aditya.netent.assignment.bookstore.repositories;

import aditya.netent.assignment.bookstore.models.Book;

import java.util.List;
import java.util.UUID;

public interface BookRepository {
    boolean add(Book book);
    boolean update(Book book, UUID bookId);
    Book get(UUID id);
    List<Book> search(String query, String value);
}
