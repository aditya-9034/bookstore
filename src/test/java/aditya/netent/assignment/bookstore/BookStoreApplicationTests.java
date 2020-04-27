package aditya.netent.assignment.bookstore;

import aditya.netent.assignment.bookstore.models.Book;
import aditya.netent.assignment.bookstore.models.MediaCoverage;
import aditya.netent.assignment.bookstore.models.Purchase;
import aditya.netent.assignment.bookstore.services.BookService;
import aditya.netent.assignment.bookstore.services.MediaCoverageService;
import aditya.netent.assignment.bookstore.services.PurchaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookStoreApplicationTests {

	@Autowired
	private BookService bookService;

	@Autowired
	private MediaCoverageService mediaCoverageService;

	@Autowired
	private PurchaseService purchaseService;

	@Test
	void contextLoads() {
	}

	@Test
	void addBook(){
		Book book = new Book();
		book.setTitle("Case of the Blue Ferret");
		book.setAuthor("Teddy Jackson");
		book.setPrice(150.0);
		book.setIsbn(9783544450258L);
		assertThat(bookService.add(book)).isTrue();
	}

	@Test
	void purchaseBook(){
		Purchase purchase = new Purchase();
		purchase.setId(UUID.randomUUID());
		purchase.setBookId(UUID.fromString("fd2fecd8-cfad-4171-bc2f-6409522b51f7"));
		assertThat(purchaseService.addPurchase(purchase)).isInstanceOf(Purchase.class);
	}

	@Test
	void mediaCoverage(){
		MediaCoverage mediaCoverage = new MediaCoverage();
		mediaCoverage.setUserId(1L);
		mediaCoverage.setId(2L);
		mediaCoverage.setTitle("qui est esse");
		mediaCoverage.setBody("est rerum tempore vitae\n"
			+ "sequi sint nihil reprehenderit dolor beatae ea dolores neque\n"
			+ "fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\n"
			+ "qui aperiam non debitis possimus qui neque nisi nulla");

		assertThat(mediaCoverageService.getMediaCoverageForBook("voluptate porro")).isNotEmpty();
	}

	@Test
	void searchBookB(){
		String key = "title";
		String value = "quantum";
		assertThat(bookService.search(key, value)).isNotEmpty();
	}
}
