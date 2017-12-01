package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private WordSearch wordSearch;
	private WordSearchLoader loader;
		
	public void run() {
		//creates instance of WordSearchLoader 
		loader = new WordSearchLoader();
		loader.generateWordSearch("sample.txt");
		
		//iterates through WordSearch and prints out words
	}	


	
}
