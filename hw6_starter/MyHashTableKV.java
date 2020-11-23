import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashTableKV<T1 extends Comparable<T1> , T2> {
    private class Pair {
        private T1 key;
        private T2 value;
        public Pair(T1 key, T2 value) {
            this.key = key;
            this.value = value;
        }
    }
    private int numBuckets = 10;
    private ArrayList<Pair>[] buckets;
    private int count = 0;
    public MyHashTableKV() {
        //TODO: your code here
        throw new UnsupportedOperationException();
    }

    public void put(T1 key,  T2 value) {
        //TODO: your code here
        throw new UnsupportedOperationException();
    }

    public boolean contains(T1 key) {
        //TODO: your code here
        throw new UnsupportedOperationException();
    }

    public T2 get(T1 key) {
        //TODO: your code here
        throw new UnsupportedOperationException();
    }

    private void rehash() {
        //TODO: your code here
        throw new UnsupportedOperationException();
    }

    public void remove(T1 key) {
        //TODO: your code here
        throw new UnsupportedOperationException();
    }

    public int getNumBuckets () {
        return numBuckets;
    }

    @Override
    public String toString() {
        return "{" +
                "numBuckets=" + numBuckets +
                ", buckets=" + Arrays.toString(buckets) +
                '}';
    }
}
