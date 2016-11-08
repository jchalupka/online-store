package edu.onlineStore;

import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {
	Book tester;

	String validId = "123456";
	String validName = "Red Book";
	String validYear = "2005";
	String validPrice = "12.99";
	String validAuthor = "Susan Roberts";
	String validPublisher = "Walton Gate's";

	@Before
	public void createValidBookForTests() {
		tester = new Book(validId, validName, validYear, validPrice, validAuthor, validPublisher);
	}

	@Test // Check create book if author is empty
	public void emptyAuthorCreatesBook() {
		tester = new Book(validId, validName, validYear, validPrice, "", validPublisher);
	}
	
	@Test 	// Check create book if publisher is empty
	public void emptyPublisherCreatesBook() {
		tester = new Book(validId, validName, validYear, validPrice, validAuthor, "");
	}
	
	@Test // Check get author
	public void getAuthorWorks() {
		assertEquals(tester.getAuthor(), validAuthor);
	}
	
	@Test // Check get publisher
	public void getPublisherWorks() {
		assertEquals(tester.getPublisher(), validPublisher);
	}
	
	@Test // Check set author
	public void setAuthorWorks() {
		tester.setAuthor("Linda Jones");
		assertEquals(tester.author, "Linda Jones");
	}
	
	
	@Test // Check set publisher
	public void setPublisherWorks() {
		tester.setPublisher("New Market Publishing");
		assertEquals(tester.publisher, "New Market Publishing");
	}
	
	@Test // Check equals
	public void bookEqualsWorks() {
		Book otherBook = new Book(validId, validName, validYear, validPrice, validAuthor, validPublisher);
		assertTrue("both products should be equal", tester.equals(otherBook));

		otherBook = new Book(validId, validName, validYear, validPrice, "No-One", validPublisher);
		assertFalse("different author should not be equal", tester.equals(otherBook));

		otherBook = new Book(validId, validName, validYear, validPrice, validAuthor, "A small company");
		assertFalse("different publisher should not be equal", tester.equals(otherBook));
	}
}
