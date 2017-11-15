package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	private WordGrid grid;
	private char[] array;
	
	@Before
	public void setup() {
		grid = new WordGrid();
		char[] array = {'W','O','R','D','Y','D','N','A','C'};
		grid.setLine(array);
	}
	
	@Test
	public void shouldReturnAValueOf0ForIndexOfWord() {
		Assert.assertEquals("Should return the index 0", 0, grid.returnIndex("WORD"));
	}
	
	@Test
	public void shouldReturnAValueOf1ForIndexOfOr() {
		Assert.assertEquals("Should return the index 1", 1, grid.returnIndex("OR"));
	}
	
	@Test
	public void shouldReturnTrueIfSearchWordIsPresentInLine() {
		Assert.assertTrue("Should return 'true' that word is present in line", grid.isInLine("WORD"));
	}
	
	@Test
	public void shouldReturnFalseWhenWordMustardIsPresentIsNotLine() {
		Assert.assertFalse("Should return 'false' that word 'MUSTARD' is in line", grid.isInLine("MUSTARD"));
	}
	
	@Test
	public void shouldReturnTrueIfWordIsPresentInBackwardsOrder() {
		Assert.assertTrue("Should return true", grid.isInLine("CANDY"));
	}
	
	@Test
	public void shouldCorrectlyCreateStringFromArrayOfCharacter() {
		char[] array = {'W','O','R','D'};
		Assert.assertEquals("Should return true when String matches character sequence in array", "WORD", grid.convertArrayOfCharactersToString(array));
	}
	
	@Test
	public void returnTrueWhenWordIsPresentInAnArray() {
		char[] array = {'W','O','R','D'};
		String arrayToString = grid.convertArrayOfCharactersToString(array);
		Assert.assertTrue("Should return true when 'word' is searched for in an array with the same letters", grid.isInLine(arrayToString));
	}
	
	@Test
	public void returnFalseWhenWordIsNotPresentInAnArray() {
		Assert.assertFalse("Should return false when 'CANDY' is searched for in an array that does not contain those letters", grid.isInLine("MUSTARD"));
	}
	
	@Test
	public void returnStartAndEndIndexForSearchWord() {
		Assert.assertEquals("Should return (0,3)", "(0,3)", grid.returnSearchWordLocations("WORD"));
	}
	
	@Test
	public void returnLocationOfEachLetterInHorizontalLine() {
		Assert.assertEquals("Should return (0,0), (0,1), (0,2), (0,3)", "(0,0), (0,1), (0,2), (0,3)", grid.returnLetterIndices("WORD"));
	}
}
