package edu.onlineStore;

/*This is new code*/
/**
 * Made By: Jordan Chalupka
 * Course: CIS*2430
 * Semester: F 2016
 *
 * Assignment 1
 */
public class Product {
  protected String id;
  protected String name;
  protected String price;
  protected String year;

  public static final int ID_LENGTH = 6;
  public static final int MIN_YEAR_VALUE = 1000;
  public static final int MAX_YEAR_VALUE = 9999;

  // Constructors
  public Product (String id, String name, String year, String price) {
  	invariantChecker(id, name, year, price);
    this.id = id;
    this.name = name;
    this.year = year;
    this.price = price;
  }

  // Invariant Checker
  public static boolean invariantChecker(String id, String name, String year, String price) {
  	// Check that the value is in between the min and max inclusive
    if (!isValidId(id))
    	throw new IllegalArgumentException("invalid product id");

    if (!isValidName(name))
    	throw new IllegalArgumentException("invalid produce name");

    if (!isValidYear(year))
    	throw new IllegalArgumentException("invalid product year");

    if (!isValidPrice(price))
    	throw new IllegalArgumentException("invalid product price");

    return true;
  }
  // Methods
  public String getId () {
    return id;
  }

  public void setId(String newId) {
   	if(isValidId(newId)) 
    	this.id = newId;
  }

  public String getName () {
    return name;
  }

  public void setName (String newName) {
    if(isValidName(newName))
    	this.name = newName;
  }

  public String getYear () {
    return year;
  }

  public void setYear (String newYear) {
  	if(isValidYear(newYear))
    	this.year = newYear;
  }

  public String getPrice () {
    return price;
  }

  public void setPrice (String newPrice) {
    if(isValidPrice(newPrice))
    	this.price = newPrice;
  }

  public String toString () {
    return "ID: " + getId() +
           "\nProduct: " + getName() +
           "\nYear: " + getYear() +
           "\nPrice: " + getPrice();
  }

  public boolean equals (Product otherProduct) {
    if (otherProduct == null)
      return false;

    if (this.id == otherProduct.id && 
        this.name == otherProduct.name && 
        this.year == otherProduct.year &&
        this.price == otherProduct.price)
      return true;
    else
      return false;
  }

  // Helper Methods
  private static boolean inRange (Integer x, Integer low, Integer high, Integer inclusive) {
    if(x > low - inclusive && x < high + inclusive)
      return true;
    return false;
  }

  public static boolean isValidId (String id) {
    boolean valid = id.length() == ID_LENGTH  && id.matches("[0-9]{6}");
    if (!valid) {
      System.out.format("Error: the Product ID must be %d digits.\n", ID_LENGTH);
      return false;
    }
    return true;
  }

  // Year must be from 1000 to 9999
  public static boolean isValidYear (String year) {
    boolean valid = year.matches("[1-9][0-9]{3}") /*&& inRange(Integer.parseInt(year), MIN_YEAR_VALUE, MAX_YEAR_VALUE,1)*/;
    if (!valid) {
      System.out.println("Error: the year must be a number between 1000 and 9999.\n");
      return false;
    }
    return true;
  }

  public static boolean isValidName (String name) {
    // No restrictions set, just need an input of any kind.
    boolean valid = name.matches(".+");
    if (!valid) {
      System.out.println("Error: product name is required.");
      return false;
    }
    return true;
  } 

  // Price must be a number with an integer component and can have two decimal places
  public static boolean isValidPrice (String price) {
    boolean valid = price.matches("^[0-9]+[.]?[0-9]{0,2}$|^$");
    if (!valid) {
      System.out.println("Error: please enter a valid price.");
      return false;
    }
    return true;
  }


  // Main
  public static void main (String[] args) {
    // Do testing here
    // Product myProduct = new Product();
    // Electronic myElectronic = new Electronic();
    // Product myOtherProduct = new Product("100011", "baseball", "1990", "33");
    // Electronic myOtherElectronic = new Electronic("102311", "iPod", "2003", "299", "apple");

    // System.out.println(myOtherProduct.toString());
    // System.out.println(myOtherElectronic.toString());
  }
}
