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
}
