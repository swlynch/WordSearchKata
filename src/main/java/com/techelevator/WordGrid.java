package com.techelevator;

public class WordGrid {

	private char[][] arrayOfCharacters;
	private String[] arrayOfStrings;

	public void setGrid(char[][] array) {
		this.arrayOfCharacters = array;
		this.arrayOfStrings = convertArrayOfOfArraysCharactersToStrings(array);
	}
	
	public char[][] getGrid() {
		return arrayOfCharacters;
	}
	
	public String[] getArrayOfStrings() {
		return arrayOfStrings;
	}

	public void setArrayOfStrings(String[] arrayOfRows) {
		this.arrayOfStrings = arrayOfRows;
	}
	
	public String[] convertArrayOfOfArraysCharactersToStrings(char[][] array) {
		String[] arrayOfString = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			String stringFromCharacters = "";
			for (int k = 0; k < array[i].length; k++) {
				stringFromCharacters += array[i][k];
			}
			arrayOfString[i] = stringFromCharacters;
		}
		return arrayOfString;
	}
	
	public Integer presentInWhichLineOfGridHorizontally(String searchWord) {
		for (int i = 0; i < arrayOfStrings.length; i++) {
			if (arrayOfStrings[i].contains(searchWord) || 
					(reverseStringLetters(arrayOfStrings[i]).contains(searchWord))) {
				return i;
			}
		}
		return null;
	}
	
	public String stringThatContainsWord(String searchWord) {
		return arrayOfStrings[presentInWhichLineOfGridHorizontally(searchWord)];
	}

	public Boolean presentInGridHorizontally(String searchWord) {
		return (stringThatContainsWord(searchWord).contains(searchWord));
	}
	
	public Boolean presentInGridBackwards(String searchWord) {
		return (reverseStringLetters(stringThatContainsWord(searchWord)).contains(searchWord));
	}

	public String reverseStringLetters(String string) {
		String reversed = "";
		for (int i = string.length()-1 ; i >= 0 ; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}

	public String returnLetterIndices(String searchWord) {
		if (presentInGridHorizontally(searchWord)) {
			return indicesForHorizontalWords(searchWord);
		} else if (presentInGridBackwards(searchWord)){
			return indicesForWordsInReverse(searchWord);
		}
		return null;
	}
	
	public String indicesForHorizontalWords(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGridHorizontally(searchWord);
		Integer startLocation = stringThatContainsWord(searchWord).indexOf(searchWord);
		String letterIndices = "(" + startLocation + "," + lineWithWord + "),(";
		for (int i = 1; i < searchWord.length(); i++) {
			if (i != searchWord.length() - 1) {
				letterIndices += (startLocation + i) + "," + lineWithWord + "),(";
			} else {
				letterIndices += (startLocation + i) + "," + lineWithWord + ")";
			}
		}
		return letterIndices;
	}
	
	public String indicesForWordsInReverse(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGridHorizontally(searchWord);
		Integer startLocation = reverseStringLetters(stringThatContainsWord(searchWord)).indexOf(searchWord);
		startLocation = (stringThatContainsWord(searchWord).length() - startLocation - 1);
		String letterIndices = "(" + startLocation + "," + lineWithWord + "),(";
		for (int i = 1; i <= (searchWord.length() - 1); i++) {
			if (i != searchWord.length() - 1) {
				letterIndices += (startLocation - i) + "," + lineWithWord +"),(";
			} else {
				letterIndices += (startLocation - i) + "," + lineWithWord + ")";
			}
		}
		return letterIndices;
	}

	public boolean isPresentInGridVertically(String string) {
		return false;
	}
}
