import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NameValidatorTest {
    @Test
    public void testValidNameWithMiddleInitial() { 
        assertTrue(Main.validateName("Mabota, Lwazi, M")); // Standard format with MI
    }

    @Test
    public void testValidNameWithoutMiddleInitial() { 
        assertTrue(Main.validateName("Doe, Jane")); // No middle initial
    }

    @Test
    public void testValidNameWithHyphenatedLastName() { 
        assertTrue(Main.validateName("Smith-Jones, Mary, A")); // Hyphen in last name
    }

    @Test
    public void testValidNameWithApostrophe() { 
        assertTrue(Main.validateName("O'Connor, Patrick, T")); // Apostrophe in last name
    }

    @Test
    public void testValidNameWithSpaceInLastName() { 
        assertTrue(Main.validateName("Van Buren, Martin, V")); // Last name with space
    }

    @Test
    public void testValidNameWithSingleLetterFirstName() { 
        assertTrue(Main.validateName("Lee, B, Z")); // Single letter first name
    }

    @Test
    public void testValidNameWithMultipleSpaces() { 
        assertTrue(Main.validateName("Jackson,  Michael,   J")); // Extra spaces
    }

    @Test
    public void testValidNameWithLowercaseLastName() { 
        assertTrue(Main.validateName("McDonald, Ronald, D")); // Mixed uppercase/lowercase
    }
    @Test
    public void testInvalidNameMissingComma() { 
        assertFalse(Main.validateName("Smith John L")); // No comma
    }

    @Test
    public void testInvalidNameWithNumbersInLastName() { 
    assertFalse(Main.validateName("Sm1th, John, L")); // Last name contains a number
    }

    @Test
    public void testInvalidNameNoFirstName() { 
        assertFalse(Main.validateName("Doe,")); // No first name
    }

    @Test
    public void testInvalidNameDoubleComma() { 
        assertFalse(Main.validateName("Smith,, John, L")); // Extra comma
    }

    @Test
    public void testInvalidNameNumbersInName() { 
        assertFalse(Main.validateName("Smith123, John, L")); // Numbers in last name
    }

    @Test
    public void testInvalidNameMiddleInitialTooLong() { 
        assertFalse(Main.validateName("Smith, John, ABC")); // More than one middle initial
    }

    @Test
    public void testInvalidNameSpecialCharacters() { 
        assertFalse(Main.validateName("Smith@, John, L")); // Special characters
    }

    @Test
    public void testInvalidNameTrailingSpace() { 
        assertFalse(Main.validateName("Smith, John, L ")); // Trailing space
    }
}