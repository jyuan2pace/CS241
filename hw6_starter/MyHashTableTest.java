import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.NoSuchElementException;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyHashTableTest {
    @Test
    public void test1_delete() {
        MyHashTable<Integer> t = new MyHashTable<>();
        t.put(1);
        t.put(2);
        t.put(3);
        assertEquals("{numBuckets=10, buckets=[[], [1], [2], [3], [], [], [], [], [], []]}",t.toString());
        t.remove(3);
        assertEquals("{numBuckets=10, buckets=[[], [1], [2], [], [], [], [], [], [], []]}",t.toString());
    }

    @Test
    public void test2_rehash() {
        MyHashTable<Integer> t = new MyHashTable<>();
        t.put(1);
        t.put(2);
        t.put(3);
        t.put(4);
        assertEquals(10, t.getNumBuckets());
        //next add triggers rehash because the load balance is 0.5
        t.put(5);
        assertEquals(20, t.getNumBuckets());
        assertEquals("{numBuckets=20, buckets=[[], [1], [2], [3], [4], [5], [], [], [], [], [], [], [], [], [], [], [], [], [], []]}",
                t.toString());

    }

    @Test
    public void test3_search() {
        MyHashTable<Integer> t = new MyHashTable<>();
        t.put(1);
        t.put(2);
        t.put(3);
        t.put(4);
        assertTrue(t.contains(4));
        assertFalse(t.contains(5));
    }
}
