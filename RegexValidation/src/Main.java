import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    /*
     * grab it all and check if it matches, use greedy
     */
 
    public static void main(String[] args) {
    // Testing SSN validation
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
//    System.out.println(validateName("Smith,John,L"));
//    System.out.println(validateName("Mabota,Lwazi,M"));


    // Testing Address validation

        
    }

    // helper method to check if string matches regex pattern
    private static boolean regexChecker(final String rgx, final String input){
        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    // helper method to check if string is null or empty
    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean validateAddress(String address) { 
        return false; 

    }

    private static boolean validateCityStateZip(String input) { 
        return false; 
    }

    private static boolean validateCurrency(String currency) { 
        return false; 
    }

    private static boolean validateDate(String date) { 
        if(isNullOrEmpty(date)) return false;
        date = date.trim();
        /*
         * 04-13-2003
         * 4/13/2003
         * 04-13-2023
         */

        String regex = "^(0[1-9]|1[0-2])([-\\/])(0[1-9]|[12][0-9]|3[01])\\2(\\d{4})$";
        return regexChecker(regex, date);
    }

    
    private static boolean validateEmail(String email) { 
        if(isNullOrEmpty(email)) return false;
        email = email.trim();
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return regexChecker(regex, email);
    }

    private static boolean validateMilitaryTime(String time) { 
        return false; 
    }

    private static boolean validateName(String name) { 
        /*
         * Name on a class roster, assuming zero or more middle initials - Last name, First name, MI (e.g. Smith, John, L
         * Mabota, Lwazi, M
         */
        if(isNullOrEmpty(name)) return false;
        name = name.trim();
        String regex = "^[A-Z][a-zA-Z'-]*,\\s*[A-Z][a-zA-Z'-]*(,\\s*[A-Z])?$";
        return regexChecker(regex, name);
    }

    private static boolean validateOddWord(String word) { 
        return false; 
    }

    private static boolean validatePassword(String password) { 
        return false; 
    }

    private static boolean validatePhoneNumber(String phoneNumber) { 
         // valid phone number (123) 456-7890 123-456-7890 123.456.7890 123456789 +1 123-456-7890

         if(isNullOrEmpty(phoneNumber)) return false; 
         // remove leading and trailing spaces
         phoneNumber = phoneNumber.trim();

        //define the regex pattern, ensures that phone number area code (XXX), seperators space ` `, dash, `-`, or dot `.`
        // Ensures 10 digits are present
        // Ensure country code +1 is present
        // Define regex pattern to validate US phone numbers (with extra credit)
        String regex = 
            "^\\+?1?" +          // Optional country code: "+1" or just "1" (can be omitted)
            "[- .]?" +           // Optional separator after country code: "-", ".", or space
            "\\(?([2-9][0-9]{2})\\)?" + // Valid area code: 3 digits (200-999), optional parentheses
            "[- .]?" +           // Optional separator after area code: "-", ".", or space
            "([2-9][0-9]{2})" +  // Valid exchange code: 3 digits (200-999), cannot start with 0 or 1
            "[- .]?" +           // Optional separator after exchange code: "-", ".", or space
            "(\\d{4})$";         // Last 4 digits of phone number (required)
        if(!regexChecker(regex, phoneNumber)){
            return false;
        }
            // remove the non-digit characters spaces and dashes
        phoneNumber = phoneNumber.replaceAll("[^0-9]", ""); 
        // extract components
        int areaStr = Integer.parseInt(phoneNumber.substring(0,3));
        int groupStr = Integer.parseInt(phoneNumber.substring(3,6));
        int serialStr = Integer.parseInt(phoneNumber.substring(6));

        if(!isValidAreaCode(areaStr) || groupStr == 0 || serialStr == 0) {
            return false;
        }
        return true;
        
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

// Extra Credit: Ensure the area number is valid according to SSA rules
private static boolean isValidAreaNumber(int area) {
    return area != 0 && area != 666 && (area < 900 || area > 999);
}
private static boolean validateURL(String url) { 
        return false; 
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
// Extra Credit: Ensure the area code is valid according to Area code rules
private static boolean isValidAreaCode(int areaCode){
    return areaCode >= 200 && areaCode <= 999 && areaCode != 911 && areaCode != 555 && areaCode % 100 != 00;
}
}