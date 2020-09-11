package intlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedIntListTest {

    /** square: test 3-integer list functionality. */
    @Test
    public void testSquare() {
        LinkedIntList L = new LinkedIntList(1, 2, 3);
        LinkedIntList.square(L);
        assertEquals(new LinkedIntList(1, 4, 9), L);
    }

    /** firstToLast: test empty list functionality. */
    @Test
    public void testEmptyFirstToLast() {
        LinkedIntList L = new LinkedIntList();
        LinkedIntList.firstToLast(L);
        assertEquals(new LinkedIntList(), L);
    }

    /** firstToLast: test 1-integer list functionality. */
    @Test
    public void test1IntegerFirstToLast() {
        LinkedIntList L = new LinkedIntList(42);
        LinkedIntList.firstToLast(L);
        assertEquals(new LinkedIntList(42), L);
    }

    /** firstToLast: test 2-integer list functionality. */
    @Test
    public void test2IntegerFirstToLast() {
        LinkedIntList L = new LinkedIntList(42, 99);
        LinkedIntList.firstToLast(L);
        assertEquals(new LinkedIntList(99, 42), L);
    }

    /** firstToLast: test general functionality. */
    @Test
    public void testFirstToLast() {
        LinkedIntList L = new LinkedIntList(18, 4, 27, 9, 54, 5, 63);
        LinkedIntList.firstToLast(L);
        assertEquals(new LinkedIntList(4, 27, 9, 54, 5, 63, 18), L);
    }

    /** firstToLast: test duplicates in list. */
    @Test
    public void testDuplicatesFirstToLast() {
        LinkedIntList L = new LinkedIntList(3, 7, 3, 3);
        LinkedIntList.firstToLast(L);
        assertEquals(new LinkedIntList(7, 3, 3, 3), L);
    }

    /** extend: test general functionality. */
    @Test
    public void testExtend() {
        LinkedIntList A = new LinkedIntList(1, 2, 3);
        LinkedIntList B = new LinkedIntList(4, 5, 6);

        LinkedIntList exp = new LinkedIntList(1, 2, 3, 4, 5, 6);
        LinkedIntList.extend(A, B);
        assertEquals(exp, A);

        assertEquals(new LinkedIntList(4, 5, 6), B);
    }

    /** extend: test empty list functionality. */
    @Test
    public void testEmptyExtend() {
        LinkedIntList A = new LinkedIntList(1, 2, 3);
        LinkedIntList B = new LinkedIntList();
        LinkedIntList exp = new LinkedIntList(1, 2, 3);

        LinkedIntList.extend(A, B);
        assertEquals(exp, A);
        assertEquals(new LinkedIntList(), B);

        A = new LinkedIntList();
        B = new LinkedIntList(1, 2, 3);
        LinkedIntList.extend(A, B);
        assertEquals(exp, A);
        assertEquals(exp, B);
    }

    /** concatenated: test general functionality. */
    @Test
    public void testConcatenated() {
        LinkedIntList A = new LinkedIntList(1, 2, 3);
        LinkedIntList B = new LinkedIntList(4, 5, 6);

        LinkedIntList exp = new LinkedIntList(1, 2, 3, 4, 5, 6);
        LinkedIntList res = LinkedIntList.concatenated(A, B);
        assertEquals(exp, res);

        assertEquals(new LinkedIntList(1, 2, 3), A);
    }

    /** concatenated: test empty list functionality. */
    @Test
    public void testEmptyConcatenated() {
        assertEquals(new LinkedIntList(), LinkedIntList.concatenated(new LinkedIntList(), new LinkedIntList()));

        LinkedIntList A = new LinkedIntList(1, 2, 3);
        LinkedIntList exp = new LinkedIntList(1, 2, 3);
        assertEquals(exp, LinkedIntList.concatenated(new LinkedIntList(), A));
        assertEquals(exp, LinkedIntList.concatenated(A, new LinkedIntList()));

        assertEquals(exp, A);
    }
}
