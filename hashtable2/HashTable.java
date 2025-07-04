import java.util.LinkedList;
import java.util.List;

public class HashTable implements Table {
    private static class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private List<Entry>[] buckets;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = (LinkedList<Entry>[]) new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @Override
    public void put(String key, String value) {
        int index = getBucketIndex(key);
        for (Entry entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; 
                return;
            }
        }
        buckets[index].add(new Entry(key, value));
        size++;
    }

    @Override
    public String get(String key) {
        int index = getBucketIndex(key);
        for (Entry entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void remove(String key) {
        int index = getBucketIndex(key);
        List<Entry> bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }
}