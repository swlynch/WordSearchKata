package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	@Test
	public void shouldReturnAValueOf0ForIndexOfWord() {
		WordGrid grid = new WordGrid(); 
		Assert.assertEquals("Should return the index 0", 0, grid.find("WORD"));
	}
	
	@Test
	public void shouldReturnAValueOf1ForIndexOfOr() {
		WordGrid grid = new WordGrid();
		Assert.assertEquals("Should return the index 1", 1, grid.find("OR"));
	}
	
	@Test
	public void shouldReturnTrueIfSearchWordIsPresentInLine() {
		WordGrid grid = new WordGrid();
		Assert.assertTrue("Should return 'true' that word is present in line", grid.isInLine("WORD"));
	}
	
	@Test
	public void shoudlReturnFalseIfWordMustardIsPresentInLine() {
		WordGrid grid = new WordGrid();
		Assert.assertFalse("Should return 'false' that word 'MUSTARD' is in line", grid.isInLine("MUSTARD"));
	}
}
