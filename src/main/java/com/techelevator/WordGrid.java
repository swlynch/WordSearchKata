package com.techelevator;

public class WordGrid {

	private char[][] wordSearchGrid;
	private String[] arrayOfHorizontalStrings;
	private String[] arrayOfVerticalStrings;
	private String[] arrayOfDiagonalDescendingStrings;
	private String[] arrayOfRows;
	
	public void setGrid(char[][] array) {
		this.wordSearchGrid = array;
		this.arrayOfHorizontalStrings = makeArrayOfHorizontalStringsInGrid();
		this.arrayOfVerticalStrings = makeArrayOfVerticalStringsInGrid();
		this.arrayOfDiagonalDescendingStrings = makeArrayOfDiagonalDescendingStrings();
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

	public String[] getArrayOfVerticalStrings() {
		return arrayOfVerticalStrings;
	}
	
	public String[] getArrayOfDiagonalDescendingStrings() {
		return arrayOfDiagonalDescendingStrings;
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

	private String[] makeArrayOfVerticalStringsInGrid() {
		String[] arrayOfStrings = new String[wordSearchGrid.length];
		for (int i = 0; i < wordSearchGrid.length; i++) {
			String stringFromCharacters = "";
			for (int k = 0; k < wordSearchGrid[i].length; k++) {
				stringFromCharacters += wordSearchGrid[k][i];
			}
			arrayOfStrings[i] = stringFromCharacters;
		}
		return arrayOfStrings;
	}

	private String[] makeArrayOfDiagonalDescendingStrings() {
		String[] diagonalArray = new String[wordSearchGrid.length * 2 - 1];
		int gridLength = wordSearchGrid.length - 1;
		for (int i = 0; i <= (gridLength); i++) {
			String string = ""; 
			string += wordSearchGrid[gridLength - i][0];
			diagonalArray[i] = string;
		}
		return diagonalArray;
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
	
	public Integer presentInWhichLineOfGrid(String[] array, String searchWord) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].contains(searchWord) ||
					(reverseStringLetters(array[i]).contains(searchWord))) {
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

	public Boolean isPresentHorizontally(String searchWord) {
		for (int i = 0; i < arrayOfHorizontalStrings.length; i++) {
			if (arrayOfHorizontalStrings[i].contains(searchWord)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean isPresentHorizontalAndBackwards(String searchWord) {
		for (int i = 0; i < arrayOfHorizontalStrings.length; i++) {
			if (reverseStringLetters(arrayOfHorizontalStrings[i]).contains(searchWord)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isPresentVertically(String searchWord) {
		for (int i = 0; i < arrayOfVerticalStrings.length; i++) {
			if (arrayOfVerticalStrings[i].contains(searchWord)) {
				return true;
			}
		} 
		return false;
	}
	
	public boolean isPresentVerticalAndBackwards(String searchWord) {
		for (int i = 0; i < arrayOfVerticalStrings.length; i++) {
			if (reverseStringLetters(arrayOfVerticalStrings[i]).contains(searchWord)) {
				return true;
			}
		} 
		return false;
	}
	

	public boolean isPresentDiagonallyDescending(String searchWord) {
		for (int i = 0; i < arrayOfDiagonalDescendingStrings.length; i++) {
			if (arrayOfDiagonalDescendingStrings[i].contains(searchWord)) {
				return true;
			}
		}
		return false;
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
		if (isPresentHorizontally(searchWord)) {
			return indicesForHorizontalWords(searchWord);
		} else if (isPresentHorizontalAndBackwards(searchWord)){
			return indicesForWordsInReverse(searchWord);
		} else if (isPresentVertically(searchWord)){
			return indicesForVerticalWords(searchWord);
		} else if (isPresentVerticalAndBackwards(searchWord)) {
			return indicesForVerticalAndBackwardsWords(searchWord);
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

	private String indicesForVerticalWords(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGrid(arrayOfVerticalStrings, searchWord);
		String string = arrayOfVerticalStrings[lineWithWord];
		Integer startLocation = string.indexOf(searchWord);
		String letterIndices = "(" + lineWithWord + "," + startLocation + "),(";
		for (int i = 1; i <= (searchWord.length() - 1); i++) {
			if (i != searchWord.length() - 1) {
				letterIndices += (lineWithWord) + "," + (startLocation + i) +"),(";
			} else {
				letterIndices += (lineWithWord) + "," + (startLocation + i) + ")";
			}
		}
		return letterIndices;
	}
	
	private String indicesForVerticalAndBackwardsWords(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGrid(arrayOfVerticalStrings, searchWord);
		String string = reverseStringLetters(arrayOfVerticalStrings[lineWithWord]);
		Integer startLocation = string.indexOf(searchWord);
		startLocation = (string.length() - startLocation - 1);
		String letterIndices = "(" + lineWithWord + "," + startLocation + "),(";
		for (int i = 1; i <= (searchWord.length() - 1); i++) {
			if (i != searchWord.length() - 1) {
				letterIndices += lineWithWord + "," + (startLocation - i) +"),(";
			} else {
				letterIndices += lineWithWord + "," + (startLocation - i) + ")";
			}
		}
		return letterIndices;
	}




}
