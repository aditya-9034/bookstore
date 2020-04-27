package aditya.netent.assignment.bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private UUID id = UUID.randomUUID();
    private Long isbn;
    private String title;
    private String author;
    private Double price;
    private Integer quantity;
}
