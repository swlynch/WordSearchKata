package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	@Test
	public void returnsIndexOfFirstLetterInSingleLine() {
		WordGrid grid = new WordGrid(); 
		Assert.assertEquals("Should return the index 0", 0, grid.find("WORD"));
	}
}
