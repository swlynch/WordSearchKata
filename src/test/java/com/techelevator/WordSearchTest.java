package com.techelevator;

import org.junit.*;

public class WordSearchTest {

	private WordGrid grid;
	private char[][] array;
	private String[] arrayOfStrings;
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
		arrayOfStrings = grid.getArrayOfStrings();
	}
	
	@Test
	public void shouldReturnAValueOf1ForIndexOfWORD() {
		stringOfCharacters = grid.stringThatContainsWord("CACTUS");
		Assert.assertEquals("Should return the index 1", 1, stringOfCharacters.indexOf("CACTUS"));
	}
	
	@Test
	public void shouldReturnAValueOf4ForIndexOfDEW() {
		stringOfCharacters = grid.stringThatContainsWord("DEW");
		Assert.assertEquals("Should return the index 4", 4, stringOfCharacters.indexOf("DEW"));
	}
	
	@Test
	public void shouldReturnNotNullIfSearchWORDIsPresentInLine() {
		Assert.assertNotNull("Should return a number that WORD is present in grid", grid.presentInWhichLineOfGridHorizontally("CACTUS"));
	}
	
	@Test
	public void shouldReturnNullWhenSearchingIfWordMUSTARDIsPresentIsNotLine() {
		Assert.assertNull("Should assert 'null' that word 'MUSTARD' is in grid", grid.presentInWhichLineOfGridHorizontally("MUSTARD"));
	}
	
	@Test
	public void shouldReturnTrueIfWEDIsPresentInBackwardsOrder() {
		Assert.assertTrue("Should return true", grid.presentInGridBackwards("WED"));
	}
	
	@Test
	public void shoudlReturnTrueIfWordZEDIsPresentInBackwardsOrder() {
		Assert.assertTrue("Should return true", grid.presentInGridBackwards("ZED"));
	}
	
	@Test
	public void returnLocationOfEachLetterOfFALAFELInHorizontalLine() {
		Assert.assertEquals("Should return (1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0)", "(1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0)", grid.returnLetterIndices("FALAFEL"));
	}
	
	@Test
	public void returnLocationOfEachLetterOfWEDInReverse() {
		Assert.assertEquals("Should return (6,9),(5,9),(4,9)", "(6,9),(5,9),(4,9)", grid.returnLetterIndices("WED"));
	}
	
	@Test
	public void returnLocationOfEachLetterPresentInTheWordBANInReverse() {
		Assert.assertEquals("Should return (7,1),(6,1),(5,1)", "(7,1),(6,1),(5,1)", grid.returnLetterIndices("BAN"));
	}
	
	@Test
	public void returnLocationOfEachLetterPresentInTheWordCACTUS() {
		Assert.assertEquals("Should return (1,7),(2,7),(3,7),(4,7),(5,7),(6,7)", "(1,7),(2,7),(3,7),(4,7),(5,7),(6,7)", grid.returnLetterIndices("CACTUS"));
	}
	
	@Test
	public void shouldReturnTrueIfWordWOOIsPresentVertically() {
		Assert.assertTrue("Should return true that word 'WOO' is present vertically", grid.isPresentInGridVertically("WOO"));
	}
	
	@Test
	public void shoudlReturnFalseIfWordMADAMisPresentVertically() {
		Assert.assertTrue("Should return false that word 'MADAM' is present vertically", grid.isPresentInGridVertically("MADAM"));
	}
	
	
}
