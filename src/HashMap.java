import java.util.HashSet;
import java.util.Set;

/**
 * Created by ashwin on 24/8/17.
 */
public class HashMap<K, V> {

    private static int TABLE_SIZE = 32;
    private Entry[] table;
    private Set<Integer> set;

    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public HashMap() {
        table = new Entry[TABLE_SIZE];
        set = new HashSet<>();
    }

    /**
     * Custom hashmap where you can specify the modulus
     */
    public HashMap(int TABLE_SIZE) {
        this.TABLE_SIZE = TABLE_SIZE;
        table = new Entry[TABLE_SIZE];
        set = new HashSet<>();
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % TABLE_SIZE);
    }

    public V get(K key) {
        int index = hash(key);
        Entry curr = table[index];
        while (curr != null) {
            if (curr.getKey().equals(key)) {
                return (V) curr.getValue();
            }
            curr = curr.next;
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        Entry curr = table[hash];
        if (curr == null) {
            return null;
        }
        if (curr.getKey().equals(key)) {
            V temp = (V) curr.getValue();
            table[hash] = curr.next;
            return temp;
        }
        while (curr.next != null) {
            if (curr.next.getKey().equals(key)) {
                V temp = (V) curr.next.getValue();
                curr.next = curr.next.next;
                return temp;
            }
            curr = curr.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        set.add(hash);
        Entry curr = table[hash];
        if (curr == null) {
            table[hash(key)] = new Entry(key, value);
        } else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Entry(key, value);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int hash : set) {
            Entry entry = table[hash];
            while (entry != null) {
                K key = (K) entry.getKey();
                V value = (V) entry.getValue();
                if (sb.length() > 1) {
                    sb.append(", ");
                }
                sb.append(String.valueOf(key) + ": " + String.valueOf(value));

                entry = entry.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
