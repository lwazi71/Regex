import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SSNValidatorTest {

    @Test
    public void testValidSSNBasicFormat() { 
        assertTrue(Main.validateSSN("123-45-6789")); // Standard SSN format with dashes
    }

    @Test
    public void testValidSSNWithoutDashes() { 
        assertTrue(Main.validateSSN("123456789")); // No dashes or spaces
    }

    @Test
    public void testValidSSNWithSpaces() { 
        assertTrue(Main.validateSSN("123 45 6789")); // Spaces instead of dashes
    }

    @Test
    public void testValidSSNWithMixedSpacing() { 
        assertTrue(Main.validateSSN("123-45 6789")); // Mixed dashes and spaces
    }

    @Test
    public void testValidSSNWithLeadingZero() { 
        assertTrue(Main.validateSSN("012-34-5678")); // Leading zero in the area number
    }

    // EXTRA CREDIT TEST - SSA Valid Area Number (Highest Valid)
    @Test
    public void testValidSSNWithHighValidArea() { 
        assertTrue(Main.validateSSN("899-12-3456")); // Highest valid area number under 900
    }

    //  EXTRA CREDIT TEST - SSA Valid Area Number (Lowest Valid)
    @Test
    public void testValidSSNWithEdgeValidArea() { 
        assertTrue(Main.validateSSN("001-23-4567")); // Lowest valid area number
    }

    //  EXTRA CREDIT TEST - SSA Valid Serial Number (Max Valid)
    @Test
    public void testValidSSNWithMaxValidSerial() { 
        assertTrue(Main.validateSSN("123-45-9999")); // Valid last four digits at max range
    }

    @Test
    public void testInvalidSSNAllZeros() { 
        assertFalse(Main.validateSSN("000-00-0000")); // Completely invalid SSN
    }

    //  EXTRA CREDIT TEST - SSA Invalid Area Number (666)
    @Test
    public void testInvalidSSNInvalidAreaNumber() { 
        assertFalse(Main.validateSSN("666-12-3456")); // 666 is not a valid area number
    }

    //  EXTRA CREDIT TEST - SSA Invalid Area Number (900-999)
    @Test
    public void testInvalidSSNInvalidHighAreaNumber() { 
        assertFalse(Main.validateSSN("999-12-3456")); // Area numbers 900-999 are not valid
    }

    //  EXTRA CREDIT TEST - SSA Invalid Group Number (00)
    @Test
    public void testInvalidSSNInvalidGroupNumber() { 
        assertFalse(Main.validateSSN("123-00-4567")); // Middle two digits cannot be 00
    }

    //  EXTRA CREDIT TEST - SSA Invalid Serial Number (0000)
    @Test
    public void testInvalidSSNInvalidSerialNumber() { 
        assertFalse(Main.validateSSN("123-45-0000")); // Last four digits cannot be 0000
    }

    @Test
    public void testInvalidSSNTooShort() { 
        assertFalse(Main.validateSSN("123-45-678")); // Missing a digit
    }

    @Test
    public void testInvalidSSNTooLong() { 
        assertFalse(Main.validateSSN("123-45-67890")); // Extra digit
    }

    @Test
    public void testInvalidSSNWithLetters() { 
        assertFalse(Main.validateSSN("123-AB-6789")); // Contains non-numeric characters
    }
}