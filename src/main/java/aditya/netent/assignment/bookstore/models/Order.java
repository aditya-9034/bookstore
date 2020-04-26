package aditya.netent.assignment.bookstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private UUID id;
    private UUID bookId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
