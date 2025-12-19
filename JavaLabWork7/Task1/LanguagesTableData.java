package Task1;

public final class LanguagesTableData {

    private LanguagesTableData() {}

    public static String[] columns() {
        return new String[]{"Язык", "Автор", "Год"};
    }

    public static String[][] rows() {
        return new String[][]{
                {"C",          "Деннис Ритчи",        "1972"},
                {"C++",        "Бьерн Страуструп",    "1983"},
                {"Python",     "Гвидо ван Россум",    "1991"},
                {"Java",       "Джеймс Гослинг",      "1995"},
                {"JavaScript", "Брендон Айк",         "1995"},
                {"C#",         "Андерс Хейлсберг",    "2001"},
                {"Scala",      "Мартин Одерски",      "2003"}
        };
    }
}
