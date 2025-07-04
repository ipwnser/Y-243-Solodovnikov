import java.util.HashMap;

public class HashTable implements Table {
    private HashMap<String, String> table = new HashMap<>();
    @Override
    public void put(String key, String value) {
        table.put(key, value);
    }

    @Override
    public String get(String key) {
        return table.get(key);
    }

    @Override
    public void remove(String key) {
        table.remove(key);
    }

    @Override
    public int size() {
        return table.size();
    }
}
