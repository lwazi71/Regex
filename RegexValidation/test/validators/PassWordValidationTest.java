import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PassWordValidationTest {

    @Test
    public void testValidPasswordMinimumLength() { 
        assertTrue(Main.validatePassword("Abc!123456")); // Exactly 10 characters, meets all conditions
    }

    @Test
    public void testValidPasswordExceedsMinimumLength() { 
        assertTrue(Main.validatePassword("XyZ!45678abc")); // More than 10 characters, still valid
    }

    @Test
    public void testValidPasswordWithMaxConsecutiveLowercase() { 
        assertTrue(Main.validatePassword("Aabc!123DEF")); // 3 consecutive lowercase allowed
    }

    @Test
    public void testValidPasswordWithMixedCases() { 
        assertTrue(Main.validatePassword("Pass1!WordX")); // Proper mix of upper, lower, digit, punctuation
    }

    @Test
    public void testValidPasswordWithSinglePunctuation() { 
        assertTrue(Main.validatePassword("Secure!Pass12")); // Uses exactly one punctuation mark
    }

    @Test
    public void testValidPasswordWithLeadingPunctuation() { 
        assertTrue(Main.validatePassword("!Pass12WordX")); // Punctuation at start
    }

    @Test
    public void testValidPasswordWithTrailingPunctuation() { 
        assertTrue(Main.validatePassword("Pass12WordX!")); // Punctuation at end
    }

    @Test
    public void testValidPasswordWithMultipleDigits() { 
        assertTrue(Main.validatePassword("Strong!9876Abc")); // Extra numbers but still valid
    }


    @Test
    public void testInvalidPasswordTooShort() { 
        assertFalse(Main.validatePassword("Ab1!cde")); // Less than 10 characters
    }

    @Test
    public void testInvalidPasswordMissingUppercase() { 
        assertFalse(Main.validatePassword("abcdef!1234")); // No uppercase letter
    }

    @Test
    public void testInvalidPasswordMissingLowercase() { 
        assertFalse(Main.validatePassword("ABCDEF!1234")); // No lowercase letter
    }

    @Test
    public void testInvalidPasswordMissingDigit() { 
        assertFalse(Main.validatePassword("Abcdefgh!X")); // No digit
    }

    @Test
    public void testInvalidPasswordMissingPunctuation() { 
        assertFalse(Main.validatePassword("Abcdef12345")); // No punctuation
    }

    @Test
    public void testInvalidPasswordTooManyConsecutiveLowercase() { 
        assertFalse(Main.validatePassword("Abcdeeee!123")); // More than 3 consecutive lowercase letters
    }
    @Test
    public void testInvalidPasswordTooManyConsecutiveLowercase2() { 
        assertFalse(Main.validatePassword("Abcdaerfcsfgrezvvfefergverfrfrrrfrf!123")); // More than 3 consecutive lowercase letters
    }


    @Test
    public void testInvalidPasswordWithMultiplePunctuation() { 
        assertFalse(Main.validatePassword("Secure!Pass@12")); // More than one punctuation mark
    }

    @Test
    public void testInvalidPasswordOnlyLettersNoDigitOrPunctuation() { 
        assertFalse(Main.validatePassword("Abcdefghijkl")); // No digit, no punctuation
    }
}