package com.techelevator;

public class WordGrid {

	private char[][] wordSearchGrid;
	private String[] arrayOfHorizontalStrings;
	private String[] arrayOfRows;
	
	public void setGrid(char[][] array) {
		this.wordSearchGrid = array;
		this.arrayOfHorizontalStrings = makeArrayOfHorizontalStringsInGrid();
	}
	
	public char[][] getGrid() {
		return wordSearchGrid;
	}

	public void setArrayOfHorizontalStrings(String[] arrayOfRows) {
		this.arrayOfHorizontalStrings = arrayOfRows;
	}
	
	public String[] getArrayOfHorizontalStrings() {
		return arrayOfHorizontalStrings;
	}

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

	public Integer presentInWhichLineOfGridHorizontally(String searchWord) {
		for (int i = 0; i < arrayOfHorizontalStrings.length; i++) {
			if (arrayOfHorizontalStrings[i].contains(searchWord) ||
					(reverseStringLetters(arrayOfHorizontalStrings[i]).contains(searchWord))) {
				return i;
			}
		}
		return null;
	}
	
	public String stringThatContainsWordHorizontally(String searchWord) {
		try {
			return arrayOfHorizontalStrings[presentInWhichLineOfGridHorizontally(searchWord)];
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	public String stringThatContainsWordHorizontalAndBackwards(String searchWord) {
		return reverseStringLetters(arrayOfHorizontalStrings[presentInWhichLineOfGridHorizontally(searchWord)]);
	}

	public Boolean isPresentInGridHorizontally(String searchWord) {
		if (stringThatContainsWordHorizontally(searchWord).contains(searchWord)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean isPresentInGridBackwards(String searchWord) {
		if (stringThatContainsWordHorizontalAndBackwards(searchWord).contains(searchWord)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String stringThatContainsWord(String searchWord) {
		return arrayOfRows[presentInWhichLineOfGridHorizontally(searchWord)];
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

	public String returnLetterIndices(String searchWord) {
		if (isPresentInGridHorizontally(searchWord)) {
			return indicesForHorizontalWords(searchWord);
		} else if (isPresentInGridBackwards(searchWord)){
			return indicesForWordsInReverse(searchWord);
		} else {
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
		Integer startLocation = stringThatContainsWordHorizontalAndBackwards(searchWord).indexOf(searchWord);
		String string = stringThatContainsWordHorizontalAndBackwards(searchWord);
		startLocation = (string.length() - startLocation - 1);
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

	public boolean isPresentVertically(String string) {
		return false;
	}

}
