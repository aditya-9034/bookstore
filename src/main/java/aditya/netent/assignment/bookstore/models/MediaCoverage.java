package aditya.netent.assignment.bookstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MediaCoverage {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
