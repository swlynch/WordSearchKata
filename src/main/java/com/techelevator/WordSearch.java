package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	private Grid grid;
	private String[] searchWords;
	
	public Grid getGrid() {
		return grid;
	}
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	public String[] getSearchWords() {
		return searchWords;
	}
	public void setSearchWords(String[] searchWords) {
		this.searchWords = searchWords;
	}


}
