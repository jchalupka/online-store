package edu.onlineStore;

/*This is new code*/
import java.util.*;
/**
 * Made By: Jordan Chalupka
 * Course: CIS*2430
 * Semester: F 2016
 *
 * Assignment 1
 */
public class StoreSearch {
	private ArrayList<Product> productAList;

	private static Scanner sc = new Scanner(System.in);

	//private ArrayList<Book> books = new ArrayList<Book>();
	//private ArrayList<Electronic> electronics = new ArrayList<Electronic>();
	private ArrayList<Product> products = new ArrayList<Product>();

	/**
	* Create two empty arraylists.
	* One for Books and Electronics respectively.
	*/
	public StoreSearch() {
		// Two ArrayLists
		// this.books = new ArrayList<Book>();
		// this.electronics = new ArrayList<Electronic>();
		this.productAList = new ArrayList<Product>();
	}

	/**
	* Add a Product to the StoreSearch object.
	* The Product is checked to be guarenteed to have a unique ID to all other Products before being added.
	* @param productToAdd is the Product to be added.
	*/
	public void addToSearch (Product productToAdd) {
	// Check for duplicates of the given productID
	if (this.isUniqueId(productToAdd.getId())) {
	  this.productAList.add(productToAdd);
	}
	else {
	  System.out.println("This ID has already been added.  Please provide a unique ID.");
	}
	return;
	}


	/**
	* Print out all of the products in the store.
	*/
	public void showProducts () {
		Iterator currentProduct = this.productAList.iterator();
		while (currentProduct.hasNext()) {
			System.out.println(currentProduct.next());
		}
	}

	/**
	* Search based on three factors:
	*   i) Product ID
	*  ii) Individual or Range of years
	* iii) KeyWords
	*
	* In order for a result to be retured by this search it must meet atleast one of the previous factors.
	*
	* Product ID must match exactly.
	*  
	* Years can either be entered as a single year, or a range of years.
	* If a range of known years is desired enter both years and set rangeYears to true.
	* If you would like the results to be all years before, or all years after,
	* enter that individual year as the appropriate startYear or endYear and set rangeYears true.
	* If a single year is desired simply enter that year and set rangeYears to false.
	*
	* Keywords entered must be a case-insensitive subword or the product word in order to be returned as a result.
	*
	* An ArrayList of products matching at least one of the search factors is returned.
	* @param  id         Product Identification Number
	* @param  startYear  Starting year of the search request
	* @param  endYear    Ending year of the search request
	* @param  rangeYears If a range of years is to be searched
	* @param  keyWords   Words to search for
	* @return            ArrayList of Products found in search
	*/
	public ArrayList<Product> search (String id, String startYear, String endYear, boolean rangeYears, ArrayList<String> keyWords) {
		ArrayList<Product> results = new ArrayList<Product>();

		// Iterator<Book> currentBook = books.iterator();
		// Iterator<Electronic> currentElectronic = electronics.iterator();
		Iterator<Product> productIter = productAList.iterator();

		Product currentProduct;
		// Run if there is an id
		if (id != null) {
		  while (productIter.hasNext()) {
			currentProduct = productIter.next();
			if(currentProduct.getId().equals(id)) {
			  this.addUnique(currentProduct, results);
			}
		  }
		}

		// currentBook = books.iterator();
		// currentElectronic = electronics.iterator();
		productIter = productAList.iterator();
		// Run if there are any years
		if (startYear != null || endYear != null) {
		  if (rangeYears) {
			if (startYear == null && endYear != null)
			  startYear = "0";
			if (startYear != null && endYear == null)
			  endYear = "9999";
		  } else {
			if (startYear == null) startYear = endYear;
			if (endYear == null) endYear = startYear;
		  }
		  while (productIter.hasNext()) {
			currentProduct = productIter.next();
			if(Integer.parseInt(currentProduct.year) >= Integer.parseInt(startYear) && Integer.parseInt(currentProduct.year) <= Integer.parseInt(endYear)) {
			  this.addUnique(currentProduct, results);
			}
		  }
		}

		// Run if there are any keywords
		if (keyWords != null && keyWords.size() > 0) {
		  // Repeat for each keyword
		  for (int i = 0; i < keyWords.size(); i++) {
			// Search through all products
			// currentBook = books.iterator();
			// currentElectronic = electronics.iterator();
			productIter = productAList.iterator();

			// Book book = new Book();
			// Electronic electronic = new Electronic();
			Product product;

			while (productIter.hasNext()) {
			  product = productIter.next();
			  if(Arrays.asList(product.getName().toLowerCase().split(" ")).contains(keyWords.get(i).toLowerCase())) {
				this.addUnique(product, results);
			  }
			}
		  }
		}

			return results;
	}

	/**
	* If the product is unique add it to the search results
	* @param newProduct A product
	* @param results    Search results
	*/
	private void addUnique (Product newProduct, ArrayList<Product> results) {
		if (isUniqueId(newProduct.getId(), results)) {
		  results.add(newProduct);
		}
	}

	/**
	* Print all products in the results arraylist
	* @param results [contains products added by a search]
	*/
	public static void printSearchResults (ArrayList<Product> results) {
		Iterator<Product> currentResults = results.iterator();

		while (currentResults.hasNext()) {
		  System.out.println(currentResults.next().toString() + "\n");
		}
	}

	/**
	* Check if the ID is unique in the context of the store.
	* @param  id Product Identification Number
	* @return    True if the id is unique to the store object.
	*/
	public boolean isUniqueId (String id) {
		// Check for id in books
		Iterator<Product> currentProduct = this.productAList.iterator();
		while (currentProduct.hasNext()) {
		  if(currentProduct.next().getId().equals(id)) {
			return false;
		  }
		}

		return true;
	}

	/**
	* Checks if the id is unique in the context of search results.
	* @param  id      Product ID
	* @param  results Search Results
	* @return         If the ID is unique
	*/
	public boolean isUniqueId (String id, ArrayList<Product> results) {
		// Check for id previous results
		Iterator<Product> current = results.iterator();
		while (current.hasNext()) {
		  if(current.next().getId().equals(id)) {
			return false;
		  }
		}

		return true;
	}

	/**
	* Check if the ID is unique.
	* @param  id Product Identification Number
	* @return    True if the id is unique to the store object.
	*/
	public boolean isUniqueId (Integer id) {
	return this.isUniqueId(String.valueOf(id));
	}

	/**
	* StoreSearch
	* Class of a search for a store.
	*
	* Each store has 2 ArrayLists, representing the types
	* of products that can be sold in the store:
	*
	* Books
	* Electronics
	*
	* This class allows users to:
	*  -verify if an ID is unique to the store
	*  -search for products
	*  -add items to the store
	*  -list items in the store
	* 
	* @param args Unused
	*/
	public static void main (String[] args) {
		// int testsCorrect = 0;
		// int NUMTESTS = 3;
		// // Do testing here
		// String testId = "111111";
		// String testName = "I-Pod";
		// String testYear = "2003";
		// String testPrice = "20.00";
		// String testMaker = "Walmart";

		// Electronic elect = new Electronic(testId, testName, testYear, testPrice, testMaker);

		// StoreSearch search = new StoreSearch();
		// search.addToSearch(elect);

		// String testId2 = "123456";
		// String testName2 = "I-Pod";
		// String testYear2 = "2010";
		// String testPrice2 = "20.00";
		// String testMaker2 = "Walmart";

		// Electronic elect2 = new Electronic(testId2, testName2, testYear2, testPrice2, testMaker2);
		// search.addToSearch(elect2);

		// System.out.println("Testing range of years:");
		// ArrayList<Product> results = search.search(null, "2003", "2010", true, null);
		// if (results.get(0).equals(elect) && results.get(1).equals(elect2)) {
		//   System.out.println("Passed");
		//   testsCorrect++;
		// }
		// else { 
		//   System.out.println("Failed");
		// }

		// System.out.println("Testing id:");
		// results = search.search("123456",null,null,false, null);
		// if (results.get(0).equals(elect2)) {
		//   System.out.println("Passed");
		//   testsCorrect++;
		// }
		// else {
		//   System.out.println("Failed");
		// }

		// System.out.println("Testing keyWords:");
		// ArrayList<String> searchWords = new ArrayList<String>();
		// searchWords.add("i-pod");
		// searchWords.add("phone");
		// searchWords.add("apple");
		// results = search.search(null, null, null, false, searchWords);
		// if (results.get(0).equals(elect) && results.get(1).equals(elect2)) {
		//   System.out.println("Passed");
		//   testsCorrect++;
		// }
		// else {
		//   System.out.println("Failed");
		// }


		// System.out.format("Total number of tests correct = %d/%d.\n", testsCorrect, NUMTESTS);
	}
}

