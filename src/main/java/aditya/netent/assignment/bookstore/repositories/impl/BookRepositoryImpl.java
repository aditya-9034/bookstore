package aditya.netent.assignment.bookstore.repositories.impl;

import aditya.netent.assignment.bookstore.models.Book;
import aditya.netent.assignment.bookstore.repositories.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private JestClient jestClient;

    @Override
    public boolean add(Book book) {
        try {
            JestResult jestResult = jestClient.execute(
                new Index.Builder(book)
                    .index("books")
                    .type("_doc")
                    .id(book.getId().toString())
                    .build()
            );
            return jestResult.isSucceeded();
        } catch(IOException io){
            io.printStackTrace();
        }
        return false;
    }

    @Override public Book get(UUID id) {
        Book book = new Book();
        try {
            JestResult jestResult = jestClient.execute(new Get.Builder("books", id.toString()).build());
            book = jestResult.getSourceAsObject(Book.class);
        } catch(IOException io){
            io.printStackTrace();
        }

        return book;
    }

    @Override
    public boolean update(Book book, UUID bookId) {
        if(book.getQuantity() == 0){
            book.setQuantity(1);
        }
        try {
            JestResult jestResult = jestClient.execute(
                new Index.Builder(book)
                    .index("books")
                    .type("_doc")
                    .id(bookId.toString())
                    .id(bookId.toString())
                    .build()
            );
            return jestResult.isSucceeded();
        } catch(IOException io){
            io.printStackTrace();
        }
        return false;
    }

    @Override public List<Book> search(String query, String value) {
        if(query.equals("isbn")){
            return searchExact(query, value);
        }
        return searchPartial(query, value);
    }

    private List<Book> searchPartial(String query, String value){
        String queryDsl = "{" +
            "    \"query\": {" +
            "        \"wildcard\": {" +
            "            \""+ query +"\": {" +
            "                \"value\": \""+value+"\""+
            "            }"+
            "        }" +
            "    }"
            + "}";

        List<Book> books = new ArrayList<>();

        try {
            List<SearchResult.Hit<Book, Void>> searchResults =
                jestClient.execute(new Search.Builder(queryDsl).build())
                    .getHits(Book.class);
            searchResults.forEach(hit -> {
                books.add((Book) hit.source);
            });
        } catch (IOException io){
            io.printStackTrace();
        }
        return books;
    }

    private List<Book> searchExact(String query, String value){
        String queryDsl = "{" +
                            "\"query\": {" +
                                "\"bool\": {" +
                                    "\"must\": [" +
                                        "{ \"match\": { " +
                                            "\"isbn\": "+ value +" " +
                                                      "}" +
                                        "}" +
                                "]" +
                    "        } " +
                    "    }" +
                    "}";

        List<Book> books = new ArrayList<>();
        try {
            List<SearchResult.Hit<Book, Void>> searchResults =
                jestClient.execute(new Search.Builder(queryDsl).build())
                    .getHits(Book.class);
            searchResults.forEach(hit -> {
                books.add((Book) hit.source);
            });
        } catch (IOException io){
            io.printStackTrace();
        }
        return books;
    }
}

