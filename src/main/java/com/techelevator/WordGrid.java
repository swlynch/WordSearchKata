package com.techelevator;

public class WordGrid {

	private char[] arrayOfCharacters;
	private String stringOfCharacters;

	public void setLine(char[] array) {
		this.arrayOfCharacters = array;
		this.stringOfCharacters = convertArrayOfCharactersToString(array);
	}
	
	public String convertArrayOfCharactersToString(char[] array) {
		String arrayToString = "";
		for (int i = 0; i < array.length; i++) {
			arrayToString += array[i];
		}
		return arrayToString;
	}
	
	public char[] getLine() {
		return arrayOfCharacters;
	}
	
	public String getStringOfCharacters() {
		return stringOfCharacters;
	}

	public void setStringOfCharacters(String stringOfCharacters) {
		this.stringOfCharacters = stringOfCharacters;
	}
	
	public Boolean presentInLineHorizontally(String searchWord) {
		return (stringOfCharacters.contains(searchWord));
	}
	
	public Boolean presentInLineBackwards(String searchWord) {
		return (reverseStringLetters(stringOfCharacters).contains(searchWord));
	}

	public String reverseStringLetters(String string) {
		String reversed = "";
		for (int i = string.length()-1 ; i >= 0 ; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}
	
	public boolean isInLineHorizontallyOrInReverse(String searchWord) {
		return ((stringOfCharacters.indexOf(searchWord) >= 0) || (reverseStringLetters(stringOfCharacters).indexOf(searchWord) >= 0));	
	}

	public String returnSearchWordLocations(String searchWord) {
		Integer startLocation = stringOfCharacters.indexOf(searchWord);
		Integer endLocation = startLocation + searchWord.length() - 1;
		return "(" + startLocation + "," + endLocation + ")";
	}

	public String returnLetterIndices(String searchWord) {
		if (presentInLineHorizontally(searchWord)) {
			return indicesForHorizontalWords(searchWord);
		} else if (presentInLineBackwards(searchWord)){
			return indicesForWordsInReverse(searchWord);
		}
		return null;
	}
	
	public String indicesForHorizontalWords(String searchWord) {
		Integer startLocation = stringOfCharacters.indexOf(searchWord);
		String letterIndices = "(" + startLocation + ",0),(";
		for (int i = 1; i < searchWord.length(); i++) {
			if (i != searchWord.length() - 1) {
				letterIndices += (startLocation + i) + ",0),(";
			} else {
				letterIndices += (startLocation + i) + ",0)";
			}
		}
		return letterIndices;
	}
	
	public String indicesForWordsInReverse(String searchWord) {
		Integer startLocation = reverseStringLetters(stringOfCharacters).indexOf(searchWord);
		System.out.println(startLocation);
		startLocation += (stringOfCharacters.length() - startLocation - 1);
		String letterIndices = "(" + startLocation + ",0),(";
		for (int i = 1; i <= (searchWord.length() - 1); i++) {
			if (i != searchWord.length() - 1) {
				letterIndices += (startLocation - i) + ",0),(";
			} else {
				letterIndices += (startLocation - i) + ",0)";
			}
		}
		System.out.println(letterIndices);
		return letterIndices;
	}
}
