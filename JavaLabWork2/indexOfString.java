public class indexOfString {
    public static void main(String[] args) {
        String text = "hello World, hello Java, hello VMO, hello DSTU";
        String substringOfText = "hello";
        int count = 0;
        int index = text.indexOf(substringOfText);
        while (index != -1) {
            count++;
            index = text.indexOf(substringOfText, index + 1);
        }
        System.out.println("Подстрока " + substringOfText + " Встречается " + count);
    }
}
