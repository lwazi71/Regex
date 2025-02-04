import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class CityStateZipValidatorTest {

    @Test
    public void testValidSimpleAddress() { 
        assertTrue(Main.validateCityStateZip("Seattle, WA 98101")); 
    }

    @Test
    public void testValidAddressWithMultipleWordCity() { 
        assertTrue(Main.validateCityStateZip("San Francisco, CA 94103")); 
    }

    @Test
    public void testValidAddressWithZIP4() { 
        assertTrue(Main.validateCityStateZip("New York, NY 10001-2345")); 
    }

    @Test
    public void testValidAddressWithLowerCaseCity() { 
        assertTrue(Main.validateCityStateZip("miami, FL 33101")); 
    }

    @Test
    public void testValidAddressWithDifferentState() { 
        assertTrue(Main.validateCityStateZip("Denver, CO 80202")); 
    }

    @Test
    public void testValidAddressWithShortCity() { 
        assertTrue(Main.validateCityStateZip("Irvine, CA 92602")); 
    }

    @Test
    public void testValidAddressWithLongCityName() { 
        assertTrue(Main.validateCityStateZip("West Palm Beach, FL 33401")); 
    }

    @Test
    public void testValidCityStateZip() { 
    assertTrue(Main.validateCityStateZip("Chicago, IL 60616")); 
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
    public void testInvalidStateAbbreviation() { 
        assertFalse(Main.validateCityStateZip("Dallas, ZZ 75201"));  // "ZZ" is not a valid state
    }

    @Test
    public void testInvalidCityWithNumbers() { 
        assertFalse(Main.validateCityStateZip("123 City, TX 75001"));  // City name has numbers
    }
    @Test
    public void testCityWithJustSpaces() { 
    assertFalse(Main.validateCityStateZip("      "));  // Only spaces should fail
}

}

