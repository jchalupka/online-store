package edu.onlineStore;

/*This is new code*/
/**
 * Made By: Jordan Chalupka
 * Course: CIS*2430
 * Semester: F 2016
 *
 * Assignment 1
 */
public class Electronic extends Product {
  protected String maker;

  public Electronic (String id, String name, String year, String price, String maker) {
    super(id, name, year, price);
      if (this.id != null)
        this.maker = maker;
  }

  public String getMaker () {
    return maker;
  }

  public void setMaker (String newMaker) {
    this.maker = newMaker;
  }

  public String toString () {
    return super.toString() + "\nMaker: " + getMaker();
  }

  public boolean equals (Electronic otherElectronic) {
    return super.equals(otherElectronic) && this.maker == otherElectronic.maker;
  }

  public static void main(String[] args) {
    // Do testing here
    // int testsCorrect = 0;
    // int NUMTESTS = 8;
    // String testId = "111111";
    // String testName = "I-Pod";
    // String testYear = "2003";
    // String testPrice = "20.00";
    // String testMaker = "Walmart";


    // System.out.println("Creating a valid Electronic with all attributes:");
    // Electronic elect = new Electronic(testId, testName, testYear, testPrice, testMaker);
    // System.out.println("Testing the correctness of all Electronic attributes");
    // if (elect.id.equals(testId)) {
    //   System.out.println("Id Correct.");
    //   testsCorrect++;
    // }
    // else {
    //   System.out.println("Id Error.");
    // }

    // if (elect.name.equals(testName)) {
    //   System.out.println("Name Correct.");
    //   testsCorrect++;
    // }
    // else {
    //   System.out.println("Name Error.");
    // }

    // if (elect.year.equals(testYear)) {
    //   System.out.println("Year Correct.");
    //   testsCorrect++;
    // }
    // else {
    //   System.out.println("Year Error.");
    // }

    // if (elect.price.equals(testPrice)) {
    //   System.out.println("Price Correct.");
    //   testsCorrect++;
    // }
    // else {
    //   System.out.println("Price Error.");
    // }

    // if (elect.maker.equals(testMaker)) {
    //   testsCorrect++;
    //   System.out.println("Maker Correct.");
    // }
    // else {
    //   System.out.println("Maker Error.");
    // }

    // System.out.println("Changing the maker attribute:");
    // String newMaker = "Apple";
    // elect.setMaker(newMaker);
    // if (elect.getMaker().equals(newMaker)) {
    //   testsCorrect++;
    //   System.out.println("New Maker Correct");
    // }
    // else {
    //   System.out.println("New Maker Incorrect.");
    // }

    // System.out.println("Displaying toString for Electronic:");
    // System.out.println(elect.toString());

    // System.out.println("Testing equals for Electronics:");
    // elect = new Electronic(testId, testName, testYear, testPrice, testMaker);
    // Electronic otherElect = new Electronic(testId, testName, testYear, testPrice, testMaker);
    // boolean equals = elect.equals(otherElect);
    // if (equals) {
    //   System.out.println("Equals works properly for two equal Electronics.");
    //   testsCorrect++;
    // }
    // else {
    //   System.out.println("Equals does not work properly for two equals Electronics.");
    // }
    
    // otherElect = new Electronic(testId, testName, "2078", testPrice, testMaker);
    // equals = elect.equals(otherElect);
    // if (!equals) {
    //   System.out.println("Equals works properly for two not equal Electronics.");
    //   testsCorrect++;
    // }
    // else {
    //   System.out.println("Equals does not work properly for two not equal Electronics.");
    // }

    // System.out.format("Total number of tests correct = %d/%d.\n", testsCorrect, NUMTESTS);
  }
}
// EOF
