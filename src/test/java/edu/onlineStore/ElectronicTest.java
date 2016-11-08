package edu.onlineStore;

import org.junit.*;
import static org.junit.Assert.*;

public class ElectronicTest {
	Electronic tester;

	String validId = "123456";
	String validName = "Ipod";
	String validYear = "2005";
	String validPrice = "12.99";
	String validMaker = "Apple";

	@Before
	public void createValidElectronicForTests() {
		tester = new Electronic(validId, validName, validYear, validPrice, validMaker);
	}

	@Test // Check create Electronic if maker is empty
	public void emptyMakerCreatesElectronic() {
		tester = new Electronic(validId, validName, validYear, validPrice, "");
	}

	@Test // Check get maker
	public void getMakerWorks() {
		assertEquals(tester.getMaker(), validMaker);
	}

	@Test // Check set maker
	public void setMakerWorks() {
		tester.setMaker("Sony");
		assertEquals(tester.maker, "Sony");
	}

	@Test // Check equals
	public void electronicEqualsWorks() {
		Electronic otherElectronic = new Electronic(validId, validName, validYear, validPrice, validMaker);
		assertTrue("both products should be equal", tester.equals(otherElectronic));

		otherElectronic = new Electronic(validId, validName, validYear, validPrice, "Sony");
		assertFalse("different maker should not be equal", tester.equals(otherElectronic));
	}
}