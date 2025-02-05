import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OddWordValidationTest {

    @Test
    public void testValidOddWordShortest() { 
        assertTrue(Main.validateOddWord("ion")); // 3 total letters (odd)
    }

    @Test
    public void testValidOddWordFiveLetters() { 
        assertTrue(Main.validateOddWord("union")); // 5 total letters (odd)
    }

    @Test
    public void testValidOddWordSevenLetters() { 
        assertTrue(Main.validateOddWord("invention")); // 7 total letters (odd)
    }

    @Test
    public void testValidOddWordMixedCase() { 
        assertTrue(Main.validateOddWord("Suppression")); // Case insensitive check
    }
    @Test
    public void testValidOddWordThirteenLetters() { 
        assertTrue(Main.validateOddWord("participation")); // 13 total letters (odd)
    }
    
    @Test
    public void testValidOddWordNineteenLetters() { 
        assertTrue(Main.validateOddWord("conceptualization")); // 19 total letters (odd)
    }
    
    @Test
    public void testValidOddWordTwentyThreeLetters() { 
        assertTrue(Main.validateOddWord("Overintellectualization")); // 22 total letters (odd)
    }

    @Test
    public void testValidOddWordWithCapitalization() { 
        assertTrue(Main.validateOddWord("Commercialization")); // Should be case insensitive
    }

    @Test
    public void testInvalidWordWrongEnding() { 
        assertFalse(Main.validateOddWord("motivation")); // not correct length 
    }

    @Test
    public void testInvalidWordWithNumbers() { 
        assertFalse(Main.validateOddWord("m0tion")); // Contains a number
    }

    @Test
    public void testInvalidWordWithSpecialCharacters() { 
        assertFalse(Main.validateOddWord("moti@nion")); // Contains special character
    }

    @Test
    public void testInvalidWordWithSpaces() { 
        assertFalse(Main.validateOddWord(" expulsion ")); // Leading/trailing spaces
    }

    @Test
    public void testInvalidWordWithIncorrectPattern() { 
        assertFalse(Main.validateOddWord("bahion")); // Doesn't follow the regex pattern
    }

    @Test
    public void testInvalidWordEvenLengthFourLetters() { 
        assertFalse(Main.validateOddWord("xion")); // "xion" has 4 letters (even)
    }

    @Test
    public void testInvalidWordEvenLengthFourteenLetters() { 
        assertFalse(Main.validateOddWord("disintegration")); // 14 total letters (even)
    }
}