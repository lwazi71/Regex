import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class URLValidatorTest {

    @Test
    public void testValidURLWithHttp() { 
        assertTrue(Main.validateURL("http://example.com")); // Basic HTTP URL
    }

    @Test
    public void testValidURLWithHttps() { 
        assertTrue(Main.validateURL("https://example.com")); // Basic HTTPS URL
    }

    @Test
    public void testValidURLWithoutProtocol() { 
        assertTrue(Main.validateURL("example.com")); // No http/https, still valid
    }

    @Test
    public void testValidURLWithSubdomain() { 
        assertTrue(Main.validateURL("https://sub.example.com")); // Valid subdomain
    }

    @Test
    public void testValidURLUppercase() { 
        assertTrue(Main.validateURL("HTTPS://EXAMPLE.COM")); // Uppercase letters should be valid
    }

    @Test
    public void testValidURLWithWWW() { 
        assertTrue(Main.validateURL("www.example.com")); // "www" should be valid
    }

    @Test
    public void testValidURLWithHyphen() { 
        assertTrue(Main.validateURL("https://my-site.com")); // Hyphen in domain name
    }

    @Test
    public void testValidURLWithNumbers() { 
        assertTrue(Main.validateURL("http://123example.com")); // Numbers in domain are valid
    }

    @Test
    public void testInvalidURLMissingDomain() { 
        assertFalse(Main.validateURL("http://")); // No domain name
    }

    @Test
    public void testInvalidURLOnlyProtocol() { 
        assertFalse(Main.validateURL("https://")); // Just protocol, no domain
    }

    @Test
    public void testInvalidURLWithInvalidCharacters() { 
        assertFalse(Main.validateURL("http://exa*mple.com")); // Invalid character '*'
    }

    @Test
    public void testInvalidURLDoubleDots() { 
        assertFalse(Main.validateURL("https://example..com")); // Double dots in domain
    }

    @Test
    public void testInvalidURLMissingTLD() { 
        assertFalse(Main.validateURL("http://example")); // No .com, .org, etc.
    }

    @Test
    public void testInvalidURLWithWhitespace() { 
        assertFalse(Main.validateURL("http://example .com")); // Space in domain
    }

    @Test
    public void testInvalidURLWithSpecialCharacters() { 
        assertFalse(Main.validateURL("https://example@.com")); // '@' is not valid in domain
    }

    @Test
    public void testInvalidURLWithOnlyTLD() { 
        assertFalse(Main.validateURL(".com")); // Missing domain name before TLD
    }
}