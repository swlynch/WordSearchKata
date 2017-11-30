package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSearchLoader {

	private File file;
	private Grid grid;
	private WordSearch wordSearch;
	
	public WordSearch generateWordSearch(String file) {
		File wordSearchFile = new File(file);
		wordSearch = new WordSearch();
		try(Scanner read = new Scanner(wordSearchFile)) {
			String nextLine = read.nextLine();
			wordSearch.setSearchWords(createSearchWordsArray(nextLine));
			List<List<Character>> grid = new ArrayList<List<Character>>();
			while(read.hasNextLine()) {
				//parse line based on comma separator = new array of strings
				//iterate through array and place into List of Chars -- each char is a list item
				
			}
			char[][] array = new char[grid.size()][grid.get(0).size()];
			//iterate through list to populate array
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return wordSearch;
	}
	
	public String[] createSearchWordsArray(String nextLine) {
		String[] searchWords = nextLine.split(",");
		return searchWords;
	}

}
