import java.util.regex.Pattern;

public class PhoneNumberChecker {

    private static final String FEDERAL_REGEX =
            "^(\\+7|8)[ -]?(\\([0-9]{3}\\)|[0-9]{3})[ -]?[0-9]{3}[ -]?[0-9]{2}[ -]?[0-9]{2}$";

    private static final String MUNICIPAL_REGEX =
            "[23][ -]?[0-9]{2}[ -]?[0-9]{2}[ -]?[0-9]{2}";

    private static final Pattern federal = Pattern.compile(FEDERAL_REGEX);
    private static final Pattern municipal = Pattern.compile(MUNICIPAL_REGEX);

    public static boolean isFederal(String phone) {
        return federal.matcher(phone).matches();
    }

    public static boolean hasMunicipal(String text) {
        return municipal.matcher(text).find();
    }

    public static void main(String[] args) {

        String[] federalSamples = {
                "+79181234567",
                "+7 918 123 45 67",
                "+7-918-123-45-67",
                "+7(918)1234567",
                "89181234567",
                "8 918 123-45-67",
                "79181234567",
                "+7(9181)234567",
                "+7 918 123 456",
                "8-918-123-45-678"
        };

        System.out.println("Проверка федеральных номеров:");
        for (String phone : federalSamples) {
            System.out.printf("%-22s -> %s%n",
                    phone,
                    isFederal(phone) ? "ВЕРНО" : "НЕВЕРНО");
        }

        String[] municipalSamples = {
                "Офисные телефоны: 223-45-67, 8918-123-45-67",
                "Позвоните по номеру 2 34 56 78",
                "Внутренний номер 345678",
                "Контактный телефон: 234-56-78",
                "Ошибка в номере 145-56-78",
                "Не подходит номер 456-12-34"
        };

        System.out.println("\nПроверка муниципальных номеров:");
        for (String text : municipalSamples) {
            System.out.printf("%-35s -> %s%n",
                    text,
                    hasMunicipal(text) ? "Найден" : "Не найден");
        }
    }
}
