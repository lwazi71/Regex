import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;
public class EmailValidatorTest {
    @Test
    public void testValidEmailSimple() { 
        assertTrue(Main.validateEmail("test@example.com")); // Basic format
    }
    @Test
    public void testValidEmailSimple2() { 
        assertTrue(Main.validateEmail("lwazimabota1@gmail.com")); // Basic format
    }

    @Test
    public void testValidEmailWithNumbers() { 
        assertTrue(Main.validateEmail("user123@example.com")); // Numbers in local part
    }

    @Test
    public void testValidEmailWithDotInLocalPart() { 
        assertTrue(Main.validateEmail("first.last@example.com")); // Dot in local part
    }

    @Test
    public void testValidEmailWithHyphenInDomain() { 
        assertTrue(Main.validateEmail("user@my-domain.com")); // Hyphen in domain
    }

    @Test
    public void testValidEmailWithSubdomain() { 
        assertTrue(Main.validateEmail("user@mail.example.com")); // Subdomains
    }

    @Test
    public void testValidEmailWithPlusSign() { 
        assertTrue(Main.validateEmail("email+alias@gmail.com")); // Plus aliasing
    }

    @Test
    public void testValidEmailWithUnderscore() { 
        assertTrue(Main.validateEmail("user_name@example.com")); // Underscore in local part
    }

    @Test
    public void testValidEmailWithLongTLD() { 
        assertTrue(Main.validateEmail("user@example.museum")); // Long TLD
    }

    @Test
    public void testInvalidEmailMissingAtSymbol() { 
        assertFalse(Main.validateEmail("testexample.com")); // No @ symbol
    }

    @Test
    public void testInvalidEmailMultipleAtSymbols() { 
        assertFalse(Main.validateEmail("user@@example.com")); // Multiple @ symbols
    }

    @Test
    public void testInvalidEmailMissingDomain() { 
        assertFalse(Main.validateEmail("user@.com")); // No domain name
    }

    @Test
    public void testInvalidEmailMissingTLD() { 
        assertFalse(Main.validateEmail("user@example")); // No .TLD
    }

    @Test
    public void testInvalidEmailDoubleDot() { 
        assertFalse(Main.validateEmail("user..name@example.com")); // Double dots in local part
    }

    @Test
    public void testInvalidEmailStartingWithDot() { 
        assertFalse(Main.validateEmail(".user@example.com")); // Starts with dot
    }

    @Test
    public void testInvalidEmailSpecialCharacters() { 
        assertFalse(Main.validateEmail("user#@example.com")); // Invalid special character
    }

    @Test
    public void testInvalidEmailSpaceInAddress() { 
        assertFalse(Main.validateEmail("user name@example.com")); // Space in email
    }
}