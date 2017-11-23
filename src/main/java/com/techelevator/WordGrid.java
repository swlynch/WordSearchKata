package com.techelevator;

public class WordGrid {

	private char[][] arrayOfCharacters;
	private String[] arrayOfRows;

	public void setGrid(char[][] array) {
		this.arrayOfCharacters = array;
		this.arrayOfRows = convertArrayOfOfArraysCharactersToStrings(array);
	}
	
	public char[][] getGrid() {
		return arrayOfCharacters;
	}
	
	public String[] getArrayOfStrings() {
		return arrayOfRows;
	}

	public void setArrayOfStrings(String[] arrayOfRows) {
		this.arrayOfRows = arrayOfRows;
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
		for (int i = 0; i < arrayOfRows.length; i++) {
			if (arrayOfRows[i].contains(searchWord) || 
					(reverseStringLetters(arrayOfRows[i]).contains(searchWord))) {
				return i;
			}
		}
		return null;
	}
	
	public String stringThatContainsWord(String searchWord) {
		return arrayOfRows[presentInWhichLineOfGridHorizontally(searchWord)];
	}

	public Boolean presentInLineHorizontally(String searchWord) {
		return (stringThatContainsWord(searchWord).contains(searchWord));
	}
	
	public Boolean presentInLineBackwards(String searchWord) {
		return (reverseStringLetters(stringThatContainsWord(searchWord)).contains(searchWord));
	}

	public String reverseStringLetters(String string) {
		String reversed = "";
		for (int i = string.length()-1 ; i >= 0 ; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}
	
//	public boolean isInLineHorizontallyOrInReverse(String searchWord) {
//		return ((stringOfCharacters.indexOf(searchWord) >= 0) || (reverseStringLetters(stringOfCharacters).indexOf(searchWord) >= 0));	
//	}
//
//	public String returnSearchWordLocations(String searchWord) {
//		Integer startLocation = arrayOfStrings.indexOf(searchWord);
//		Integer endLocation = startLocation + searchWord.length() - 1;
//		return "(" + startLocation + "," + endLocation + ")";
//	}

	public String returnLetterIndices(String searchWord) {
		if (presentInLineHorizontally(searchWord)) {
			return indicesForHorizontalWords(searchWord);
		} else if (presentInLineBackwards(searchWord)){
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
}
