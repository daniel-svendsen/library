package se.yrgo.library.models;


/**
 * <p>BookCatalog class.</p>
 *
 * @author Svendsén
 * @version $Id: $Id
 */
public class BookCatalog {

	private Book[] bookArray = new Book[100];
	private int nextPosition = 0;

	/**
	 * <p>Getter for the field <code>bookArray</code>.</p>
	 *
	 * @return an array of {@link se.yrgo.library.models.Book} objects
	 */
	public Book[] getBookArray() {
		return bookArray;
	}
	
	/**
	 * <p>getNumberOfBooks.</p>
	 *
	 * @return a int
	 */
	public int getNumberOfBooks() {
		return nextPosition;
	}
	
	/**
	 * <p>addBook.</p>
	 *
	 * @param newBook a {@link se.yrgo.library.models.Book} object
	 */
	public void addBook(Book newBook) {
		bookArray[nextPosition] = newBook;
		nextPosition++;
	}
	
	/**
	 * <p>findBook.</p>
	 *
	 * @param title a {@link java.lang.String} object
	 * @return a {@link se.yrgo.library.models.Book} object
	 * @throws se.yrgo.library.models.BookNotFoundException if any.
	 */
	public Book findBook(String title) throws BookNotFoundException
	{
		title = title.trim();
		
		for (int counter = 0; counter < nextPosition; counter++) {
			if (bookArray[counter].getTitle().equalsIgnoreCase(title)) {
				return bookArray[counter];
			}
		}
		throw new BookNotFoundException();
	}

}
