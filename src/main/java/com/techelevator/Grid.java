package com.techelevator;

public class Grid {

	private char[][] wordGrid;
	private String[] horizontalStrings;
	private String[] verticalStrings;
	private String[] diagonalDescendingStrings;
	private String[] diagonalAscendingStrings;
	
	public void setGrid(char[][] array) {
		this.wordGrid = array;
		this.horizontalStrings = makeArrayOfHorizontalStringsInGrid();
		this.verticalStrings = makeArrayOfVerticalStringsInGrid();
		this.diagonalDescendingStrings = makeArrayOfDiagonalDescendingStrings();
		this.diagonalAscendingStrings = makeArrayOfDiagonalAscendingStrings();
	}

	public char[][] getGrid() {
		return wordGrid;
	}

	public void setArrayOfHorizontalStrings(String[] arrayOfRows) {
		this.horizontalStrings = arrayOfRows;
	}
	
	public String[] getArrayOfHorizontalStrings() {
		return horizontalStrings;
	}

	public String[] getArrayOfVerticalStrings() {
		return verticalStrings;
	}
	
	public String[] getArrayOfDiagonalDescendingStrings() {
		return diagonalDescendingStrings;
	}
	
	public String[] getArrayOfDiagonalAscendingStrings() {
		return diagonalAscendingStrings;
	}


	public String[] makeArrayOfHorizontalStringsInGrid() {
		String[] arrayOfStrings = new String[wordGrid.length];
		for (int i = 0; i < wordGrid.length; i++) {
			String stringFromCharacters = "";
			for (int k = 0; k < wordGrid[i].length; k++) {
				stringFromCharacters += wordGrid[i][k];
			}
			arrayOfStrings[i] = stringFromCharacters;
		}
		return arrayOfStrings;
	}

	private String[] makeArrayOfVerticalStringsInGrid() {
		String[] arrayOfStrings = new String[wordGrid.length];
		for (int i = 0; i < wordGrid.length; i++) {
			String stringFromCharacters = "";
			for (int k = 0; k < wordGrid[i].length; k++) {
				stringFromCharacters += wordGrid[k][i];
			}
			arrayOfStrings[i] = stringFromCharacters;
		}
		return arrayOfStrings;
	}

	private String[] makeArrayOfDiagonalDescendingStrings() {
		String[] diagonalArray = new String[wordGrid.length * 2 - 1];
		int gridLength = wordGrid.length - 1;
		//builds bottom left of diagonal strings
		for (int i = 0; i <= gridLength; i++) {
			String string = "";
			int counter = gridLength;
			for (int k = 0; k <= i; k++) {
				string += wordGrid[counter - i][k];
				counter++;
			}
			diagonalArray[i] = string;
		}
		//builds top-right diagonal strings
		for (int x = 0; x < gridLength; x++) {
			String string = "";
			int counter = 0;
			for (int y = 1; y <= (gridLength - x); y++) {
				string += wordGrid[counter][x + y];
				counter++;
			}
			diagonalArray[gridLength + x + 1] = string;
		}
		return diagonalArray;
	}

	private String[] makeArrayOfDiagonalAscendingStrings() {
		String[] diagonalArray = new String[wordGrid.length * 2 - 1];
		int gridLength = wordGrid.length - 1;
		for (int y = 0; y <= gridLength; y++) {
			String string = "";
			int counter = 0;
			for (int x = 0; x <= y; x++) {
				string += wordGrid[y - counter][x];
				counter++;
			}
			diagonalArray[y] = string;
		}
		
		//builds second half of diagonal array
		for (int y = 0; y < gridLength; y++) {
			String string = "";
			int counter = 9;
			for (int x = 1; x <= (gridLength - y); x++) {
				string += wordGrid[counter][x + y];
				counter--;
			}
			diagonalArray[gridLength + y + 1] = string;
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
	
//	public String stringThatContainsWordHorizontally(String searchWord) {
//		try {
//			return horizontalStrings[presentInWhichLineOfGrid(horizontalStrings, searchWord)];
//		} catch (NullPointerException e) {
//			return null;
//		}
//	}
//	
//	public String stringThatContainsWordHorizontalAndBackwards(String searchWord) {
//		return reverseStringLetters(horizontalStrings[presentInWhichLineOfGrid(horizontalStrings, searchWord)]);
//	}
//	
//	public String stringThatContainsWordDiagonalDescending(String searchWord) {
//		try {
//			return diagonalDescendingStrings[presentInWhichLineOfGrid(diagonalDescendingStrings, searchWord)];
//		} catch (NullPointerException e) {
//			return null;
//		}
//	}
//	
//	public String stringThatContainsWordDiagonalDescendingBackward(String searchWord) {
//		try {
//			return reverseStringLetters(diagonalDescendingStrings[presentInWhichLineOfGrid(diagonalDescendingStrings, searchWord)]);
//		} catch (NullPointerException e) {
//			return null;
//		}
//	}

	public Boolean isPresentInThisArray(String[] array, String searchWord) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].contains(searchWord)) {
				return true;
			}
		}
		return false;
	}

	public String reverseStringLetters(String string) {
		String reversed = "";
		for (int i = string.length()-1 ; i >= 0 ; i--) {
			reversed += string.charAt(i);
		}
		return reversed;
	}

	public String returnLetterIndices(String searchWord) {
		if (isPresentInThisArray(horizontalStrings, searchWord)) {
			return indicesForHorizontal(searchWord);
		} else if (isPresentInThisArray(horizontalStrings, reverseStringLetters(searchWord))){
			return indicesForWordsHorizontalBackwards(searchWord);
		} else if (isPresentInThisArray(verticalStrings, searchWord)){
			return indicesForVertical(searchWord);
		} else if (isPresentInThisArray(verticalStrings, reverseStringLetters(searchWord))) {
			return indicesForVerticalAndBackwards(searchWord);
		} else if (isPresentInThisArray(diagonalDescendingStrings, searchWord)) {
			return indicesForDiagonalDescending(searchWord);
		} else if (isPresentInThisArray(diagonalDescendingStrings, reverseStringLetters(searchWord))) {
			return indicesForDiagonalDescendingBackwards(searchWord);
		} else if (isPresentInThisArray(diagonalAscendingStrings, searchWord)) {
			return indicesForDiagonalAscending(searchWord);
		} else if (isPresentInThisArray(diagonalAscendingStrings, reverseStringLetters(searchWord))) {
			return indicesForDiagonalAscendingBackwards(searchWord);
		} else {
			return null;
		}
	}

	private String indicesForHorizontal(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGrid(horizontalStrings, searchWord);
		Integer startLocation = horizontalStrings[lineWithWord].indexOf(searchWord);
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
		Integer yLocation = presentInWhichLineOfGrid(horizontalStrings, searchWord);
		Integer xLocation = horizontalStrings[yLocation].indexOf(reverseStringLetters(searchWord));
//		String string = horizontalStrings[yLocation];
		xLocation += searchWord.length() - 1;
		String letterIndices = "(" + xLocation + "," + yLocation + "),(";
		for (int i = 1; i <= (searchWord.length() - 1); i++) {
			if (i != searchWord.length() - 1) {
				letterIndices += (xLocation - i) + "," + yLocation +"),(";
			} else {
				letterIndices += (xLocation - i) + "," + yLocation + ")";
			}
		}
		return letterIndices;
	}

	private String indicesForVertical(String searchWord) {
		Integer lineWithWord = presentInWhichLineOfGrid(verticalStrings, searchWord);
		String string = verticalStrings[lineWithWord];
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
		Integer arrayIndexOfWord = presentInWhichLineOfGrid(verticalStrings, searchWord);
		String string = reverseStringLetters(verticalStrings[arrayIndexOfWord]);
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
		Integer arrayIndexOfWord = presentInWhichLineOfGrid(diagonalDescendingStrings, searchWord);
		int xLocation, yLocation;
		if (arrayIndexOfWord >= wordGrid.length) {
			yLocation = diagonalDescendingStrings[arrayIndexOfWord].indexOf(searchWord);
			xLocation = arrayIndexOfWord - wordGrid.length + 1;
		} else {
			xLocation = diagonalDescendingStrings[arrayIndexOfWord].indexOf(searchWord);
			yLocation = wordGrid.length - arrayIndexOfWord;
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
		Integer arrayIndexOfWord = presentInWhichLineOfGrid(diagonalDescendingStrings, searchWord);
		int xLocation,yLocation;
		if (arrayIndexOfWord >= wordGrid.length) {
			String reverseString = reverseStringLetters(diagonalDescendingStrings[arrayIndexOfWord]);
			yLocation = reverseString.length() - reverseString.indexOf(searchWord) - 1;
			xLocation = arrayIndexOfWord - wordGrid.length + yLocation + 1; 
		} else {
			String reverseString = reverseStringLetters(diagonalDescendingStrings[arrayIndexOfWord]);
			xLocation = reverseString.length() - reverseString.indexOf(searchWord) - 1;
			yLocation = wordGrid.length - arrayIndexOfWord + xLocation - 1; 
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

	private String indicesForDiagonalAscending(String searchWord) {
		Integer arrayIndexOfWord = presentInWhichLineOfGrid(diagonalAscendingStrings, searchWord);
		Integer index = diagonalAscendingStrings[arrayIndexOfWord].indexOf(searchWord);
		int xLocation, yLocation;
		if (arrayIndexOfWord >= wordGrid.length) {
			yLocation = wordGrid.length - index - 1;
			xLocation = arrayIndexOfWord - yLocation;
		} else {
			yLocation = arrayIndexOfWord - 1;
			xLocation = index;
		}
		String indices = "(" + xLocation + "," + yLocation + "),(";
		for (int i = 1; i < searchWord.length() - 1; i++) {
			xLocation++;
			yLocation--;
			indices += xLocation + "," + yLocation + "),(";
		}
		indices += (xLocation + 1) + "," + (yLocation - 1) + ")";
		return indices;
	}

	private String indicesForDiagonalAscendingBackwards(String searchWord) {
		Integer arrayIndexOfWord = presentInWhichLineOfGrid(diagonalAscendingStrings, searchWord);
		Integer index = reverseStringLetters(diagonalAscendingStrings[arrayIndexOfWord]).indexOf(searchWord);
		int xLocation, yLocation;
		if (arrayIndexOfWord >= wordGrid.length) {
			xLocation = wordGrid.length - index - 1;
			yLocation = arrayIndexOfWord - xLocation;
		} else {
			xLocation = arrayIndexOfWord - 1;
			yLocation = index;
		}
		String indices = "(" + xLocation + "," + yLocation + "),(";
		for (int i = 1; i < searchWord.length() - 1; i++) {
			xLocation--;
			yLocation++;
			indices += xLocation + "," + yLocation + "),(";
		}
		indices += (xLocation - 1) + "," + (yLocation + 1) + ")";
		return indices;
	}









}
