import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedIntListTest {
    @Test
    public void testEmptyAdd() {
        LinkedIntList L = new LinkedIntList();
        L.add(0,5);
        assertEquals(new LinkedIntList(5), L);
    }

    @Test
    public void testGeneralAddMiddle() {
        LinkedIntList L = new LinkedIntList(1,2,4);
        L.add(2,3);
        assertEquals(new LinkedIntList(1,2,3,4), L);
    }

    @Test
    public void testGeneralAddFront() {
        LinkedIntList L = new LinkedIntList(1,2,3);
        L.add(0,0);
        assertEquals(new LinkedIntList(0,1,2,3), L);
    }

    @Test
    public void testGeneralAddEnd() {
        LinkedIntList L = new LinkedIntList(1,2,3);
        L.add(3,4);
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
    public void testEmptyRemoveByValue() {
        LinkedIntList L = new LinkedIntList();
        try {
            L.removeByValue(0);
        } catch (NoSuchElementException e){
            assertEquals(new LinkedIntList(), L);
            return;
        }
        assert (false);
    }

    @Test
    public void testHeadRemoveByValue() {
        LinkedIntList L = new LinkedIntList(1,2,3);
        try {
            L.removeByValue(1);
        } catch (NoSuchElementException e){
            assert(false);
        }
        assertEquals(new LinkedIntList(2,3), L);
    }
    @Test
    public void testMiddleRemoveByValue() {
        LinkedIntList L = new LinkedIntList(1, 2, 3, 4);
        try {
            L.removeByValue(2);
        } catch (IndexOutOfBoundsException e){
            assert(false);
        }
        assertEquals(new LinkedIntList(1, 3, 4), L);
    }

    @Test
    public void testReverseInPlaceEmpty() {
        LinkedIntList L = new LinkedIntList();
        L.reverseInPlace();
        assertEquals(new LinkedIntList(), L);
    }

    @Test
    public void testReverseInPlaceSingle() {
        LinkedIntList L = new LinkedIntList(99);
        L.reverseInPlace();
        assertEquals(new LinkedIntList(99), L);
    }
    @Test
    public void testReverseInPlaceEven() {
        LinkedIntList L = new LinkedIntList(1, 2, 3, 4);
        L.reverseInPlace();
        assertEquals(new LinkedIntList(4, 3, 2,1), L);
    }

    @Test
    public void testReverseInPlaceOdd() {
        LinkedIntList L = new LinkedIntList(1, 2, 3, 4, 5, 6, 7);
        L.reverseInPlace();
        assertEquals(new LinkedIntList(7, 6, 5, 4, 3, 2, 1), L);
    }

    @Test
    public void testSortedAddEmpty() {
        LinkedIntList L = new LinkedIntList();
        L.sortedAdd(1);
        assertEquals(new LinkedIntList(1), L);
    }

    @Test
    public void testSortedAddHead() {
        LinkedIntList L = new LinkedIntList(2,3,4);
        L.sortedAdd(1);
        assertEquals(new LinkedIntList(1,2,3,4), L);
    }

    @Test
    public void testSortedAddMiddle() {
        LinkedIntList L = new LinkedIntList(1,2,4,5);
        L.sortedAdd(3);
        assertEquals(new LinkedIntList(1,2,3,4,5), L);
    }

    @Test
    public void testSortedAddEnd() {
        LinkedIntList L = new LinkedIntList(1,2,3);
        L.sortedAdd(4);
        assertEquals(new LinkedIntList(1,2,3,4), L);
    }
}
