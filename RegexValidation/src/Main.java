import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
     * grab it all and check if it matches, use greedy
     */
 
    public static void main(String[] args) {
    }

    // helper method to check if string matches regex pattern
    private static boolean regexChecker(final String rgx, final String input){
        Pattern pattern = Pattern.compile(rgx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // helper method to check if string is null or empty
    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean validateCityStateZip(String input) { 
        if (isNullOrEmpty(input)) return false;
        
        // Normalize spaces: replace multiple spaces with a single space
        input = input.trim().replaceAll("\\s+", " ");
    
        // List of all 50 U.S. state abbreviations
        List<String> stateAbbreviations = Arrays.asList(
            "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
            "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
            "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
            "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
        );
    
        // Convert list into a regex-friendly format (AL|AK|AZ|...)
        String stateRegex = String.join("|", stateAbbreviations);
    
        // Updated Regex for City, State, ZIP
        String regex = "^[A-Z][a-z'.]*" // First letter uppercase, allows apostrophes & periods
            + "(?:\\s+[A-Z][a-z'.]*)*" // Allows multi-word cities (New York, St. Louis)
            + "(?:-\\s*[A-Z][a-z'.]*)*" // Allows hyphenated city names (Winston-Salem)
            + ",\\s*" // Comma with optional spaces after city
            + "(?<![a-z])(" + stateRegex + ")(?![a-z])\\s" // Ensures **strict uppercase** state abbreviations
            + "\\d{5}" // 5-digit ZIP code
            + "(-\\d{4})?" // Allows optional ZIP+4 format (-1234)
            + "$";
    
        return regexChecker(regex, input);
    }
    public static boolean validateCurrency(String currency) { 
        if (isNullOrEmpty(currency)) return false;
        currency = currency.trim();
        
        String regex = "^"                   
            + "\\$"                            // Dollar sign
            + "(?:0|[1-9]\\d{0,2}(?:,\\d{3})*|[1-9]\\d*)" // Whole number part (allows commas OR no commas)
            + "\\.\\d{2}"                      // Decimal part (exactly two digits)
            + "$";
    
        return regexChecker(regex, currency);
    }
    public static boolean validateDate(String date) { 
        if (isNullOrEmpty(date)) return false;
    
        date = date.trim();
        String regex = "^"  // Start of the string
            + "(0[1-9]|1[0-2])"  // Match the month (01-12)
            + "([-\\/])"           // Match the separator (- or /)
            + "(0[1-9]|[12][0-9]|3[01])"  // Match the day (01-31)
            + "\\2"                // Ensure the same separator is used
            + "(\\d{4})"           // Match a four-digit year
            + "$";                 // End of the string
    
        if (!regexChecker(regex, date)) return false;
    
        // Extract date components
        String[] parts = date.split("[-/]");
        int month = Integer.parseInt(parts[0]); 
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
    
        //  Fix: Ensure the year is within a valid range (e.g., 1000 - 9999)
        if (year < 1000 || year > 9999) return false;
    
        // Validate months with 30 days
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) return false;
    
        // Validate February (28 or 29 days only)
        if (month == 2) {
            if (day > 29 || (day == 29 && !isLeapYear(year))) return false;
        }
    
        return true; // Everything is valid
    }
    
    public static boolean validateEmail(String email) { 
        if (isNullOrEmpty(email)) return false;  // Check for null or empty input
        
        email = email.trim();  // Remove leading and trailing spaces
    
        String regex = "^[A-Za-z0-9][A-Za-z0-9._%+-]*[A-Za-z0-9]@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    
        boolean isValidFormat = regexChecker(regex, email);
        boolean hasConsecutiveDots = email.split("@")[0].contains("..");
    
        return isValidFormat && !hasConsecutiveDots;
    }

    public static boolean validateMilitaryTime(String time) { 
        if(isNullOrEmpty(time)) return false;
        time = time.trim();
        
        String regex = "^(?!\\s)(?:[01]\\d|2[0-3])[0-5]\\d(?!\\s)$";
    
        return regexChecker(regex, time);
    }

    public static boolean validateName(String name) { 
        if (isNullOrEmpty(name)) return false;  // Check for null or empty input
    
        // Updated regex to ensure uppercase first letter for last name
        String regex = "^"  
            + "(?=[A-Z])"  // Ensure first character is uppercase
            + "[A-Z][a-zA-Z'\\-]*(?:\\s+[A-Z][a-zA-Z'\\-]*)*"  // Last name (allows spaces in multi-word last names)
            + ",\\s*"  // Ensures a comma followed by optional spaces
            + "[A-Z][a-zA-Z'\\-]*"  // First name: Starts uppercase, allows hyphens & apostrophes
            + "(?:,\\s*[A-Z])?"  // Optional middle initial: Single uppercase letter after comma
            + "$";  // End of string
    
        // **Ensure no leading or trailing spaces**
        if (!name.equals(name.trim())) return false;
    
        return regexChecker(regex, name);  // Check if name matches regex
    }
    public static boolean validateOddWord(String input) {
        if (isNullOrEmpty(input)) return false;  // Check for null or empty input
        String regex = "(?i)" // Enable case-insensitive matching
                + "^" // Ensure the match starts at the beginning of the string
                + "([a-z]{2})+" // Match any sequence of even-length letter pairs
                + "[a-z]" // Ensure the total length is odd by adding one extra letter
                + "(?<=ion)" // Ensure the word ends with "ion"
                + "$"; // Ensure the match extends to the end of the string
        return regexChecker(regex, input);
    }
    public static boolean validatePassword(final String input) {
        if (isNullOrEmpty(input)) return false;  // Check for null or empty input
    
        String rgx = "^" //
                + "(?=.*[a-z])" // At least one lowercase letter
                + "(?=.*[A-Z])" // At least one uppercase letter
                + "(?=.*\\d)" // At least one number
                + "(?=.*!)" // Requires exactly one '!' punctuation mark
                + "(?!.*(.)\\1{2,})" // Prevents two+ consecutive duplicate characters
                + "[A-Za-z\\d!]{10,}" // Accepts only letters, digits, and '!', with a minimum length of 10
                + "$"; // End of string
        
        // I am not using the helper method here becuase =
        Pattern pattern = Pattern.compile(rgx); // ⚠️ Removed `Pattern.CASE_INSENSITIVE`
        Matcher matcher = pattern.matcher(input);
        
        return matcher.matches();
    }
    public static boolean validatePhoneNumber(final String phoneNumber) { 
        if (isNullOrEmpty(phoneNumber)) return false;
        
        String trimmedPhone = phoneNumber.trim();
    
        // Define regex for US phone number format with optional separators
        String rgx = "^(\\+1[-.\\s]?)?" +  // Enforce that "1" must have a "+" before it
        "\\(?([2-9][0-9]{2})\\)?[-.\\s]?" +  // Valid area code (XXX), optional parentheses
        "([2-9][0-9]{2})[-.\\s]?" +  // Exchange code (XXX), ensuring no leading 0/1
        "(\\d{4})$";  // Last 4 digits
        // Ensured exchange code cannot start with 0 or 1 → `([2-9][0-9]{2})`
        // Ensured area code is valid from the start → `([2-9][0-9]{2})`
        
        if (!regexChecker(rgx, trimmedPhone)) return false;
    
        // Extract the numeric-only phone number
        String digitsOnly = trimmedPhone.replaceAll("[^0-9]", "");
        
        if (digitsOnly.length() == 11 && digitsOnly.startsWith("1")) {
            digitsOnly = digitsOnly.substring(1); // Remove leading country code "1" if present
        }
    
        if (digitsOnly.length() != 10) return false;
    
        // Extract components
        int areaCode = Integer.parseInt(digitsOnly.substring(0, 3));
        int exchangeCode = Integer.parseInt(digitsOnly.substring(3, 6));
        int serialNumber = Integer.parseInt(digitsOnly.substring(6));
    
        // Ensure all components are valid
        return isValidAreaCode(areaCode) && exchangeCode >= 200 && serialNumber != 0;
    }
    public static boolean validateSSN(String ssn) { 
    if(isNullOrEmpty(ssn)) return false; 
    ssn = ssn.trim();

    // Define regex pattern to check valid SSN format (with extra credit)
    String regex = 
        "^(?!000|666|9\\d{2})" +  // Area number (first 3 digits) cannot be 000, 666, or 900-999
        "\\d{3}[- ]?" +           // Valid area number: 3 digits, optional dash or space
        "(?!00)" +                // Group number (middle 2 digits) cannot be 00
        "\\d{2}[- ]?" +           // Valid group number: 2 digits, optional dash or space
        "(?!0000)" +              // Serial number (last 4 digits) cannot be 0000
        "\\d{4}$";                // Valid serial number: exactly 4 digits, must be at end
    
    // Use regexChecker to validate format
    if (!regexChecker(regex, ssn)) {
        return false;
    }

    // Remove dashes and spaces to extract numbers only
    ssn = ssn.replaceAll("[- ]", "");

    // Extract SSN components
    int area = Integer.parseInt(ssn.substring(0, 3));
    int group = Integer.parseInt(ssn.substring(3, 5));
    int serial = Integer.parseInt(ssn.substring(5));

    // Extra Credit: SSA Numbering Rules 
    if (!isValidAreaNumber(area) || group == 0 || serial == 0) {
        return false;
    }
    return true;
}

public static boolean validateURL(String url) { 
    if(isNullOrEmpty(url)) return false;
    url = url.trim();
    String regex = "^(https?:\\/\\/)?(www\\.)?[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+([\\/\\w .-]*)*$";
    return regexChecker(regex, url);
    }



// Helper method for leap year calculation
private static boolean isLeapYear(int year) {
    if(year % 4 == 0){
        if(year % 100 == 0){
            return year % 400 == 0;
        }
        return true;
    }
    return false;
}
public static boolean validateAddress(String address) { 
    if (address == null || address.trim().isEmpty()) return false;
    
    address = address.trim();

    // Updated regex pattern for address validation
    String regex = "^"
        + "(?!0\\d)\\d{1,5}"                     // 1 to 5-digit street number, no leading zeros
        + "\\s+"                                 // At least one space after the number
        + "(?=.*[A-Za-z])[A-Za-z0-9]+(?:\\s+[A-Za-z0-9]+)*" // Street name must contain at least 1 letter
        + "\\s+"                                 // Space before street type
        + "(?i)(Street|St|Avenue|Ave|Boulevard|Blvd|Road|Rd)$"; // Case-insensitive street types

    return address.matches(regex);
}
// Extra Credit area code
private static boolean isValidAreaCode(int areaCode) {
    return (areaCode >= 200 && areaCode <= 998)  // Fix: Changed to `998` to exclude `999`
        && areaCode != 911  // Emergency
        && areaCode != 555;  // Invalid for general use
}
// Extra Credit: Ensure the area number is valid according to SSA rules
private static boolean isValidAreaNumber(int area) {
    return area != 0 && area != 666 && (area < 900 || area > 999);
}
}