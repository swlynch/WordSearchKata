package com.techelevator;

public class WordGrid {

	String line = "WORDYDNAC";
	
	public int returnIndex(String string) {
		return line.indexOf(string);
	}

	public boolean isInLine(String string) {
		return ((line.indexOf(string) >= 0) || (reverseStringLetters(line).indexOf(string) >= 0));	
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
