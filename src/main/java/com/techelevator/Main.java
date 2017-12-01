package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		//creates instance of WordSearchLoader 
		WordSearchLoader loader = new WordSearchLoader();
		WordSearch wordsearch = loader.generateWordSearch("sample.txt");
		Grid grid = wordsearch.getGrid();
		String [] words = wordsearch.getSearchWords();
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + ":");
			String indices = grid.returnLetterIndices(words[i]);
			System.out.println(indices);
		}
		
	}	


	
}
