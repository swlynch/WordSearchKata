package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	private WordGrid grid;
	private String[] arrayOfHorizontalStrings;
	private String[] arrayOfVerticalStrings;
	private String stringOfCharacters;
	private String[] diagonalArray;
	
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
						{'D','D','E','Z','J','Q','O','G','L','O'},
						{'Y','N','T','U','D','E','W','G','B','G'}};
		grid.setGrid(array);
		arrayOfHorizontalStrings = grid.getArrayOfHorizontalStrings();
		arrayOfVerticalStrings = grid.getArrayOfVerticalStrings();
		diagonalArray = grid.getArrayOfDiagonalDescendingStrings();

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
		Assert.assertNull("Should return null", grid.presentInWhichLineOfGridHorizontally("MUSTARD"));
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
	public void shoulReturnFalseThatWordLIGHTBEAMSIsPresentVertically() {
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
	public void shoudlReturnFirstElementInDiagonalArrayAsY() {
		Assert.assertEquals("Should return the char Y as first element in array", "Y", diagonalArray[0]);
	}
	
	@Test
	public void shouldReturn9thAElementinDiagonalArrayAsW() {
		Assert.assertEquals("Should return W as 9th element", "W", diagonalArray[9]);
	}
	
	
	@Test
	public void shouldReturnFalseThatWordROWIsPresentDiagonallyDescending() {
		Assert.assertTrue("Should return true that ROW is present diagonally and descending", grid.isPresentDiagonallyDescending("ROW"));
	}

}
