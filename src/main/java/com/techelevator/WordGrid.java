package com.techelevator;

public class WordGrid {

	private char[][] wordSearchGrid;
	private String[] arrayOfHorizontalStrings;
//	private String[] arrayOfVerticalStrings;
	private char[][] arrayOfCharacters;
	private String[] arrayOfRows;
	
	public void setGrid(char[][] array) {
		this.wordSearchGrid = array;
		this.arrayOfHorizontalStrings = makeArrayOfHorizontalStringsInGrid();
//		this.arrayOfVerticalStrings = makeArrayOfVerticalStringsInGrid();
	}
	
	public char[][] getGrid() {
		return wordSearchGrid;
	}
	
	public String[] getArrayOfHorizontalStrings() {
		return arrayOfHorizontalStrings;
	}

	public void setArrayOfHorizontalStrings(String[] arrayOfRows) {
		this.arrayOfHorizontalStrings = arrayOfRows;
	}
	
//	public String[] getArrayOfVerticalStrings() {
//		return arrayOfVerticalStrings;
//	}

	public String[] makeArrayOfHorizontalStringsInGrid() {
		String[] arrayOfStrings = new String[wordSearchGrid.length];
		for (int i = 0; i < wordSearchGrid.length; i++) {
			String stringFromCharacters = "";
			for (int k = 0; k < wordSearchGrid[i].length; k++) {
				stringFromCharacters += wordSearchGrid[i][k];
			}
			arrayOfStrings[i] = stringFromCharacters;
		}
		return arrayOfStrings;
	}
	
//	public String[] makeArrayOfVerticalStringsInGrid() {
//		String[] verticalStrings = new String[wordSearchGrid.length];
//		for (int i = 0; i < verticalStrings.length; i++) {
//			String stringFromCharacters = "";
//			for (int k = 0; k < wordSearchGrid.length; k++) {
//				stringFromCharacters += this.wordSearchGrid[k][i];
//			}
//			arrayOfHorizontalStrings[i] = stringFromCharacters;
//		}
//		return verticalStrings;
//	}
	
	public Integer presentInWhichLineOfGridHorizontally(String searchWord) {
		for (int i = 0; i < arrayOfHorizontalStrings.length; i++) {
			if (arrayOfHorizontalStrings[i].contains(searchWord) || 
					(reverseStringLetters(arrayOfHorizontalStrings[i]).contains(searchWord))) {
				return i;
			}
		}
		return null;
	}

//	private Integer presentInWhichLineOfGridVertically(String searchWord) {
//		for (int i = 0; i < arrayOfVerticalStrings.length; i++) {
//			if (arrayOfVerticalStrings[i].contains(searchWord) ||
//					(reverseStringLetters(arrayOfVerticalStrings[i]).contains(searchWord))){
//		for (int i = 0; i < arrayOfRows.length; i++) {
//			if (arrayOfRows[i].contains(searchWord) || 
//					(reverseStringLetters(arrayOfRows[i]).contains(searchWord))) {
//				return i;
//			}
//		}
//		return null;
//	}
	
	public String stringThatContainsWordHorizontally(String searchWord) {
		return arrayOfHorizontalStrings[presentInWhichLineOfGridHorizontally(searchWord)];
	}
//	
//	public String stringThatContainsWordVertically(String searchWord) {
//		return arrayOfVerticalStrings[presentInWhichLineOfGridVertically(searchWord)];
//	}

	public Boolean presentInGridHorizontally(String searchWord) {
		try {
			stringThatContainsWordHorizontally(searchWord).contains(searchWord);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	public Boolean presentInGridBackwards(String searchWord) {
		try {
			reverseStringLetters(stringThatContainsWordHorizontally(searchWord)).contains(searchWord);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	public String stringThatContainsWord(String searchWord) {
		return arrayOfRows[presentInWhichLineOfGridHorizontally(searchWord)];
	}
	
	public Boolean presentInLineBackwards(String searchWord) {
		return (reverseStringLetters(stringThatContainsWord(searchWord)).contains(searchWord));
	}
//
//	public boolean presentInGridVertically(String searchWord) {
//		return (stringThatContainsWordVertically(searchWord).contains(searchWord));
//	}
	
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
//		} else if (presentInGridVertically(searchWord)) {
//			return indicesForVerticalWords(searchWord);
//		} else {
			else {
			return null;
		}
	}

	public String indicesForHorizontalWords(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGridHorizontally(searchWord);
		Integer startLocation = stringThatContainsWordHorizontally(searchWord).indexOf(searchWord);
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
		Integer startLocation = reverseStringLetters(stringThatContainsWordHorizontally(searchWord)).indexOf(searchWord);
		startLocation = (stringThatContainsWordHorizontally(searchWord).length() - startLocation - 1);
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
//
//	private String indicesForVerticalWords(String searchWord) {
//		Integer lineWithWord = presentInWhichLineOfGridVertically(searchWord);
//		Integer startLocation = reverseStringLetters(stringThatContainsWordVertically(searchWord)).indexOf(searchWord);
//		String letterIndices = "(" + startLocation + "," + lineWithWord + "),(";
//		for (int i = 1; i <= (searchWord.length() - 1); i++) {
//			if (i != searchWord.length() - 1) {
//				letterIndices += (startLocation - i) + "," + lineWithWord +"),(";
//			} else {
//				letterIndices += (startLocation - i) + "," + lineWithWord + ")";
//			}
//		}
//		return letterIndices;		
//	}

}
