package se.yrgo.library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import se.yrgo.library.models.Book;

class BookTest {


	//G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(1, "Title", "Author", "ISBN", "Branch", 100);
		Book book2 = new Book(1, "Title", "Author", "ISBN", "Branch", 100);

		assertEquals(book1, book2);
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(1, "Title1", "Author1", "ISBN1", "Branch1", 100);
		Book book2 = new Book(2, "Title2", "Author2", "ISBN2", "Branch2", 200);

		assertNotEquals(book1, book2);
	}

}
