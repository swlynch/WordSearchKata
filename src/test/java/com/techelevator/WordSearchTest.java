package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	private WordGrid grid;
	private char[][] array;
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
						{	'Y','N','T','U','D','E','W','G','B','G'}};
		grid.setGrid(array);
	}
	
	@Test
	public void shouldReturnAValueOf0ForIndexOfWord() {
		Assert.assertEquals("Should return the index 0", 0, stringOfCharacters.indexOf("WORD"));
	}
	
	@Test
	public void shouldReturnAValueOf1ForIndexOfOr() {
		Assert.assertEquals("Should return the index 1", 1, stringOfCharacters.indexOf("OR"));
	}
	
	@Test
	public void shouldReturnTrueIfSearchWordIsPresentInLine() {
		Assert.assertTrue("Should return 'true' that word is present in line", grid.isInLineHorizontallyOrInReverse("WORD"));
	}
	
	@Test
	public void shouldReturnFalseWhenWordMustardIsPresentIsNotLine() {
		Assert.assertFalse("Should return 'false' that word 'MUSTARD' is in line", grid.isInLineHorizontallyOrInReverse("MUSTARD"));
	}
	
	@Test
	public void shouldReturnTrueIfWordIsPresentInBackwardsOrder() {
		Assert.assertTrue("Should return true", grid.isInLineHorizontallyOrInReverse("CANDY"));
	}
	
	@Test
	public void shoudlReturnTrueIfWordANDIsPresentInBackwardsOrder() {
		Assert.assertTrue("Should return true", grid.isInLineHorizontallyOrInReverse("AND"));
	}
	
	@Test
	public void shouldCorrectlyCreateStringFromArrayOfCharacter() {
		char[] array = {'W','O','R','D'};
		Assert.assertEquals("Should return true when String matches character sequence in array", "WORD", grid.convertArrayOfOfArraysCharactersToStrings(array));
	}
	
	@Test
	public void returnTrueWhenWordIsPresentInAnArray() {
		char[] array = {'W','O','R','D'};
		String arrayToString = grid.convertArrayOfOfArraysCharactersToStrings(array);
		Assert.assertTrue("Should return true when 'word' is searched for in an array with the same letters", grid.isInLineHorizontallyOrInReverse(arrayToString));
	}
	
	@Test
	public void returnFalseWhenWordIsNotPresentInAnArray() {
		Assert.assertFalse("Should return false when 'CANDY' is searched for in an array that does not contain those letters", grid.isInLineHorizontallyOrInReverse("MUSTARD"));
	}
	
	@Test
	public void returnStartAndEndIndexForSearchWord() {
		Assert.assertEquals("Should return (0,3)", "(0,3)", grid.returnSearchWordLocations("WORD"));
	}
	
	@Test
	public void returnLocationOfEachLetterInHorizontalLine() {
		Assert.assertEquals("Should return (0,0),(1,0),(2,0),(3,0)", "(0,0),(1,0),(2,0),(3,0)", grid.returnLetterIndices("WORD"));
	}
	
	@Test
	public void returnLocationOfEachLetterPresentInReverse() {
		Assert.assertEquals("Should return (8,0),(7,0),(6,0),(5,0),(4,0)", "(8,0),(7,0),(6,0),(5,0),(4,0)", grid.returnLetterIndices("CANDY"));
	}
	
	@Test
	public void returnLocationOfEachLetterPresentInTheWordANDInReverse() {
		Assert.assertEquals("Should return (7,0),(6,0),(5,0)", "(7,0),(6,0),(5,0)", grid.returnLetterIndices("AND"));
	}
	
	@Test
	public void returnLocationOfEachLetterPresentInTheWordROWInReverse() {
		Assert.assertEquals("Should return (2,0),(1,0),(0,0)", "(2,0),(1,0),(0,0)", grid.returnLetterIndices("ROW"));
	}
	
	
}
