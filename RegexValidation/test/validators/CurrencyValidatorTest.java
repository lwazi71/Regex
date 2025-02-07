import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class CurrencyValidatorTest {

    @Test
    public void testValidCurrencySimple() { 
        assertTrue(Main.validateCurrency("$123.45")); 
    }

    @Test
    public void testValidCurrencyNoComma() { 
        assertTrue(Main.validateCurrency("$1000.99")); 
    }

    @Test
    public void testValidCurrencyWithComma() { 
        assertTrue(Main.validateCurrency("$1,234.56")); 
    }

    @Test
    public void testValidCurrencyLargeNumber() { 
        assertTrue(Main.validateCurrency("$123,456,789.23")); 
    }

    @Test
    public void testValidCurrencyZeroDollars() { 
        assertTrue(Main.validateCurrency("$0.99")); 
    }

    @Test
    public void testValidCurrencyOnlyHundreds() { 
        assertTrue(Main.validateCurrency("$999.00")); 
    }

    @Test
    public void testValidCurrencyTrailingZeroes() { 
        assertTrue(Main.validateCurrency("$5,678.90")); 
    }

    @Test
    public void testValidCurrencyMaximumPrecision() { 
        assertTrue(Main.validateCurrency("$999,999,999.99")); 
    }

    @Test
    public void testInvalidCurrencyNoDollarSign() { 
        assertFalse(Main.validateCurrency("123.45"));  // Missing $
    }

    @Test
    public void testInvalidCurrencyMissingDecimal() { 
        assertFalse(Main.validateCurrency("$123"));  // No .xx
    }

    @Test
    public void testInvalidCurrencyTooManyDecimals() { 
        assertFalse(Main.validateCurrency("$12.345"));  // More than two decimal places
    }

    @Test
    public void testInvalidCurrencyExtraComma() { 
        assertFalse(Main.validateCurrency("$1,,234.56"));  // Extra comma
    }

    @Test
    public void testInvalidCurrencyOnlyDecimal() { 
        assertFalse(Main.validateCurrency("$.99"));  // No whole number part
    }

    @Test
    public void testInvalidCurrencyCommaAtEnd() { 
        assertFalse(Main.validateCurrency("$1,234,"));  // Ends in a comma
    }

    @Test
    public void testInvalidCurrencyLettersInAmount() { 
        assertFalse(Main.validateCurrency("$12a,456.78"));  // Contains letter
    }

    @Test
    public void testInvalidCurrencyNegativeAmount() { 
        assertFalse(Main.validateCurrency("-$123.45"));  // Negative sign before $
    }

    @Test
    public void testInvalidCurrencyMissingWholeNumber() { 
        assertFalse(Main.validateCurrency("$.99"));  // Missing whole number part, should fail
    }
}