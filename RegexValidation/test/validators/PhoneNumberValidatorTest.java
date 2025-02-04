import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class PhoneNumberValidatorTest {
    @Test
    public void testValidPhoneNumberBasic() { 
        assertTrue(Main.validatePhoneNumber("678-707-9460")); // Standard format
    }

    @Test
    public void testValidPhoneNumberWithDots() { 
        assertTrue(Main.validatePhoneNumber("312.456.7890")); // Dots as separators
    }

    @Test
    public void testValidPhoneNumberWithSpaces() { 
        assertTrue(Main.validatePhoneNumber("415 456 7890")); // Spaces as separators
    }

    @Test
    public void testValidPhoneNumberWithParentheses() { 
        assertTrue(Main.validatePhoneNumber("(305) 456-7890")); // Parentheses around area code
    }

    @Test
    public void testValidPhoneNumberWithCountryCode() { 
        assertTrue(Main.validatePhoneNumber("+1 646-456-7890")); // Country code with space
    }

    @Test
    public void testValidPhoneNumberWithCountryCodeAndDots() { 
        assertTrue(Main.validatePhoneNumber("+1.818.456.7890")); // Country code with dots
    }

    @Test
    public void testValidPhoneNumberWithoutSeparators() { 
        assertTrue(Main.validatePhoneNumber("7024567890")); // No separators
    }

    @Test
    public void testValidPhoneNumberWithDifferentFormatting() { 
        assertTrue(Main.validatePhoneNumber("+1 (617) 456-7890")); // Mixed formatting with country code
    }


    // ❌ 8 Invalid Cases (Including Official Area Code Restrictions)
    @Test
    public void testInvalidPhoneNumberTooShort() { 
        assertFalse(Main.validatePhoneNumber("123-456-78")); // Not enough digits
    }

    @Test
    public void testInvalidPhoneNumberTooLong() { 
        assertFalse(Main.validatePhoneNumber("123-456-78901")); // Too many digits
    }

    @Test
    public void testInvalidPhoneNumberLetters() { 
        assertFalse(Main.validatePhoneNumber("212-456-ABCD")); // Letters in number
    }

    @Test
    public void testInvalidPhoneNumberSpecialCharacters() { 
        assertFalse(Main.validatePhoneNumber("212@456#7890")); // Special characters not allowed
    }

    @Test
    public void testInvalidPhoneNumberIncorrectCountryCode() { 
        assertFalse(Main.validatePhoneNumber("+99 212-456-7890")); // Invalid country code
    }

    @Test
    public void testInvalidPhoneNumberAreaCodeStartingWith0or1() { 
        assertFalse(Main.validatePhoneNumber("(012) 456-7890")); // Area code cannot start with 0
        assertFalse(Main.validatePhoneNumber("(112) 456-7890")); // Area code cannot start with 1
    }

    @Test
    public void testInvalidPhoneNumberExchangeCodeStartingWith0or1() { 
        assertFalse(Main.validatePhoneNumber("212-012-7890")); // Exchange code cannot start with 0
        assertFalse(Main.validatePhoneNumber("212-112-7890")); // Exchange code cannot start with 1
    }
    @Test
    public void testInvalidPhoneNumberWithUnofficialAreaCodeLow() { 
        assertFalse(Main.validatePhoneNumber("099-456-7890")); // Not a real area code
    }

    @Test
    public void testInvalidPhoneNumberWithUnofficialAreaCodeHigh() { 
        assertFalse(Main.validatePhoneNumber("999-456-7890")); // Not a real area code
    }

    @Test
    public void testInvalidPhoneNumberWith911() { 
        assertFalse(Main.validatePhoneNumber("911-456-7890")); // 911 is not a valid area code
    }

    @Test
    public void testInvalidPhoneNumberWith555() { 
        assertFalse(Main.validatePhoneNumber("555-456-7890")); // 555 is not a valid area code
    }
}

    