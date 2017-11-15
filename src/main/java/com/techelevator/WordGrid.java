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

	public boolean isInLine(String string) {
		return ((stringOfCharacters.indexOf(string) >= 0) || (reverseStringLetters(stringOfCharacters).indexOf(string) >= 0));	
	}

	public String reverseStringLetters(String string) {
		String reversed = "";
		for (int i = string.length()-1 ; i >= 0 ; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}
	
	public String convertArrayOfCharactersToString(char[] array) {
		String arrayToString = "";
		for (int i = 0; i < array.length; i++) {
			arrayToString += array[i];
		}
		return arrayToString;
	}
	
}
