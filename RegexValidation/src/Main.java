import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
 
    public static void main(String[] args) {
         // Testing SSN validation
    System.out.println(validateSSN("123-45-6789"));   // Expected: true 
    System.out.println(validateSSN("123456789"));  // Try this instead of "987654321"
    System.out.println(validateSSN("000-12-3456"));   // Expected: false 
    System.out.println(validateSSN("123-45-0000"));   // Expected: false 
    // Testing Phone Number validation
    System.out.println(validatePhoneNumber("(305) 555-1234"));  // Expected: true 
    System.out.println(validatePhoneNumber("212-555-6789"));    // Expected: true 
    System.out.println(validatePhoneNumber("911-555-1234"));    // Expected: false
    System.out.println(validatePhoneNumber("000-456-7890"));    // Expected: false
        
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
        return false; 
    }

    
    private static boolean validateEmail(String email) { 
        if(email == null || email.trim().isEmpty()) {
            return false;
        }
        return false; 
    }

    private static boolean validateMilitaryTime(String time) { 
        return false; 
    }

    private static boolean validateName(String name) { 
        return false; 
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
         String regex = "^\\+?1?[- .]?\\(?([2-9][0-9]{2})\\)?[- .]?([2-9][0-9]{2})[- .]?(\\d{4})$";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(phoneNumber);

         if(!matcher.matches()) {
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
    String regex = "^(?!000|666|9\\d{2})\\d{3}[- ]?(?!00)\\d{2}[- ]?(?!0000)\\d{4}$";
    
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
// Extra Credit: Ensure the area code is valid according to Area code rules
private static boolean isValidAreaCode(int areaCode){
    return areaCode >= 200 && areaCode <= 999 && areaCode != 911 && areaCode != 555 && areaCode % 100 != 00;
}
}