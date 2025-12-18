public class UndicodeTable {

    public static void printUnicodeTable(int startCode, int rows, int cols) {
        System.out.print("   ");
        for (int i = 0; i < cols; i++){
            System.out.printf("%x ", i);
        }
        System.out.println();
        int code = startCode;
        for (int i = 0; i < rows; i++){
            System.out.printf("%x ", startCode + i * cols);
            for (int j = 0; j < cols; j ++){
                System.out.print((char)code + " ");
                code ++;
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        System.out.println("Кириллица:");
        printUnicodeTable(0x0400, 16, 16);
        System.out.println("\nЗнаки денежных единиц:");
        printUnicodeTable(0x20A0, 2, 16);
    }
}
