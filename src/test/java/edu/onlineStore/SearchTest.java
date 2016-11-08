package edu.onlineStore;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchTest {

	@Test // Check do not return items that match only part of the search request
	public void doesNotReturnItemsThatDoNotMatchEntireSearchRequest() {
		//Search request = new SearchRequest();
	}
	
	@Test // Check search based on specific year
	public void searchWorksForSpecificYear() {

	}

	@Test // Check search based on less than year
	public void searchWorksForLessThanYear() {

	}
		
	@Test // Check search based on greater than year
	public void searchWorksForGreaterThanYear() {

	}
		
	@Test // Check search based on range of year
	public void searchWorksForRangeOfYears() {

	}
		
	@Test // Check search based on ID
	public void searchWorksForId() {

	}
	
	@Test // Check search based on key word in name
	public void searchWorksForKeyWordInName() {

	}
	
	@Test // Check do not return non name key word
	public void searchDoesNotReturnNonNameKeyWords() {

	}
	
	@Test // Check return all products if search request is empty 
	public void searchReturnsAllProductsIfSearchRequestIsEmpty() {

	}

	/*Check the matching*/
	@Test // Check match exact keyword
	public void mathesExactKeyWord() {

	}
	
	@Test // Check match keyword case insensitive
	public void matchesCaseInsensitive() {

	}
	
	@Test // Check not matching subset or superset of keyword
	public void doesNotMatchSubsetOrSuperSetOfKeyWord() {

	}
	
	@Test // Check matching key word out of order
	public void matchesKeyWordOutOfOrder() {

	}
	
}