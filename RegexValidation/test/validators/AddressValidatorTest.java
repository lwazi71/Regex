import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*
;
public class AddressValidatorTest {
    @Test
    public void testValidAddressSimple() { 
        assertTrue(Main.validateAddress("123 Main St")); 
    }

    @Test
    public void testValidAddressFullType() { 
        assertTrue(Main.validateAddress("456 Oak Road")); 
    }

    @Test
    public void testValidAddressBoulevard() { 
        assertTrue(Main.validateAddress("789 Sunset Boulevard")); 
    }

    @Test
    public void testValidAddressAvenue() { 
        assertTrue(Main.validateAddress("101 Pacific Avenue")); 
    }

    @Test
    public void testValidAddressMultiWord() { 
        assertTrue(Main.validateAddress("222 West Elm Street")); 
    }

    @Test
    public void testValidAddressWithMaxStreetNumber() { 
        assertTrue(Main.validateAddress("99999 Big Tree Rd"));  // Maximum 5-digit street number
    }

    @Test
    public void testValidAddressWithMinimumStreetNumber() { 
        assertTrue(Main.validateAddress("1 Elm St"));  // Minimum valid street number
    }

    @Test
    public void testValidAddressWithLongStreetName() { 
        assertTrue(Main.validateAddress("88 This Is A Very Long Street Name Road")); 
    }

    @Test
    public void testInvalidAddressMissingStreetName() { 
        assertFalse(Main.validateAddress("123")); 
    }

    @Test
    public void testInvalidAddressInvalidStreetType() { 
        assertFalse(Main.validateAddress("456 Oak xyz")); 
    }

    @Test
    public void testInvalidAddressMissingStreetType() { 
        assertFalse(Main.validateAddress("789 Main")); 
    }

    @Test
    public void testInvalidAddressLeadingZero() { 
        assertFalse(Main.validateAddress("01 Elm St")); 
    }

    @Test
    public void testInvalidAddressNumberNotFirst() { 
        assertFalse(Main.validateAddress("Main St 123")); 
    }

    @Test
    public void testInvalidAddressSpecialCharacters() { 
        assertFalse(Main.validateAddress("123*Main*St")); 
    }


    @Test
    public void testInvalidAddressMisspelledStreetType() { 
        assertFalse(Main.validateAddress("999 Elm Rdd")); 
    }

    @Test
    public void testValidAddressWithShortAbbreviations() { 
        assertTrue(Main.validateAddress("12 Pine St"));  // "St" abbreviation
    }

    @Test
    public void testValidAddressWithDifferentStreetTypes() { 
        assertTrue(Main.validateAddress("345 Maple Blvd"));  // "Blvd" abbreviation
    }

    @Test
    public void testValidAddressWithExtraSpacesTrimmed() { 
        assertTrue(Main.validateAddress(" 678 Birch Rd  "));  // Should trim spaces
    }

    @Test
    public void testValidAddressWithNumbersInStreetName() { 
        assertTrue(Main.validateAddress("400 2nd Avenue"));  // "2nd" should be valid in name
    }

    @Test
    public void testValidAddressWithMixedCase() { 
        assertTrue(Main.validateAddress("890 Elm St"));  // Case-insensitive match
    }

    @Test
    public void testValidAddressWithFullStreetTypeCapitalized() { 
        assertTrue(Main.validateAddress("753 Birch STREET"));  // Should accept uppercase
    }

    @Test
    public void testValidAddressWithDifferentSpacing() { 
        assertTrue(Main.validateAddress("951   Oak    Rd"));  // Extra spaces between words
    }

    @Test
    public void testValidAddressWithEdgeNumber() { 
        assertTrue(Main.validateAddress("99999 Grand Ave"));  // Largest possible street number
    }

    @Test
    public void testInvalidAddressOnlyStreetType() { 
        assertFalse(Main.validateAddress("Street"));  // No number or name
    }

    @Test
    public void testInvalidAddressOnlyNumbers() { 
        assertFalse(Main.validateAddress("12345"));  // No street name or type
    }

    @Test
    public void testInvalidAddressSpecialCharactersInStreetName() { 
        assertFalse(Main.validateAddress("101 P!ne St"));  // Invalid character in street name
    }

    @Test
    public void testInvalidAddressWithInvalidCharactersAtEnd() { 
        assertFalse(Main.validateAddress("999 Elm Street#"));  // Special character at end
    }

    @Test
    public void testInvalidAddressWithExtraNumbersInStreetType() { 
        assertFalse(Main.validateAddress("678 Oak St123"));  // Street type should be at end
    }

    @Test
    public void testInvalidAddressWithRandomSymbols() { 
        assertFalse(Main.validateAddress("777 *&^% Blvd"));  // Nonsense characters
    }

    @Test
    public void testInvalidAddressWithJustSpaces() { 
        assertFalse(Main.validateAddress("      "));  // Only spaces should fail
    }

    @Test
    public void testInvalidAddressWithTooManyNumbers() { 
        assertFalse(Main.validateAddress("123456 Elm St"));  // More than 5 digits
    }
}