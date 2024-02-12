package se.yrgo.library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import se.yrgo.library.models.Book;
import se.yrgo.library.models.BookCatalog;
import se.yrgo.library.models.BookNotFoundException;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book(1,"Learning Java","Author","ISBN1","Branch1",300);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		Book book2 = new Book(2, "Java", "Author2", "ISBN2", "Branch2", 250);
		bc.addBook(book2);
		assertEquals(2, bc.getNumberOfBooks());
	}

	//G
	@Test
	public void testFindBook() throws BookNotFoundException {
		Book book4 = new Book(2, "Java", "Author2", "ISBN2", "Branch2", 250);
		bc.addBook(book4);

		assertEquals(book4, bc.findBook("Java"));
	}

	//G

	/**
	 * Creates new catalog, adds book. Creates a book to search for with lowercase.
	 * @throws BookNotFoundException
	 */
	@Test
	public void testFindBookIgnoringCase() throws BookNotFoundException {
		bc = new BookCatalog();
		Book book1 = new Book(1,"Learning Java","Author","ISBN1","Branch1",300);
		bc.addBook(book1);

		Book foundBook = bc.findBook("learning java");
		assertEquals(book1, foundBook);
	}

	//G
	@Test
	public void testFindBookWithExtraSpaces() throws BookNotFoundException {
		bc = new BookCatalog();
		Book book1 = new Book(1,"Learning Java","Author","ISBN1","Branch1",300);
		bc.addBook(book1);

		Book foundBook = bc.findBook("   Learning Java   ");
		assertEquals(book1, foundBook);
	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {
		assertThrows(BookNotFoundException.class, () -> bc.findBook("Nonexistent Book"));
	}

}
