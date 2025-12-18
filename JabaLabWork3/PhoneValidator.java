import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class PhoneValidator {
    
    private static final String FEDERAL_REGEX = 
        "(\\+7|8)[ -]?(\\([0-9]{3}\\)|[0-9]{3})[ -]?[0-9]{3}[ -]?[0-9]{2}[ -]?[0-9]{2}";
    
    private static final String MUNICIPAL_REGEX = 
        "[23][ -]?[0-9]{2}[ -]?[0-9]{2}[ -]?[0-9]{2}";
    
    public static List<String> extractPhoneNumbers(String text) {
        List<String> phoneNumbers = new ArrayList<>();
        
        Pattern federalPattern = Pattern.compile(FEDERAL_REGEX);
        Matcher federalMatcher = federalPattern.matcher(text);
        while (federalMatcher.find()) {
            phoneNumbers.add(federalMatcher.group());
        }
        
        Pattern municipalPattern = Pattern.compile(MUNICIPAL_REGEX);
        Matcher municipalMatcher = municipalPattern.matcher(text);
        while (municipalMatcher.find()) {
            phoneNumbers.add(municipalMatcher.group());
        }
        
        return phoneNumbers;
    }    
    public static void main(String[] args) {
        String testText = "Мои номера 220-30-40 и 8904-378-16-61 не считая служебных";
        System.out.println(testText);
        
        List<String> phoneNumbers = extractPhoneNumbers(testText);
        
        System.out.println("\nНайденные номера телефонов:");
        for (int i = 0; i < phoneNumbers.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, phoneNumbers.get(i));
        }
    }
}
