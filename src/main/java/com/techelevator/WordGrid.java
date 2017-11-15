package com.techelevator;

public class WordGrid {

	private char[] arrayOfCharacters;
	private String stringOfCharacters;
	
	public void setLine(char[] array) {
		this.arrayOfCharacters = array;
		this.stringOfCharacters = convertArrayOfCharactersToString(array);
	}
	
	public char[] getLine() {
		return arrayOfCharacters;
	}
	
	public int returnIndex(String string) {
		return stringOfCharacters.indexOf(string);
	}

	public String reverseStringLetters(String string) {
		String reversed = "";
		for (int i = string.length()-1 ; i >= 0 ; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}
	
	public boolean isInLine(String searchWord) {
		return ((stringOfCharacters.indexOf(searchWord) >= 0) || (reverseStringLetters(stringOfCharacters).indexOf(searchWord) >= 0));	
	}
	
	public String convertArrayOfCharactersToString(char[] array) {
		String arrayToString = "";
		for (int i = 0; i < array.length; i++) {
			arrayToString += array[i];
		}
		return arrayToString;
	}

	public String returnSearchWordLocation(String searchWord) {
		Integer startLocation = this.returnIndex(searchWord);
		Integer endLocation = startLocation + searchWord.length() - 1;
		return "(" + startLocation + "," + endLocation + ")";
	}
	
}
