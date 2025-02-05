import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class CityStateZipValidatorTest {

    @Test
    public void testValidSimpleAddress() { 
        assertTrue(Main.validateCityStateZip("Seattle, WA 98101")); // Standard case
    }

    @Test
    public void testValidAddressWithMultipleWordCity() { 
        assertTrue(Main.validateCityStateZip("San Francisco, CA 94103")); // Multi-word city name
    }

    @Test
    public void testValidAddressWithZIP4() { 
        assertTrue(Main.validateCityStateZip("New York, NY 10001-2345")); // ZIP+4 format
    }

    @Test
    public void testValidAddressWithLowerCaseCity() { 
        assertTrue(Main.validateCityStateZip("miami, FL 33101")); // Lowercase city name (case insensitive)
    }

    @Test
    public void testValidAddressWithDifferentState() { 
        assertTrue(Main.validateCityStateZip("Denver, CO 80202")); // Different state example
    }

    @Test
    public void testValidAddressWithShortCity() { 
        assertTrue(Main.validateCityStateZip("Irvine, CA 92602")); // Short city name
    }

    @Test
    public void testValidAddressWithLongCityName() { 
        assertTrue(Main.validateCityStateZip("West Palm Beach, FL 33401")); // Long city name
    }

    @Test
    public void testValidCityStateZip() { 
        assertTrue(Main.validateCityStateZip("Chicago, IL 60616")); // Another standard format
    }

    @Test
    public void testInvalidMissingState() { 
        assertFalse(Main.validateCityStateZip("Seattle 98101"));  // No state
    }

    @Test
    public void testInvalidMissingComma() { 
        assertFalse(Main.validateCityStateZip("Seattle WA 98101"));  // Missing comma
    }

    @Test
    public void testInvalidMissingZIP() { 
        assertFalse(Main.validateCityStateZip("Chicago, IL"));  // No ZIP code
    }

    @Test
    public void testInvalidZIPWithLetters() { 
        assertFalse(Main.validateCityStateZip("Houston, TX 77A01"));  // ZIP contains a letter
    }

    @Test
    public void testInvalidZIPTooShort() { 
        assertFalse(Main.validateCityStateZip("Phoenix, AZ 8501"));  // 4-digit ZIP (should be 5)
    }

    @Test
    public void testInvalidZIPTooLong() { 
        assertFalse(Main.validateCityStateZip("Boston, MA 021345"));  // 6-digit ZIP (invalid)
    }

    @Test
    public void testInvalidCityWithNumbers() { 
        assertFalse(Main.validateCityStateZip("123 City, TX 75001"));  // City name has numbers
    }

    @Test
    public void testCityWithJustSpaces() { 
        assertFalse(Main.validateCityStateZip("      "));  // Only spaces should fail
    }


    //  **EXTRA CREDIT TEST CASES (State Validation)** 

    @Test
    public void testInvalidStateAbbreviation() { 
        assertFalse(Main.validateCityStateZip("Dallas, ZZ 75201"));  // "ZZ" is not a valid state
    }

    @Test
    public void testInvalidStateNumeric() { 
        assertFalse(Main.validateCityStateZip("Austin, 12 73301"));  // State cannot be numbers
    }

    @Test
    public void testInvalidStateTooLong() { 
        assertFalse(Main.validateCityStateZip("Las Vegas, NEV 89109"));  // State abbreviation must be 2 letters
    }

    @Test
    public void testInvalidCityWithSpecialCharacters() { 
        assertFalse(Main.validateCityStateZip("New@York, NY 10001"));  // City contains '@' which is invalid
    }

    @Test
    public void testValidStateEdgeCase() { 
        assertTrue(Main.validateCityStateZip("Honolulu, HI 96813")); // Valid state abbreviation (edge case)
    }

    @Test
    public void testValidAddressWithAlternateZIP4Format() { 
        assertTrue(Main.validateCityStateZip("Philadelphia, PA 19103-4567")); // ZIP+4 with different format
    }

    @Test
    public void testValidCityStateZipWithSpecialCharacterCity() { 
        assertTrue(Main.validateCityStateZip("St. Louis, MO 63101")); // City with a period
    }

    @Test
    public void testValidCityStateZipWithApostropheCity() { 
        assertTrue(Main.validateCityStateZip("O'Fallon, IL 62269")); // City with an apostrophe
    }

}