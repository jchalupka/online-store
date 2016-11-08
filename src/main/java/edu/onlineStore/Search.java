package edu.onlineStore;

import java.util.*;

public class Search {
	public ArrayList<Product> results;

	public String id;
	public String startYear;
	public String endYear;
	public ArrayList<String> keyWords;

	public Search(String id, String startYear, String endYear, ArrayList<String> keyWords) {
		this.id = id;
		this.startYear = startYear;
		this.endYear = endYear;
		this.keyWords = keyWords;
	}

	public ArrayList<Product> doSearch(ArrayList<Product> store) {
		results = store;
		
		if (id != null)
			filterId();
		if (startYear != null || endYear != null)
			filterYear();
		if (keyWords != null)
			filterKeyWords();

		return results;
	}

	private void filterId() {
		int index = 0;
		for(Product product : this.results) {
			if(!this.id.equals(product.id))
				results.remove(index);
			index++;
		}
	}

	private void filterYear() {
		int index = 0;
		for(Product product : this.results) {
			if((startYear != null )&& (Integer.valueOf(this.startYear) < Integer.valueOf(product.year)))
				results.remove(index);
			if((endYear != null )&& (Integer.valueOf(this.endYear) > Integer.valueOf(product.year)))
				results.remove(index);
			index++;
		}
	}

	private void filterKeyWords() {
		int index = 0;
		String cur;
		for(Product product : this.results) {
			for (String word: this.keyWords) {
				if(!Arrays.asList(product.getName().toLowerCase().split(" ")).contains(word.toLowerCase())) {
					results.remove(index);
				}
			}
			index++;
		}
	}

	public static void main(String[] args) {
		Search search = new Search(null, null, null, null);
	}

}

