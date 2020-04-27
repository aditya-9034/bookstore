package aditya.netent.assignment.bookstore.controllers;

import aditya.netent.assignment.bookstore.models.Book;
import aditya.netent.assignment.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping({"", "/"})
    public boolean addBook(@RequestBody Book book){
        return bookService.add(book);
    }

    @GetMapping({"/{id}"})
    public Book getBook(@PathVariable("id") UUID id) {
        return bookService.get(id);
    }

    @GetMapping("")
    public List<Book> searchBook(String query, String value){
        return bookService.search(query, value);
    }
}
