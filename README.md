# Binary-Tree

Class Name
BinaryTree
Data fields
 private Item data; 
 private BinaryTree<Item> left;
 private BinaryTree<Item> right;


Constructors (three constructors)
 public BinaryTree ()
 public BinaryTree (Item data)
 public BinaryTree (Item data, BinaryTree<Item> left, ￼￼￼BinaryTree<Item> right)


￼￼￼￼Methods:
￼￼￼ public Item getData() // return the data
 public BinaryTree<Item> getLeft() // return the reference
to the left child.
 public BinaryTree<Item> getRight() // return the reference
to the right child.
 public void setData(Item data) // set the data to be data.
 public void setLeft(BinaryTree<Item> left) // set the left
reference.
 public void setRight(BinaryTree<Item> right) // set the
right reference.
 public boolean isLeaf() // whether this binary tree (node)
is a leaf node or not.
 public int getHeight() // return the height of this tree.
 public int size() // return the size of this tree.
 public int leafCount() // return the number of leaf nodes in
this tree.
 public String levelOrder() // return a string representing
the sequence of nodes’ data when we traverse this tree in
level-order.
 public String preOrder() // return a string representing the
sequence of nodes’ data when we traverse this tree in pre-
order.
 public String inOrder() // return a string representing the
sequence of nodes’ data when we traverse this tree in in-
order
 public String postOrder() // return a string representing
the sequence of nodes’ data when we traverse this tree in
post-order.
 public int nodeSum() // return the sum of each node’s data
in this tree.
 public int maxPathSum() // a path sum is the sum of
nodes’ data along a path of this tree. Find that greatest
sum.
 public static boolean isMirror(BinaryTree root1, BinaryTree ￼￼root2) // check to see whether two binary trees rooted at root1 and root2 respectively are mirrors of each other.*
