package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	private WordGrid grid;
	
	@Before
	public void setup() {
		grid = new WordGrid();
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
	public void shoudlReturnFalseIfWordMustardIsPresentInLine() {
		Assert.assertFalse("Should return 'false' that word 'MUSTARD' is in line", grid.isInLine("MUSTARD"));
	}
}
