import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DateValidatorTest {
    @Test
    public void testValidDateWithHyphen() { 
        assertTrue(Main.validateDate("12-25-2023")); // Standard format
    }

    @Test
    public void testValidDateWithSlash() { 
        assertTrue(Main.validateDate("07/04/2023")); // Slash separator
    }

    @Test
    public void testValidLeapYearDate() { 
        assertTrue(Main.validateDate("02-29-2024")); // Valid leap year
    }

    @Test
    public void testValidEndOfMonth30() { 
        assertTrue(Main.validateDate("04-30-2023")); // April has 30 days
    }

    @Test
    public void testValidEndOfMonth31() { 
        assertTrue(Main.validateDate("12-31-2023")); // December has 31 days
    }

    @Test
    public void testValidShortMonthDay() { 
        assertTrue(Main.validateDate("01-01-2023")); // Minimum valid date
    }

    @Test
    public void testValidFourDigitYear() { 
        assertTrue(Main.validateDate("06/15/1999")); // Year is in valid range
    }

    @Test
    public void testValidLeapYearCenturyRule() { 
        assertTrue(Main.validateDate("02-29-2000")); // 2000 is a leap year (divisible by 400)
    }

    @Test
    public void testInvalidDateWrongSeparator() { 
        assertFalse(Main.validateDate("06.15.2023")); // Invalid separator
    }

    @Test
    public void testInvalidDateNonMatchingSeparators() { 
        assertFalse(Main.validateDate("06-15/2023")); // Mixed separators
    }

    @Test
    public void testInvalidDateZeroMonth() { 
        assertFalse(Main.validateDate("00-15-2023")); // Month cannot be 00
    }

    @Test
    public void testInvalidDateZeroDay() { 
        assertFalse(Main.validateDate("06-00-2023")); // Day cannot be 00
    }

    @Test
    public void testInvalidDateOutOfRangeMonth() { 
        assertFalse(Main.validateDate("13-01-2023")); // Month cannot be 13
    }

    @Test
    public void testInvalidDateOutOfRangeDay() { 
        assertFalse(Main.validateDate("04-31-2023")); // April has 30 days
    }

    @Test
    public void testInvalidLeapYearFeb29NonLeap() { 
        assertFalse(Main.validateDate("02-29-2023")); // 2023 is not a leap year
    }

    @Test
    public void testInvalidDateOutOfYearRange() { 
        assertFalse(Main.validateDate("01-15-0999")); // Year must be between 1000 and 9999
    }
}