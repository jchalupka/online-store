package edu.onlineStore;

import org.junit.*;
import static org.junit.Assert.*;



public class ProductTest {
	/*******************************************************************
	 * The following functions verify correctness for product creation.
	 *******************************************************************/

	Product tester;

	String validId = "123456";
	String validName = "Ipod";
	String validYear = "2005";
	String validPrice = "12.99";

	
	// public Product createValidProductForTests(String id, String name, String year, String price) {
	// 	return tester = new Product(id, name, year, price);
	// }

	@Before
	public void createValidProductForTests() {
		tester = new Product(validId, validName, validYear, validPrice);
	}

	@Test 
	// Valid product creates product
	public void validProductCreatesProducts() {
		new Product(validId, validName, validYear, validPrice);
	}

	@Test(expected = IllegalArgumentException.class)
	// Check do not create product with empty productID
	public void emptyIdShouldNotCreateProduct() {
		new Product("", validName, validYear, validPrice);
	}

	@Test(expected = IllegalArgumentException.class)
	// Check do not create product with empty name
	public void emptyNameShouldNotCreateProduct() {
		new Product(validId, "", validYear, validPrice);
	}
	
	@Test(expected = IllegalArgumentException.class)
	// Check do not create product with empty year
	public void emptyYearShouldNotCreateProduct() {
		new Product(validId, validName, "", validPrice);
	}
	
	@Test // Check create product with empty price
	public void emptyPriceShouldCreateProduct() {
		new Product(validId, validName, validYear, "");
	}
	 
	@Test(expected = IllegalArgumentException.class)
	// Check do not create product with negative year
	public void negativeYearShouldNotCreateProduct() {
		new Product(validId, validName, "-2000", validPrice);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nonNumberYearShouldNotCreateProduct() {
		new Product(validId, validName, "abc", validPrice);
	}

	@Test(expected = IllegalArgumentException.class)
	public void spacesInYearShouldNotCreateProduct() {
		new Product(validId, validName, "20 05", validPrice);
	}

	@Test(expected = IllegalArgumentException.class)
	public void yearLessThanOneThousandShuoldNotCreateProduct() {
		new Product(validId, validName, "200", validPrice);
	}

	public void yearGreateerThanNineThousandNineHundredNinetyNineShouldNotCreateProduct() {
		new Product(validId, validName, "10000", validPrice);
	}
	
	@Test // Check create product with spaces in name
	public void spacesInNameShouldCreateProduct() {
		new Product(validId, "Ipod Touch", validYear, validPrice);
	}

	@Test
	public void upToTwoDecimalPriceShouldCreateProduct() {
		new Product(validId, validName, validYear, "200");
		new Product(validId, validName, validYear, "200.0");
		new Product(validId, validName, validYear, "200.00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void moreThanTwoDecimalPlacesShouldNotCreateProduct() {
		new Product(validId, validName, validYear, "200.000");
	}
	
	@Test(expected = IllegalArgumentException.class)
	// Check do not create product with less than six digits ID
	public void doNotCreateProductWithLessThanSixDigitId() {
		new Product("12345", validName, validYear, validPrice);
	}
	
	@Test(expected = IllegalArgumentException.class)
	// Check do not create product with more than six digits ID
	public void doNotCreateProductWithMoreThanSixDigitId() {
		new Product("1234567", validName, validYear, validPrice);
	}
	
	@Test // Check create product with six digits ID
	public void createProductWithSixDigitId() {
		new Product("123456", validName, validYear, validPrice);
	}
	
	@Test(expected = IllegalArgumentException.class)
	// Check do not create product with non digits in ID
	public void doNotCreateProductWithNonDigitId() {
		new Product("abc", validName, validYear, validPrice);
	}
	
	@Test(expected = IllegalArgumentException.class)
	// Check do not create product with negative price
	public void doNotCreateProductWithNegativePrice() {
		new Product(validId, validName, validYear, "-123");
	}

	@Test(expected = IllegalArgumentException.class) 
	// Check do not create product with negative price
	public void doNotCreateProductWithNonNumberPrice() {
		new Product(validId, validName, validYear, "abc");
	}
	
     /*******************************************************************
	 * The following functions verify correctness for product functions.
	 *******************************************************************/
	/*Check gets*/
	@Test // Check get ID
	public void getIdWorks() {
		assertEquals(validId, tester.getId());
	}
	
	@Test // Check get name
	public void getNameWorks() {
		assertEquals(validName, tester.getName());
	}
	
	@Test // Check get year
	public void getYearWorks() {
		assertEquals(validYear, tester.getYear());
	}
	
	@Test // Check get set price
	public void setPriceWorks() {
		assertEquals(validPrice, tester.getPrice());
	}
	
	@Test // Check get empty price
	public void getPriceWorksIfPriceEmpty() {
		tester = new Product(validId, validName, validYear, "");
		assertEquals("", tester.getPrice());
	}
	
	/*Check get sets*/
	@Test // Check set valid ID
	public void setIdWorks() {
		tester.setId("654321");
		assertEquals("654321", tester.id);
	}
	
	@Test // Check set name
	public void setValidNameWorks() {
		tester.setName("Harry Potter");
		assertEquals("Harry Potter", tester.name);
	}
	
	@Test // Check set valid year
	public void setValidYearWorks() {
		tester.setYear("4000");
		assertEquals("4000", tester.year);
	}
	
	@Test // Check set valid price
	public void setValidPriceWorks() {
		tester.setPrice("400");
		assertEquals("400", tester.price);
	}
	
	@Test // Check set invalid ID
	public void setInvalidIdStopsProperly() {
		tester.setPrice("asdjio");
		assertEquals(validId, tester.id);
	}

	@Test // Check set invalid ID
	public void setInvalidNameStopsProperly() {
		tester.setName("");
		assertEquals(validName, tester.name);
	}
	
	@Test // Check set invalid year
	public void setInvalidYearStopsProperly() {
		tester.setYear("0");
		assertEquals(validYear, tester.year);
	}
	
	@Test // Check set invalid price
	public void setInvalidPriceStopsProperly() {
		tester.setPrice("-50");
		assertEquals(validPrice, tester.price);
	}
	 
	@Test // Check equals
	public void productEqualsWorks() {
		Product otherProduct = new Product(validId, validName, validYear, validPrice);
		assertTrue("both products should be equal", tester.equals(otherProduct));

		otherProduct = new Product("222222", validName, validYear, validPrice);
		assertFalse("different id should not be equal", tester.equals(otherProduct));

		otherProduct = new Product(validId, "X-Box", validYear, validPrice);
		assertFalse("different name should not be equal", tester.equals(otherProduct));

		otherProduct = new Product(validId, validName, "1997", validPrice);
		assertFalse("different year should not be equal", tester.equals(otherProduct));

		otherProduct = new Product(validId, validName, validYear, "1237421.23");
		assertFalse("different price should not be equal", tester.equals(otherProduct));
	}
	
}