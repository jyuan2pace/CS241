public class BST<AnyType extends Comparable<AnyType>>
{
    private TreeNode root;
    
    public BST()
    {
        root = null;
    }

    public BST(TreeNode root)
    {
        this.root = root;
    }

    public boolean isEmpty()
    {
        return root == null;
    }
    
    // initial add method, looking ahead
    public void add(AnyType value)
    {
        if (isEmpty())
            root = new TreeNode(value,null,null);
        else
            addHelper(root,value);
    }
    
    private void addHelper(TreeNode rt, AnyType value)
    {
        if (value.compareTo(rt.data) < 0)
            if (rt.left == null)
                rt.left = new TreeNode(value,null,null);
            else
                addHelper(rt.left,value);
        else if (value.compareTo(rt.data) > 0)
            if (rt.right == null)
                rt.right = new TreeNode(value,null,null);
            else
                addHelper(rt.right,value);
        else
            throw new IllegalStateException("duplicate value in tree " + value);
    }
    
    // a cleaner, more compact add method
    public void add2(AnyType value)
    {
        root = addHelper2(root,value);
    }
    
    private TreeNode addHelper2(TreeNode rt, AnyType value)
    {
        if (rt == null)
            return new TreeNode(value,null,null);
        
        if (value.compareTo(rt.data) < 0)
            rt.left = addHelper2(rt.left,value);
        else if (value.compareTo(rt.data) > 0)
            rt.right = addHelper2(rt.right,value);
        else
            throw new IllegalStateException("duplicate value in tree " + value);
        
        return rt;  // returns the changed (and unchanged) rt's since
        // you have to (re-)assign values all the way back up the call stack!
    }
            
    public void inOrder()
    {
        inOrder(root);
    }
    
    private void inOrder(TreeNode rt)
    {
        if (rt != null)
        {
            inOrder(rt.left);
            System.out.print(rt.data + " ");
            inOrder(rt.right);
        }
    }
    
    public void preOrder()
    {
        preOrder(root);
    }
    
    private void preOrder(TreeNode rt)
    {
        if (rt != null)
        {
            System.out.print(rt.data + " ");
            preOrder(rt.left);
            preOrder(rt.right);
        }
    }
    
    public int size()
    {
        return size(root);
    }
    
    private int size(TreeNode rt)
    {
        if (rt == null)
            return 0;
        return 1 + size(rt.left) + size(rt.right);
    }
    
    public boolean contains(AnyType value)
    {
        TreeNode rt = root;
        while (rt != null)
        {
            if (value.compareTo(rt.data) == 0)
                return true;
            else if (value.compareTo(rt.data) < 0)
                rt = rt.left;
            else
                rt = rt.right;
        }
        return false;
    }

    // returns a String that prints tree top to bottom, right to left in a 90-degree rotated level view
    public String toString()
    {
        StringBuilder result =  new StringBuilder();
        return toString(result,-1,root).toString();
    }
    
    public StringBuilder toString(StringBuilder res, int height, TreeNode rt)
    {
        if (rt != null)
        {
            height++;
            res = toString(res,height,rt.right);
            for (int i = 0; i < height; i++)
                res.append("\t");
            res.append(rt.data + "\n");
            res = toString(res,height,rt.left);
        }
        return res;
    }
    
    // the TreeNode class is a private inner class used (only) by the BST class
    private class TreeNode
    {
        private AnyType data;
        private TreeNode left, right;
        
        private TreeNode(AnyType data, TreeNode left, TreeNode right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        private TreeNode(TreeNode node) {
            this.data = node.data;
            this.left = node.left;
            this.right = node.right;
        }
    }

    //--------Your HW5 functions start here ---------------//
    private int height_helper(TreeNode n) {
        // TODO: your code here
        // base condition: empty tree
        // recursively solves the height of the left child subtree
        // and the height of the right child subtree, when combining
        // results from subtrees, if height_left_child is greater
        // than height_right_child, what is the height of the current node?
        throw new UnsupportedOperationException();
    }
    public int height(){
        //TODO: your code here
        //hint: implement helper height_helper(TreeNode root);
        throw new UnsupportedOperationException();
    }

    public boolean isBalance(){
        //TODO: your code here
        //hint: if we declare helper
        //boolean isBalanced_helper(TreeNode subtree);
        //the helper can return a boolean value to indicate if a subtree
        //is balanced, but we also need the heights of its left subtree and
        //right subtree so we can compare to determine if it is balanced.
        //how can we get two return values in one function call?
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object tree2) {
        //TODO: your code here
        //hint: implement private boolean equals_helper(TreeNode n1, TreeNode n2)
         throw new UnsupportedOperationException();
    }

    public BST<AnyType> mirrorTree(){
        //TODO: your code here
        //hint: implement private TreeNode mirrorTree(TreeNode node)
        throw new UnsupportedOperationException();
    }

    static public BST<Integer> skewedTree(int n) {
        //TODO: your code here
        //hint: to measure time, use System.nanoTime();
        //to capture start time and end time.
        throw new UnsupportedOperationException();
    }

    static public BST<Integer> balancedTree(int n) {
        //TODO: your code here
        //hint: the only difference from skewedTree is the order of
        //insertion. implement the insertion function:
        //static private void seqinsert(BST<Integer> tree, int low, int high)
        //following pseudo code in the hw5 document, which means
        // if you have input 7, and thus you have a sequence of number
        //1,2,3,4,5,6,7 then the insertion order is
        //4,2,1,3,6,5,7 which creates a balanced BST.
        throw new UnsupportedOperationException();
    }
    //--------Your HW5 fundtions end here ------------------//
    public static void main(String[] args)
    {
        BST<Integer> treeTest = new BST<Integer>();
        treeTest.add2(7);
        treeTest.add2(5);
        treeTest.add2(4);
        treeTest.add2(10);
        treeTest.add2(6);
        treeTest.add2(8);
        treeTest.inOrder();
        System.out.println();
        treeTest.preOrder();
        System.out.println(treeTest.size());
        System.out.println();
        System.out.println(treeTest.contains(6));
        System.out.println(treeTest.contains(112));
        System.out.println(treeTest.contains(7));
        System.out.println(treeTest.contains(10));
        System.out.println();
        System.out.println(treeTest);
    }
    
}

