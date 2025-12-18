package lab5.task09to10_hashtable;

public class PersonHashFunction extends HashFunction<String> {

    public PersonHashFunction(int tableSize) {
        super(tableSize);
    }

    @Override
    protected int hash(String key) {
        int sum = 0;
        for (char ch : key.toCharArray()) {
            sum += ch;
        }
        return sum;
    }
}
