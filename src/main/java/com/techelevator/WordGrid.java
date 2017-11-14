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
		System.out.println(reversed);
		return reversed;
	}
	
}
