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
		//builds first half of diagonal array
		for (int i = 0; i <= (gridLength); i++) {
			String string = "";
			int counter = gridLength;
			//k is for what # element across in the wordSearchGrid
			for (int k = 0; k <= i; k++) {
				string += wordSearchGrid[counter - i][k];
				counter++;
			}
			diagonalArray[i] = string;
		}
		//builds second half of diagonal array
		for (int i = 0; i < gridLength; i++) {
			String string = "";
			int counter = 0;
			for (int k = 1; k <= (gridLength - i); k++) {
				string += wordSearchGrid[counter][k + i];
				counter++;
			}
			diagonalArray[gridLength + i + 1] = string;
		}
		return diagonalArray;
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
			return arrayOfHorizontalStrings[presentInWhichLineOfGrid(arrayOfHorizontalStrings, searchWord)];
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	public String stringThatContainsWordHorizontalAndBackwards(String searchWord) {
		return reverseStringLetters(arrayOfHorizontalStrings[presentInWhichLineOfGrid(arrayOfHorizontalStrings, searchWord)]);
	}
	
	public String stringThatContainsWordDiagonalDescending(String searchWord) {
		try {
			return arrayOfDiagonalDescendingStrings[presentInWhichLineOfGrid(arrayOfDiagonalDescendingStrings, searchWord)];
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	public String stringThatContainsWordDiagonalDescendingBackward(String searchWord) {
		try {
			return reverseStringLetters(arrayOfDiagonalDescendingStrings[presentInWhichLineOfGrid(arrayOfDiagonalDescendingStrings, searchWord)]);
		} catch (NullPointerException e) {
			return null;
		}
		
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
	
	public boolean isPresentDiagonalDescendingBackwards(String searchWord) {
		for (int i = 0; i < arrayOfDiagonalDescendingStrings.length; i++) {
			if (reverseStringLetters(arrayOfDiagonalDescendingStrings[i]).contains(searchWord)) {
				return true;
			}
		}
		return false;
	}

	private String reverseStringLetters(String string) {
		String reversed = "";
		for (int i = string.length()-1 ; i >= 0 ; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}

	public String returnLetterIndices(String searchWord) {
		if (isPresentHorizontally(searchWord)) {
			return indicesForHorizontal(searchWord);
		} else if (isPresentHorizontalAndBackwards(searchWord)){
			return indicesForWordsHorizontalBackwards(searchWord);
		} else if (isPresentVertically(searchWord)){
			return indicesForVertical(searchWord);
		} else if (isPresentVerticalAndBackwards(searchWord)) {
			return indicesForVerticalAndBackwards(searchWord);
		} else if (isPresentDiagonallyDescending(searchWord)) {
			return indicesForDiagonalDescending(searchWord);
		} else if (isPresentDiagonalDescendingBackwards(searchWord)) {
			return indicesForDiagonalDescendingBackwards(searchWord);
		}
		
		else {
			return null;
		}
	}

	private String indicesForHorizontal(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGrid(arrayOfHorizontalStrings, searchWord);
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
	
	private String indicesForWordsHorizontalBackwards(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGrid(arrayOfHorizontalStrings, searchWord);
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

	private String indicesForVertical(String searchWord) {
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
	
	private String indicesForVerticalAndBackwards(String searchWord) {
		Integer arrayIndexOfWord = presentInWhichLineOfGrid(arrayOfVerticalStrings, searchWord);
		String string = reverseStringLetters(arrayOfVerticalStrings[arrayIndexOfWord]);
		Integer startLocation = string.indexOf(searchWord);
		startLocation = (string.length() - startLocation - 1);
		String letterIndices = "(" + arrayIndexOfWord + "," + startLocation + "),(";
		for (int i = 1; i <= (searchWord.length() - 1); i++) {
			if (i != searchWord.length() - 1) {
				letterIndices += arrayIndexOfWord + "," + (startLocation - i) +"),(";
			} else {
				letterIndices += arrayIndexOfWord + "," + (startLocation - i) + ")";
			}
		}
		return letterIndices;
	}

	private String indicesForDiagonalDescending(String searchWord) {
		Integer arrayIndexOfWord = presentInWhichLineOfGrid(arrayOfDiagonalDescendingStrings, searchWord);
		int xLocation, yLocation;
		if (arrayIndexOfWord >= wordSearchGrid.length) {
			yLocation = stringThatContainsWordDiagonalDescending(searchWord).indexOf(searchWord); 
			xLocation = arrayIndexOfWord - wordSearchGrid.length + 1;
		} else {
			xLocation = stringThatContainsWordDiagonalDescending(searchWord).indexOf(searchWord);
			yLocation = wordSearchGrid.length - arrayIndexOfWord;
		}		
		String indices = "(" + xLocation + "," + yLocation + "),(";
		for (int i = 1; i < searchWord.length() - 1; i++) {
			xLocation++;
			yLocation++;
			indices += xLocation + "," + yLocation + "),(";
		}
		indices += (xLocation + 1) + "," + (yLocation + 1) + ")";
		return indices;
	}

	private String indicesForDiagonalDescendingBackwards(String searchWord) {
		Integer arrayIndexOfWord = presentInWhichLineOfGrid(arrayOfDiagonalDescendingStrings, searchWord);
		int xLocation,yLocation;
		if (arrayIndexOfWord >= wordSearchGrid.length) {
			String reverseString = reverseStringLetters(arrayOfDiagonalDescendingStrings[arrayIndexOfWord]);
			yLocation = reverseString.length() - reverseString.indexOf(searchWord) - 1;
			xLocation = arrayIndexOfWord - wordSearchGrid.length + yLocation + 1; 
		} else {
			String reverseString = reverseStringLetters(arrayOfDiagonalDescendingStrings[arrayIndexOfWord]);
			xLocation = reverseString.length() - reverseString.indexOf(searchWord) - 1;
			yLocation = wordSearchGrid.length - arrayIndexOfWord + xLocation - 1; 
		}
		String indices = "(" + xLocation + "," + yLocation + "),(";
		for (int i = 1; i < searchWord.length() - 1; i++) {
			xLocation--;
			yLocation--;
			indices += xLocation + "," + yLocation + "),(";
		}
		indices += (xLocation - 1) + "," + (yLocation - 1) + ")";
		return indices;
	}







}
