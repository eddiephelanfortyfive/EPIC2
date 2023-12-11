//import java.util.LinkedList;
public class HashMap {
    class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public class MyHashMap<K, V> {
        private static final int DEFAULT_CAPACITY = 16;
        private final LinkedList<Entry<K, V>>[] buckets;
        private int size;

        public MyHashMap() {
            this(DEFAULT_CAPACITY);
        }

        public MyHashMap(int capacity) {
            buckets = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                buckets[i] = new LinkedList<>();
            }
            size = 0;
        }

        private int hash(K key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        public void put(K key, V value) {
            int index = hash(key);
            LinkedList<Entry<K, V>> bucket= buckets[index];
            bucket.moveToFirst();
            for (int i = 0; i < bucket.size(); i++) {
                Entry<K, V> entry = bucket.getData();
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                bucket.moveToNext();
            }
            bucket.insert(new Entry<>(key, value));
            size++;
        }

        public V get(K key) {
            int index = hash(key);
            LinkedList<Entry<K, V>> bucket = buckets[index];
            bucket.moveToFirst();
            for (int i = 0; i < bucket.size(); i++) {
                Entry<K, V> entry = bucket.getData();
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                bucket.moveToNext();
            }

            return null;
        }

        public void remove(K key) {
            int index = hash(key);
            LinkedList<Entry<K, V>> bucket = buckets[index];
            Entry<K, V> entryToRemove = null;
            bucket.moveToFirst();
            for (int i = 0; i < bucket.size(); i++) {
                Entry<K, V> entry = bucket.getData();
                if (entry.key.equals(key)) {
                    entryToRemove = entry;
                    break;
                }
                bucket.moveToNext();
            }

            if (entryToRemove != null) {
                bucket.remove(entryToRemove);
                size--;
            }
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
