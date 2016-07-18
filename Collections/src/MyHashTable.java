
/**
 * Created by azburatura on 7/18/2016.
 */
public class MyHashTable<K, V> {
    private final static int TABLE_SIZE = 128;

    HashEntry[] table;

    MyHashTable() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public Penguin get(int key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return null;
        else
            return table[hash].getValue();
    }

    public void put(int key, Penguin value) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new HashEntry(key, value);
    }


    public static void main(String[] args){
        PenguinHatchery penguinHatchery = new PenguinHatchery();
        MyHashTable<String, Penguin> penguinMyHashTable = new MyHashTable<String, Penguin>();
        penguinMyHashTable.put(1, penguinHatchery.hatchPenguin());
        System.out.println(penguinMyHashTable.get(1));

    }
}


class HashEntry{
    private int key;
    private Penguin value;

    HashEntry(int key, Penguin value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public Penguin getValue() {
        return value;
    }
}

