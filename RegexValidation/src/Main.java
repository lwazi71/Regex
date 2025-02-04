import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
     * grab it all and check if it matches, use greedy
     */
 
    public static void main(String[] args) {
    //Testing SSN validation
    // System.out.println(validateSSN("123-45-6789"));   // Expected: true 
    // System.out.println(validateSSN("123456789"));     // Expected: true
    // System.out.println(validateSSN("123 45 6789"));   // Expected: true
    // System.out.println(validateSSN("000-12-3456"));   // Expected: false 
    // System.out.println(validateSSN("123-45-0000"));   // Expected: false 
    // // Testing Phone Number validation
    // System.out.println(validatePhoneNumber("(305) 555-1234"));  // Expected: true 
    // System.out.println(validatePhoneNumber("212-555-6789"));    // Expected: true 
    // System.out.println(validatePhoneNumber("911-555-1234"));    // Expected: false
    // System.out.println(validatePhoneNumber("000-456-7890"));    // Expected: false

    // Testing Email validation
    // System.out.println(validateEmail("john.doe@example.com"));  // Expected: true 
    // System.out.println(validateEmail("john.doe@example"));       // Expected: false 
    // System.out.println(validateEmail("john.doe@.com"));        // Expected: false 
    // System.out.println(validateEmail("johndoe@example.com"));  // Expected: false 
    // System.out.println(validateEmail("john..doe@.com"));    // Expected: false 

    //Testing name validation
    //System.out.println(validateName("Smith,John,L"));
    //System.out.println(validateName("Mabota,Lwazi,M"));

    //Testing date validation
    // System.out.println(validateDate("02-29-2024")); //  Valid leap year date
    // System.out.println(validateDate("12/31/1999")); //  Valid end of year date
    // System.out.println(validateDate("06-15-2023")); //  Valid mid-year date
    // System.out.println(validateDate("11/30/2022")); //  Valid month with 30 days

    // System.out.println(validateDate("13-10-2023")); //  Invalid month (13)
    // System.out.println(validateDate("04-31-2023")); //  April has only 30 days
    // System.out.println(validateDate("02-30-2023")); //  February cannot have 30 days
    // System.out.println(validateDate("06/15-2023")); // Mixed separators (- and /)

    // System.out.println(validateDate(" 02-29-2024 ")); //  Valid date with spaces
    // System.out.println(validateDate("02-29-1900")); // 1900 is not a leap year
    // System.out.println(validateDate("12-31-9999")); //  Valid extreme future date
    // System.out.println(validateDate("01/01/0000")); // Invalid year (0000)

    //Testing address validation
//   //  False test cases (Wrong structure but possible addresses)
//   System.out.println(validateAddress("123"));              // false (Missing street name & type)
//   System.out.println(validateAddress("456 Oak xyz"));      // false (xyz is not a valid street type)
//   System.out.println(validateAddress("789 Main"));         // false (Missing street type)
//   System.out.println(validateAddress("01 Elm St"));        // false (Leading zero in street number)

//   // Invalid test cases (Completely incorrect formats)
//   System.out.println(validateAddress("Main St 123"));      // false (Number must be first)
//   System.out.println(validateAddress("123*Main*St"));      // false (Special characters not allowed)
//   System.out.println(validateAddress("123 456 789 Blvd")); // false (Street name should have letters)
//   System.out.println(validateAddress("999 Elm Rdd"));      // false (Misspelled street type)
// 
//  // Valid test cases
     //System.out.println(validateCityStateZip("Seattle, WA 98101"));  //  true
    // System.out.println(validateCityStateZip("Los Angeles, CA 90012"));  //  true
    // System.out.println(validateCityStateZip("Winston-Salem, NC 27101"));  //  true
    // System.out.println(validateCityStateZip("O'Connor, TX 73301-1234"));  //  true

    // System.out.println(validateCityStateZip("Seattle WA 98101"));  //  false (Missing comma)
    // System.out.println(validateCityStateZip("San Francisco, California 94101"));  //  false (Full state name not allowed)
    // System.out.println(validateCityStateZip("New York, NY10001"));  //  false (No space before ZIP)
    // System.out.println(validateCityStateZip("Austin, TX 7330"));  //  false (ZIP too short)

    // System.out.println(validateCityStateZip("12345, TX 75001"));  //  false (City cannot be a number)
    // System.out.println(validateCityStateZip("Chicago, XX 60601"));  //  false (Invalid state abbreviation)
    // System.out.println(validateCityStateZip("Miami, FL"));  //  false (Missing ZIP code)
    // System.out.println(validateCityStateZip("New York- NY 10001"));  //  false (Wrong separator)

    //  4 Valid Military Time Test Cases (Should Return true)
    // System.out.println(validateMilitaryTime("0000")); //  Midnight (12:00 AM)
    // System.out.println(validateMilitaryTime("0930")); //  9:30 AM (Leading zero included)
    // System.out.println(validateMilitaryTime("1200")); //  Noon (12:00 PM)
    // System.out.println(validateMilitaryTime("2359")); //  Last valid minute of the day (11:59 PM)

    // //4 False Test Cases (Incorrect Formatting but Possible)
    // System.out.println(validateMilitaryTime("9:30")); //  false (Colons are not allowed)
    // System.out.println(validateMilitaryTime("130"));  //  false (Must be exactly 4 digits, should be "0130")
    // System.out.println(validateMilitaryTime("2400")); //  false (Military time does not use "24:00", should be "0000")
    // System.out.println(validateMilitaryTime("9999")); //  false (Invalid hour and minute range)

    // //  4 Invalid Test Cases (Completely Wrong Inputs)
    // System.out.println(validateMilitaryTime("25:30")); //  false (Hour 25 is out of range)
    // System.out.println(validateMilitaryTime("1980"));  //  false (Minute 80 is out of range)
    // System.out.println(validateMilitaryTime("hello")); //  false (Not a number)
    // System.out.println(validateMilitaryTime("5000"));  //  false (Hour 50 is out of range)

     // 4 Valid Test Cases (Should Return true)
    //System.out.println(validateCurrency("$0.99"));        //  true (Smallest valid amount)
    //System.out.println(validateCurrency("$1,000.00"));    //  true (Proper thousands separator)
    //System.out.println(validateCurrency("$12,345.67"));   //  true (Valid comma placement)
    //System.out.println(validateCurrency("$999,999.99"));  //  true (Large valid amount)
    //System.out.println(validateCurrency("$123,456,789.23"));

    //  //  4 False Test Cases (Incorrect Formatting but Possible)
    //  System.out.println(validateCurrency("123.45"));       //  false (Missing `$`)
    //  System.out.println(validateCurrency("$1234.56"));     //  false (Missing comma)
    //  System.out.println(validateCurrency("$12,34,567.89"));//  false (Incorrect comma placement)
    //  System.out.println(validateCurrency("$123.456"));     //  false (Too many decimal places)

    //  //  4 Invalid Test Cases (Completely Wrong Inputs)
    //  System.out.println(validateCurrency("$1,234"));       //  false (Missing cents `.xx`)
    //  System.out.println(validateCurrency("$0123.45"));     //  false (Leading zero issue)
    //  System.out.println(validateCurrency("$-100.00"));     //  false (Negative values not supported)
    //  System.out.println(validateCurrency("$12a,345.67"));  //  false (Letters inside numbers)

    // //  Valid Test Cases
    // System.out.println(validateURL("https://example.com"));  //  true
    // System.out.println(validateURL("http://sub.domain.co.uk"));  //  true
    // System.out.println(validateURL("www.website.org/path"));  //  true
    // System.out.println(validateURL("https://my-site.io/about?user=123&sort=asc"));  //  true

    // //  False Test Cases (Incorrectly formatted but possible URLs)
    // System.out.println(validateURL("htp://wrong.url"));  //  false (Misspelled protocol)
    // System.out.println(validateURL("example@website.com"));  //  false (This is an email)
    // System.out.println(validateURL("https:/missing-slash.com"));  //  false (Only one slash after https)
    // System.out.println(validateURL("http://-bad-.com"));  //  false (Hyphen in invalid position)

    // //  Invalid Test Cases (Completely broken)
    // System.out.println(validateURL("http://.invalid.com"));  // false (Domain cannot start with a dot)
    // System.out.println(validateURL("http://site.c"));  //  false (TLD must be at least 2 characters)
    // System.out.println(validateURL("https:// space.com"));  //  false (Space in domain)
    // System.out.println(validateURL("http://example..com"));  //  false (Double dots not allowed)

    // System.out.println(validateOddWord("station"));    //  true (7 letters, ends in "ion")
    // System.out.println(validateOddWord("information"));   //  true (11 letters, ends in "ion")
    // System.out.println(validateOddWord("evolution"));  //  true (9 letters, ends in "ion")
    // System.out.println(validateOddWord("confusion"));   //  true (9 letters, ends in "ion")
    // System.out.println(validateOddWord("ion"));        //  true (3 letters, ends in "ion")

    // System.out.println("Testing false");
    
    // System.out.println(validateOddWord("lion"));      //  false (4 letters, even)
    // System.out.println(validateOddWord("nation"));    //  false (6 letters, even)
    // System.out.println(validateOddWord("vision"));    //  false (6 letters, even)
    // System.out.println(validateOddWord("minion"));    //  false (6 letters, even)
// Valid cases
System.out.println("Valid passwords:");
System.out.println("Xyz1!Hello: " + validatePassword("Xyz1!Hello"));      // true
System.out.println("PassW0rd!123: " + validatePassword("PassW0rd!123"));  // true
System.out.println("A!bcD1efGhi: " + validatePassword("A!bcD1efGhi"));    // true

// Invalid cases
System.out.println("\nInvalid passwords:");
System.out.println("1234567890: " + validatePassword("1234567890"));      // false - no !
System.out.println("abcdef1234: " + validatePassword("abcdef1234"));      // false - no ! and no uppercase
System.out.println("ABCDEFGH1: " + validatePassword("ABCDEFGH1"));        // false - no ! and no lowercase
System.out.println("Password123: " + validatePassword("Password123"));     // false - no !

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
    
        // Regex for City, State, ZIP
        String regex = "^(?i)" // Case-insensitive match
            + "[A-Za-z][a-z']*" // First letter uppercase, allows apostrophes
            + "(?:\\s+[A-Za-z][a-z']*)*" // Allows multi-word cities (New York)
            + "(?:-\\s*[A-Za-z][a-z']+)*" // Allows hyphenated city names (Winston-Salem)
            + ",\\s*" // Comma with optional spaces after city
            + "(" + stateRegex + ")\\s" // Valid state abbreviations
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
    
    private static boolean validateEmail(String email) { 
        if (isNullOrEmpty(email)) return false;  // Check for null or empty input
        
        email = email.trim();  // Remove leading and trailing spaces
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        
        return regexChecker(regex, email);  // Check if email matches regex
    }

    private static boolean validateMilitaryTime(String time) { 
        if(isNullOrEmpty(time)) return false;
        time = time.trim();
        String regex = 
        "^(?:[01]\\d|2[0-3])" +  // Ensures the first two digits represent valid hours (00-23)
        "[0-5]\\d" +              // Ensures the last two digits represent valid minutes (00-59)
        "$";                      // End of string, ensuring exactly 4 digits and no extra characters
        return regexChecker(regex, time);
    }

    private static boolean validateName(String name) { 
        /*
         * Name format: Last name, First name, MI
         * - Allows zero or more middle initials
         * - Example: Smith, John, L
         * - Example: Mabota, Lwazi, M
         */
    
        if (isNullOrEmpty(name)) return false;  // Check for null or empty input
        
        name = name.trim();  // Remove leading and trailing spaces
        
        String regex = "^"  // Start of string
            + "[A-Z][a-zA-Z'-]*"  // Last name: Starts uppercase, allows hyphens & apostrophes
            + ",\\s*"  // Ensures a comma followed by optional spaces
            + "[A-Z][a-zA-Z'-]*"  // First name: Starts uppercase, allows hyphens & apostrophes
            + "(,\\s*[A-Z])?"  // Optional middle initial: Single uppercase letter after comma
            + "$";  // End of string
        
        return regexChecker(regex, name);  // Check if name matches regex
    }
        private static boolean validateOddWord(String word) { 
            if (isNullOrEmpty(word)) return false; 
            word = word.trim();
            
            String regex = "^(?:[a-z]{2})+[a-z]ion$";
            
            return regexChecker(regex, word); //  Directly return regexChecker result
        }

    private static boolean validatePassword(String password) { 
        if (isNullOrEmpty(password)) return false;
        password = password.trim();
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*!)" +
               "(?!.*[a-z]{4,})[A-Za-z0-9!]{10,}$";
    
        return regexChecker(regex, password);
    }
    public static boolean validatePhoneNumber(final String phoneNumber) { 
        if (isNullOrEmpty(phoneNumber)) return false;
        
        String trimmedPhone = phoneNumber.trim();
    
        // Define regex for US phone number format with optional separators
        String rgx = "^\\+?1?[-.\\s]?\\(?([2-9][0-9]{2})\\)?[-.\\s]?([2-9][0-9]{2})[-.\\s]?(\\d{4})$";
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
    private static boolean validateSSN(String ssn) { 
    if(isNullOrEmpty(ssn)) return false; 
    ssn = ssn.trim();

    // Define regex pattern to check valid SSN format (with extra credit)
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

private static boolean validateURL(String url) { 
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