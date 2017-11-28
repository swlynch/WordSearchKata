package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	private WordGrid grid;
	private String[] arrayOfHorizontalStrings;
	private String[] arrayOfVerticalStrings;
	private String stringOfCharacters;
	private String[] diagonalArray;
	private String[] diagonalAscendingArray;
	
	@Before
	public void setup() {
		grid = new WordGrid();
		char[][] array = {{'W','F','A','L','A','F','E','L','B','F'},
						{'D','Q','V','L','A','N','A','B','K','X'},
						{'C','V','A','E','J','L','O','Z','A','T'},
						{'W','G','B','L','A','Z','M','Y','J','C'},
						{'O','F','L','D','V','Y','D','D','P','E'},
						{'O','N','E','N','N','N','K','R','D','M'},
						{'X','D','F','A','A','E','G','Y','O','P'},
						{'O','C','A','C','T','U','S','I','A','W'},
						{'D','D','E','Z','J','Q','O','G','K','O'},
						{'Y','N','T','U','D','E','W','G','B','G'}};
		grid.setGrid(array);
		arrayOfHorizontalStrings = grid.getArrayOfHorizontalStrings();
		arrayOfVerticalStrings = grid.getArrayOfVerticalStrings();
		diagonalArray = grid.getArrayOfDiagonalDescendingStrings();
		diagonalAscendingArray = grid.getArrayOfDiagonalAscendingStrings();
	}
	
	@Test
	public void arrayOfHorizontalStringsShouldNotBeNull() {
		Assert.assertNotNull("Should not be null", arrayOfHorizontalStrings);
	}
	
	@Test
	public void stringContainingWordCACTUSShouldNotBeNull() {
		stringOfCharacters = grid.stringThatContainsWordHorizontally("CACTUS");
		Assert.assertNotNull("Should not be null", stringOfCharacters);
	}
	
	@Test
	public void shouldReturnAValueOf1ForIndexOfCACTUS() {
		stringOfCharacters = grid.stringThatContainsWordHorizontally("CACTUS");
		Assert.assertEquals("Should return the index 1", 1, stringOfCharacters.indexOf("CACTUS"));
	}
	
	@Test
	public void shouldReturnAValueOf4ForIndexOfDEW() {
		stringOfCharacters = grid.stringThatContainsWordHorizontally("DEW");
		Assert.assertEquals("Should return the index 4", 4, stringOfCharacters.indexOf("DEW"));
	}

	@Test
	public void shouldReturnAValueOf1ForIndexOfFALAFEL() {
		stringOfCharacters = grid.stringThatContainsWordHorizontally("FALAFEL");
		Assert.assertEquals("Should return the index 1", 1, stringOfCharacters.indexOf("FALAFEL"));
	}

	@Test
	public void shouldReturnTrueIfONEIsPresentInLine() {
		Assert.assertTrue("Should return 'true' that word is present in line", grid.isPresentHorizontally("ONE") || grid.isPresentHorizontalAndBackwards("ONE"));
	}
	
	@Test
	public void shouldReturnFalseWhenWordMUSTARDIsPresentIsNotLine() {
		Assert.assertNull("Should return null", grid.presentInWhichLineOfGrid(arrayOfHorizontalStrings, "MUSTARD"));
	}
	
	@Test
	public void shouldReturnTrueIfBANIsPresentInBackwardsOrder() {
		Assert.assertTrue("Should return true", grid.isPresentHorizontalAndBackwards("BAN"));
	}
	
	@Test
	public void shoudlReturnTrueIfWordZEDIsPresentInBackwardsOrder() {
		Assert.assertTrue("Should return true", grid.isPresentHorizontalAndBackwards("ZED"));
	}
	
	@Test
	public void returnLocationOfEachLetterOfCACTUSInHorizontalLine() {
		Assert.assertEquals("Should return (1,7),(2,7),(3,7),(4,7),(5,7),(6,7)", "(1,7),(2,7),(3,7),(4,7),(5,7),(6,7)", grid.returnLetterIndices("CACTUS"));
	}
	
	@Test
	public void returnLocationOfEachLetterofFALAFEL() {
		Assert.assertEquals("Should return (1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0)", "(1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0)", grid.returnLetterIndices("FALAFEL"));
	}
	
	@Test
	public void returnLocationOfEachLetterPresentInTheWordWEDInReverse() {
		Assert.assertEquals("Should return (6,9),(5,9),(4,9)", "(6,9),(5,9),(4,9)", grid.returnLetterIndices("WED"));
	}
	
	@Test
	public void returnLocationOfEachLetterOfBackwardsStringPDDY() {
		Assert.assertEquals("Should return (8,4),(7,4),(6,4),(5,4)", "(8,4),(7,4),(6,4),(5,4)", grid.returnLetterIndices("PDDY"));
	}
	
	@Test
	public void shouldReturnTrueThatWordWOOIsPresentVertically() {
		Assert.assertTrue("Should return true that word WOO is present vertically", grid.isPresentVertically("WOO") || grid.isPresentVerticalAndBackwards("WOO"));
	}
	
	@Test
	public void shouldReturnTrueThatWordCANDLEIsPresentVertically() {
		Assert.assertTrue("Should return true that word CANDLE is present vertically", grid.isPresentVertically("CANDLE") || grid.isPresentVerticalAndBackwards("CANDLE"));
	}
	
	@Test
	public void shouldReturnFalseThatWordLIGHTBEAMSIsPresentVertically() {
		Assert.assertFalse("Should return true that word CANDLE is present vertically", grid.isPresentVertically("LIGHTBEAMS") || grid.isPresentVerticalAndBackwards("LIGHTBEAMS"));
	}
	
	@Test
	public void shouldReturnIndicesOfVerticalWordWOO() {
		Assert.assertEquals("Should return (0,3),(0,4),(0,5)", "(0,3),(0,4),(0,5)", grid.returnLetterIndices("WOO"));
	}
	
	@Test
	public void shouldReturnIndicesOfVerticalWordSOW() {
		Assert.assertEquals("Should return (6,7),(6,8),(6,9)", "(6,7),(6,8),(6,9)", grid.returnLetterIndices("SOW"));
	}

	@Test
	public void shouldReturnIndicesOfVerticalAndBackwardsCANDLE() {
		Assert.assertEquals("Should return (3,7),(3,6),(3,5),(3,4),(3,3),(3,2)", "(3,7),(3,6),(3,5),(3,4),(3,3),(3,2)", grid.returnLetterIndices("CANDLE"));
	}
	
	@Test
	public void shouldReturnIndicesOfVerticalAndBackwardsVQF() {
		Assert.assertEquals("Should return (1,2),(1,1),(1,0)", "(1,2),(1,1),(1,0)", grid.returnLetterIndices("VQF"));
	}
	
	@Test
	public void shouldReturnLengthOf19ForDiagonalDescendingArrayOfStrings() {
		Assert.assertEquals("Should return length of 19", 19, diagonalArray.length, 0.01);
	}
	
	@Test
	public void shouldReturnFirstElementInDiagonalArrayAsY() {
		Assert.assertEquals("Should return the char Y as first element in array", "Y", diagonalArray[0]);
	}
	
	@Test
	public void shouldReturn18thElementAsF() {
		Assert.assertEquals("Should return F as 18th element", "F", diagonalArray[18]);
	}
	
	@Test
	public void shouldReturn15thElementasEBAC() {
		Assert.assertEquals("Should return E as 15th element", "EBAC", diagonalArray[15]);
	}
	
	@Test
	public void shouldReturn2ndElementofDiagonalDescendingArrayAsDN() {
		Assert.assertEquals("Should return 2nd element of array as DN", "DN", diagonalArray[1]);
	}
	
	@Test
	public void shouldReturn9thElementOfDiagonalDescendingAsWQALVNGIKG() {
		Assert.assertEquals("Should return 9th element of array as WQALVNGIKG", "WQALVNGIKG", diagonalArray[9]);
	}
	
	@Test
	public void shouldReturn10thElementOfDiagonalDescendingAsFVEAYKYAO() {
		Assert.assertEquals("Should return 9th element of array as FVEAYKYAO", "FVEAYKYAO", diagonalArray[10]);
	}
	
	@Test
	public void shouldReturn17thElementofDiagonalDescendingAsBX() {
		Assert.assertEquals("Should return 17th element as BX", "BX", diagonalArray[17]);
	}
	
	@Test
	public void shouldReturnTrueThatWordROWIsPresentDiagonallyDescending() {
		Assert.assertTrue("Should return true that ROW is present diagonally and descending", grid.isPresentDiagonallyDescending("ROW"));
	}
	
	@Test
	public void shouldReturnTrueThatWORDAppearsDiagonalDescending() {
		Assert.assertTrue("Should assert true that WORD appears in diagonal descending array", grid.isPresentDiagonalDescendingBackwards("WORD"));
	}
	
	@Test
	public void shouldReturnIndexOf11ForWhatDiagonalDesendingStringWORDAppearsIn() {
		Assert.assertEquals("Should return an index 11 for array of diagonal descending array when looking for word WORD", 11, grid.presentInWhichLineOfGrid(diagonalArray, "WORD"), 0.01);
	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordFEATDiagonally() {
		Assert.assertEquals("Should return indices of (1,4),(2,5),(3,6),(4,7)", "(1,4),(2,5),(3,6),(4,7)", grid.returnLetterIndices("FEAT"));
	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordFAZDiagonally() {
		Assert.assertEquals("Should return indices of (5,0),(6,1),(7,2)", "(5,0),(6,1),(7,2)", grid.returnLetterIndices("FAZ"));
	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordANOYDiagonally() {
		Assert.assertEquals("Should return indices of (4,0),(5,1),(6,2),(7,3)", "(4,0),(5,1),(6,2),(7,3)", grid.returnLetterIndices("ANOY"));

	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordWORDDiagonalAndBackwards() {
		Assert.assertEquals("Should return indices of (9,7),(8,6),(7,5),(6,4)", "(9,7),(8,6),(7,5),(6,4)", grid.returnLetterIndices("WORD"));
	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordZADDiagonalAndBackwards() {
		Assert.assertEquals("Should return indices of (3,8),(2,7),(1,6)", "(3,8),(2,7),(1,6)", grid.returnLetterIndices("ZAD"));
	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordSENDDiagonalAndBackwards() {
		Assert.assertEquals("Should return indices of (6,7),(5,6),(4,5),(3,4)", "(6,7),(5,6),(4,5),(3,4)", grid.returnLetterIndices("SEND"));
	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordCABDiagonalBackwards() {
		Assert.assertEquals("Should return indices of (9,3),(8,2),(7,1)", "(9,3),(8,2),(7,1)", grid.returnLetterIndices("CAB"));
	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordQALDiagonal() {
		Assert.assertEquals("Should return indices of (1,1),(2,2),(3,3)", "(1,1),(2,2),(3,3)", grid.returnLetterIndices("QAL"));
	}
	
	@Test
	public void shouldReturnCorrectIndicesForWordLAQDiagonal() {
		Assert.assertEquals("Should return indices of (3,3),(2,2),(1,1)", "(3,3),(2,2),(1,1)", grid.returnLetterIndices("LAQ"));
	}

	@Test
	public void shouldReturnLengthOf19ForDiagonalAscendingArrayOfStrings() {
		Assert.assertEquals("Should return length of 19", 19, diagonalAscendingArray.length, 0.01);
	}
	
	@Test
	public void shouldReturnFirstElementInDiagonalAscendingArrayAsW() {
		Assert.assertEquals("Should return the char W as first element in array", "W", diagonalAscendingArray[0]);
	}
	
	@Test
	public void shouldReturnLastElementInDiagonalArrayAsG() {
		Assert.assertEquals("Should return the char G as first element in array", "G", diagonalAscendingArray[18]);
	}
	
	@Test
	public void shouldReturnSecondElementInDiagonalAscendingArrayAsDF() {
		Assert.assertEquals("Should return the string DF as first element in array", "DF", diagonalAscendingArray[1]);
	}
	
	@Test
	public void shouldReturnTrueThatCANDYAppearsInDiagonalAscendingArray() {
		Assert.assertTrue("Should return true that CANDY appears diagonal ascending", grid.isPresentDiagonalAscending("CANDY"));
	}
	
	@Test
	public void shouldReturnFalseThatPASTAAppearsInDiagonalAscendingArray() {
		Assert.assertFalse("Should return false that PASTA appears diagonal ascending", grid.isPresentDiagonalAscending("PASTA"));
	}
	
	@Test
	public void shouldReturnTrueThatLAGAppearsInDiagonalAscendingArrayBackwards() {
		Assert.assertTrue("Should return true that LAG appears diagonal ascending", grid.isPresentDiagonalAscendingBackward("LAG"));
	}
	
	@Test
	public void shouldReturnFalseThatGLORIAAppearsInDiagonalAscendingArrayBackwards() {
		Assert.assertFalse("Should return false that GLORIA appears diagonal ascending", grid.isPresentDiagonalAscendingBackward("GLORIA"));
	}
}
