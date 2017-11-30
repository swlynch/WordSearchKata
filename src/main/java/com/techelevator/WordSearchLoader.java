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
			List<List<Character>> gridList = new ArrayList<List<Character>>();
			while(read.hasNextLine()) {
				String[] chars = nextLine.split(",");
				//iterate through array and place into List of Chars -- each char is a list item
				List<Character> lineOfChars = new ArrayList<Character>();
				for (int i = 0; i < chars.length; i++) {
					lineOfChars.add((chars[i]).charAt(0));
				}
				gridList.add(lineOfChars);
			}
			char[][] array = new char[gridList.size()][gridList.get(0).size()];
			//iterate through list to populate array
			for (int i = 0; i < array.length; i++) {
//				char[] line = new char[array[i].length];
				List<Character> listOfChars = gridList.get(i);
				for (int k = 0; k < array.length; k++) {
					array[i][k] = listOfChars.get(k);
				}
				grid.setGrid(array);
			}
			wordSearch.setGrid(grid);
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
