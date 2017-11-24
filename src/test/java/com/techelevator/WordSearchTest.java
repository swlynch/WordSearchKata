package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	private WordGrid grid;
	private char[][] array;
	private String[] arrayOfHorizontalStrings;
//	private String[] arrayOfVerticalStrings;
	private String stringOfCharacters;
	
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
//		arrayOfVerticalStrings = grid.getArrayOfVerticalStrings();

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
		Assert.assertTrue("Should return 'true' that word is present in line", grid.presentInGridHorizontally("ONE") || grid.presentInGridBackwards("ONE"));
	}
	
	@Test
	public void shouldReturnFalseWhenWordMustardIsPresentIsNotLine() {
		Assert.assertFalse("Should return 'false' that word 'MUSTARD' is in line", grid.presentInGridHorizontally("MUSTARD") && grid.presentInLineBackwards("MUSTARD"));
	}
//	
//	@Test
//	public void shouldReturnTrueIfWordIsPresentInBackwardsOrder() {
//		Assert.assertTrue("Should return true", grid.isInLineHorizontallyOrInReverse("CANDY"));
//	}
//	
//	@Test
//	public void shoudlReturnTrueIfWordANDIsPresentInBackwardsOrder() {
//		Assert.assertTrue("Should return true", grid.isInLineHorizontallyOrInReverse("AND"));
//	}
//	
//	@Test
//	public void shouldCorrectlyCreateStringFromArrayOfCharacter() {
//		char[] array = {'W','O','R','D'};
//		Assert.assertEquals("Should return true when String matches character sequence in array", "WORD", grid.convertArrayOfOfArraysCharactersToStrings(array));
//	}
//	
//	@Test
//	public void returnTrueWhenWordIsPresentInAnArray() {
//		char[] array = {'W','O','R','D'};
//		String arrayToString = grid.convertArrayOfOfArraysCharactersToStrings(array);
//		Assert.assertTrue("Should return true when 'word' is searched for in an array with the same letters", grid.isInLineHorizontallyOrInReverse(arrayToString));
//	}
//	
//	@Test
//	public void returnFalseWhenWordIsNotPresentInAnArray() {
//		Assert.assertFalse("Should return false when 'CANDY' is searched for in an array that does not contain those letters", grid.presentInGridHorizontally(searchWord)("MUSTARD"));
//	}
	
	
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
		Assert.assertEquals("Should return (9,7),(9,6),(9,5)", "(9,7),(9,6),(9,5)", grid.returnLetterIndices("WED"));
	}
	
//	@Test
//	public void shouldReturnTrueIfWordWOOIsPresentVertically() {
//		Assert.assertTrue("Should return true that word 'WOO' is present vertically", grid.presentInGridVertically("WOO"));
//	}
//	
//	@Test
//	public void shoudlReturnFalseIfWordMADAMisPresentVertically() {
//		Assert.assertTrue("Should return false that word 'MADAM' is present vertically", grid.presentInGridVertically("MADAM"));
//	}
	
	
}
