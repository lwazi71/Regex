import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class MilitaryTimeValidatorTest {

    @Test
    public void testValidMilitaryTimeMidnight() { 
        assertTrue(Main.validateMilitaryTime("0000")); // Midnight (start of day)
    }

    @Test
    public void testValidMilitaryTimeEarlyMorning() { 
        assertTrue(Main.validateMilitaryTime("0930")); // Morning time
    }

    @Test
    public void testValidMilitaryTimeNoon() { 
        assertTrue(Main.validateMilitaryTime("1200")); // Noon
    }
    @Test
    public void testValidMilitaryTimeMidmorning() { 
        assertTrue(Main.validateMilitaryTime("1230")); // Midmorning time
    }

    @Test
    public void testValidMilitaryTimeAfternoon() { 
        assertTrue(Main.validateMilitaryTime("1545")); // Afternoon time
    }

    @Test
    public void testValidMilitaryTimeEvening() { 
        assertTrue(Main.validateMilitaryTime("2030")); // Evening time
    }

    @Test
    public void testValidMilitaryTimeLateNight() { 
        assertTrue(Main.validateMilitaryTime("2359")); // Last valid minute before midnight
    }

    @Test
    public void testValidMilitaryTimeLeadingZeroHour() { 
        assertTrue(Main.validateMilitaryTime("0215")); // Leading zero is required for hours < 10
    }

    @Test
    public void testValidMilitaryTimeEdgeCase() { 
        assertTrue(Main.validateMilitaryTime("1959")); // Edge case before next hour
    }

    @Test
    public void testInvalidMilitaryTimeOutOfRangeHours() { 
        assertFalse(Main.validateMilitaryTime("2400")); // 24 is not a valid hour
    }

    @Test
    public void testInvalidMilitaryTimeOutOfRangeMinutes() { 
        assertFalse(Main.validateMilitaryTime("1260")); // 60 is not a valid minute
    }

    @Test
    public void testInvalidMilitaryTimeTooShort() { 
        assertFalse(Main.validateMilitaryTime("930")); // Missing leading zero
    }

    @Test
    public void testInvalidMilitaryTimeTooLong() { 
        assertFalse(Main.validateMilitaryTime("12345")); // Extra digit
    }

    @Test
    public void testInvalidMilitaryTimeContainsLetters() { 
        assertFalse(Main.validateMilitaryTime("12A0")); // Alphabetic character
    }

    @Test
    public void testInvalidMilitaryTimeSpecialCharacters() { 
        assertFalse(Main.validateMilitaryTime("12:30")); // Contains colon
    }

    @Test
    public void testInvalidMilitaryTimeLeadingSpace() { 
        assertFalse(Main.validateMilitaryTime(" 0930")); // Leading space
    }

    @Test
    public void testInvalidMilitaryTimeTrailingSpace() { 
        assertFalse(Main.validateMilitaryTime("0930 ")); // Trailing space
    }

}