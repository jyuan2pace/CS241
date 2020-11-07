public class BST<AnyType extends Comparable<AnyType>>
{
    private TreeNode root;
    
    public BST()
    {
        root = null;
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
    }

    //--------Your HW5 functions start here ---------------//
    public int height(){
        throw new UnsupportedOperationException();
    }

    public boolean isBalance() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object tree2) {
        throw new UnsupportedOperationException();
    }

    static BST<Integer> skewedTree(int n) {
        throw new UnsupportedOperationException();
    }
    static BST<Integer> balancedTree(int n) {
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

