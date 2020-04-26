package aditya.netent.assignment.bookstore.services;

import aditya.netent.assignment.bookstore.models.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    boolean add(Book book);

    Book get(UUID id);

    Book getByIsbn(Long isbn);

    List<Book> search(String query, String value);

    Book removeOne(UUID id);
}
