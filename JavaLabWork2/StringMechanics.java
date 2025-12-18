public class StringMechanics {
    public static void main(String[] args) {
        String text = "аваВАпарЫ823VL__?*";
        int letterCount = 0;
        int letterIsLowerCaseCount = 0;
        int letterIsUpperCaseCount = 0;
        int DigitCount = 0;
        int romanDigitCounts = 0;
        int otherCount = 0;
        String romanChars = "IVXLCDM";
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
                if (Character.isLowerCase(c)) {
                    letterIsLowerCaseCount++;
                } 
                else if (Character.isUpperCase(c)) {
                    letterIsUpperCaseCount++;
                }
            }
            else if (Character.isDigit(c)) {
                DigitCount++;
            }
            else if (romanChars.indexOf(c) != -1) {
                romanDigitCounts++;
            }
            else {
                otherCount++;
            }
        }
        System.out.println(text.length());
        System.out.println(letterCount);
        System.out.println(letterIsLowerCaseCount);
        System.out.println(letterIsUpperCaseCount);
        System.out.println(DigitCount);
        System.out.println(romanDigitCounts);
        System.out.println(otherCount);
    }
}
