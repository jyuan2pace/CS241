import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedIntListTest {
    @Test
    public void testEmptyAdd() {
        LinkedIntList L = new LinkedIntList();
        L.add(5);
        assertEquals(new LinkedIntList(5), L);
    }

    @Test
    public void testGeneralAdd() {
        LinkedIntList L = new LinkedIntList(1,2,3);
        L.add(4);
        assertEquals(new LinkedIntList(1,2,3,4), L);
    }
    @Test
    public void testEmptyGetByIndex() {
        LinkedIntList L = new LinkedIntList();
        try {
            L.getByIndex(0);
        } catch (IndexOutOfBoundsException e){
            assertEquals(new LinkedIntList(), L);
            return;
        }
        assert (false);
    }

    @Test
    public void testHeadGetByIndex() {
        LinkedIntList L = new LinkedIntList(1);
        int x = L.getByIndex(0);
        assertEquals(1, x);
    }
    @Test
    public void testGeneralGetByIndex() {
        LinkedIntList L = new LinkedIntList(1,2,3,4,5);
        int x = L.getByIndex(3);
        assertEquals(4, x);
    }

    @Test
    public void testOutOfBoundGetByIndex() {
        LinkedIntList L = new LinkedIntList(1, 2, 3);
        try {
            L.getByIndex(-1);
        } catch (IndexOutOfBoundsException e){
            assertEquals(new LinkedIntList(1,2,3), L);
            try {
                L.getByIndex(3);
            } catch (IndexOutOfBoundsException e2){
                assertEquals(new LinkedIntList(1,2,3), L);
                return;
            }
        }
        assert(false);
    }
    @Test
    public void testEmptyRemoveByIndex() {
        LinkedIntList L = new LinkedIntList();
        try {
            L.removeByIndex(0);
        } catch (IndexOutOfBoundsException e){
            assertEquals(new LinkedIntList(), L);
            return;
        }
        assert (false);
    }

    @Test
    public void testHeadRemoveByIndex() {
        LinkedIntList L = new LinkedIntList(1);
        try {
            L.removeByIndex(0);
        } catch (IndexOutOfBoundsException e){
            assert(false);
        }
        assertEquals(new LinkedIntList(), L);
    }
    @Test
    public void testMiddleRemoveByIndex() {
        LinkedIntList L = new LinkedIntList(1, 2, 3, 4);
        try {
            L.removeByIndex(2);
        } catch (IndexOutOfBoundsException e){
            assert(false);
        }
        assertEquals(new LinkedIntList(1, 2, 4), L);
    }

    @Test
    public void testOutOfBoundRemoveByIndex() {
        LinkedIntList L = new LinkedIntList(1, 2, 3);
        try {
            L.removeByIndex(-1);
        } catch (IndexOutOfBoundsException e){
            assertEquals(new LinkedIntList(1,2,3), L);
            try {
                L.removeByIndex(3);
            } catch (IndexOutOfBoundsException e2){
                assertEquals(new LinkedIntList(1,2,3), L);
                return;
            }
        }
        assert(false);
    }
    @Test
    public void testEmptyContains() {
        LinkedIntList L = new LinkedIntList();
        boolean x = L.contains(5);
        assertEquals(false, x);
    }

    @Test
    public void testPositiveContains() {
        LinkedIntList L = new LinkedIntList(1, 2, 3);
        boolean x = L.contains(1);
        assertEquals(true, x);
        x = L.contains(2);
        assertEquals(true, x);
        x = L.contains(3);
        assertEquals(true, x);
    }
    @Test
    public void testNegativeContains() {
        LinkedIntList L = new LinkedIntList(1, 2, 3);
        boolean x = L.contains(-1);
        assertEquals(false, x);
    }

    @Test
    public void testEmptyDedup() {
        LinkedIntList L = new LinkedIntList();
        LinkedIntList.dedup(L);
        assertEquals(new LinkedIntList(), L);
    }

    @Test
    public void testSimpleDedup() {
        LinkedIntList L = new LinkedIntList(1,1,1);
        LinkedIntList.dedup(L);
        assertEquals(new LinkedIntList(1), L);
    }

    @Test
    public void testSortedDedup() {
        LinkedIntList L = new LinkedIntList(1, 2, 2, 2, 3, 3);
        LinkedIntList.dedup(L);
        assertEquals(new LinkedIntList(1, 2, 3), L);
    }

    @Test
    public void testGeneralDedup() {
        LinkedIntList L = new LinkedIntList(2, 2, 1, 1, 1, 2, 1, 3, 1);
        LinkedIntList.dedup(L);
        assertEquals(new LinkedIntList(2, 1, 3), L);
    }
}
