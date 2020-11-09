import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.NoSuchElementException;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BSTTest {
    @Test
    public void test1_HeightEmpty()
    {
        BST<Integer> tree = new BST<>();
        assertEquals(-1, tree.height());
    }

    @Test
    public void test2_HeightSingleNode()
    {
        BST<Integer> tree = new BST<>();
        tree.add(0);
        assertEquals(0, tree.height());
    }

    @Test
    public void test3_HeightMoreNodes()
    {
        BST<Integer> tree = new BST<>();
        tree.add(2);
        tree.add(1);
        assertEquals(1, tree.height());
        tree.add(3);
        assertEquals(1, tree.height());
        tree.add(4);
        assertEquals(2, tree.height());
        tree.add(5);
        assertEquals(3, tree.height());
    }
    @Test
    public void test4_IsBalancedEmpty() {
        BST<Integer> tree = new BST<>();
        assertEquals(true, tree.isBalance());
    }

    @Test
    public void test5_IsBalancedSingle() {
        BST<Integer> tree = new BST<>();
        tree.add(3);
        assertEquals(true, tree.isBalance());
    }

    @Test
    public void test6_IsBalancedMore() {
        BST<Integer> tree = new BST<>();
        tree.add(2);
        tree.add(1);
        assertEquals(true, tree.isBalance());
        tree.add(3);
        assertEquals(true, tree.isBalance());
        tree.add(4);
        assertEquals(true, tree.isBalance());
        tree.add(5);
        assertEquals(false, tree.isBalance());
    }

    @Test
    public void test7_EqualsEmpty() {
        BST<Integer> tree1 = new BST<>();
        BST<Integer> tree2 = new BST<>();
        assertEquals(true, tree1.equals(tree2));
    }

    @Test
    public void test7_EqualsSingle() {
        BST<Integer> tree1 = new BST<>();
        tree1.add(1);
        BST<Integer> tree2 = new BST<>();
        tree2.add(1);
        BST<Integer> tree3 = new BST<>();
        tree3.add(3);

        assertEquals(true, tree1.equals(tree2));
        assertEquals(false, tree1.equals(tree3));
    }

    @Test
    public void test8_EqualsMore() {
        BST<Integer> tree1 = new BST<>();
        tree1.add(1);
        BST<Integer> tree2 = new BST<>();
        tree2.add(1);
        assertEquals(true, tree1.equals(tree2));
        tree1.add(4);
        tree2.add(0);
        assertEquals(false, tree1.equals(tree2));
        tree1.add(0);
        tree2.add(4);
        assertEquals(true, tree1.equals(tree2));
        tree1.add(5);
        tree2.add(3);
        assertEquals(false, tree1.equals(tree2));
        tree2.add(5);
        tree1.add(3); //enough depth to test recursion
        assertEquals(true, tree1.equals(tree2));
    }
    @Test
    public void test9_MirrorEmpty() {
        BST<Integer> tree = new BST<>();
        BST<Integer> mirror = tree.mirrorTree();
        assertEquals(-1, mirror.height());
    }

    @Test
    public void test10_MirrorSingle() {
        BST<Integer> tree1 = new BST<>();
        tree1.add(1);
        BST<Integer> mirror = tree1.mirrorTree();
        assertEquals(true, tree1.equals(mirror));
    }

    @Test
    public void test11_MirrorMore() {
        BST<Integer> tree1 = new BST<>();
        tree1.add(4);
        tree1.add(2);
        tree1.add(6);
        tree1.add(3);
        tree1.add(5);
        tree1.add(7);
        //tree looks like
        //            4
        //          /   \
        //        2      6
        //         \    / \
        //         3   5   7
        // the mirror would be:
        //            4
        //          /   \
        //        6      2
        //       / \    /
        //      7  5   3
        BST<Integer> mirror = tree1.mirrorTree();
        //You can uncomment the next line to print out mirror tree for debugging purpose
        //System.out.println(mirror);
        assertEquals("\t2\n\t\t3\n4\n\t\t5\n\t6\n\t\t7\n", mirror.toString());
    }

    @Test
    public void test12_SkewedTree() {
        BST<Integer> bst = BST.skewedTree(6);
        assertEquals(5, bst.height());
        BST<Integer> bst2 = BST.skewedTree(15);
        assertEquals(14, bst2.height());
    }

    @Test
    public void test_BalancedTree() {
        BST<Integer> bst = BST.balancedTree(6);
        assertEquals(2, bst.height());
        BST<Integer> bst2 = BST.balancedTree(15);
        assertEquals(3, bst2.height());
    }
}
