import java.util.List;
import java.util.ArrayList;
import edu.princeton.cs.algs4.*;

public class BinaryTree<Item> {
    private Item data;
    private BinaryTree<Item> left, right;
    private int size;
    
    public BinaryTree(){
        this.data=null;
        this.left=null;
        this.right=null;
    }
    
    public BinaryTree(Item data){
        this.data=data;
        this.left=null;
        this.right=null;
        size++;
    }
    
    public BinaryTree(Item data, BinaryTree<Item> left, BinaryTree<Item> right){
        this.data=data;
        this.left=left;
        this.right=right;
        size++;
    }
    
    //Setters
    public void setData(Item data){
        this.data=data;
    }
    public void setLeft(BinaryTree<Item> left){
        this.left=left;
    }
    public void setRight(BinaryTree<Item> right){
        this.right=right;
    }
    
    public int getHeight(){  
        if (isLeaf())
            return 0;
        else {
            if (this.left!=null && this.right!=null) {
                return 1 + Math.max(left.getHeight(), right.getHeight());
            } 
            else {
                if (this.left!=null) return 1+this.left.getHeight();
                else return 1+this.right.getHeight();
            }
        }
    }
    
    public boolean isLeaf(){
        return this.left==null && this.right==null;
    }
    
    public String preOrder(){  // root-left-right
        if (isLeaf()) {
            return data.toString();
        }
        else {
            if (this.left!=null && this.right!=null) 
                return  this.data.toString() + " " + this.left.preOrder() + " " +this.right.preOrder();
            else {
                if (this.left!=null) return this.data.toString() + " " + this.left.preOrder();
                else return  this.data.toString() + " " + this.right.preOrder();
            }
        }
    }
    
    public Item getData() {
        return data;
    }
    
    public BinaryTree<Item> getLeft() {
        return left;
    }
    public BinaryTree<Item> getRight(){ 
        return right;
    }
    
    public int size() {
        return size; 
        
    }
    
    public int leafCount() {
        if (isLeaf())
            return 1;
        else {
            if (this.left!=null && this.right!=null) {
                return  (left.leafCount() + right.leafCount());
            } 
            else {
                if (this.left!=null) return this.left.leafCount();
                else return  this.right.leafCount();
            }
        }
        
    }
    
    public String levelOrder() {
        String ans = "";
        Queue<BinaryTree<Item>> helper = new Queue<BinaryTree<Item>>();
        helper.enqueue(this);
        
        while (!helper.isEmpty()){
            BinaryTree tree = helper.dequeue();
            ans += "" + tree.data.toString() + " ";
            
            if (tree.left != null) helper.enqueue(tree.left);
            if (tree.right != null) helper.enqueue(tree.right);
        }
        return ans;
        
    }
    
    public String inOrder() {
        if (isLeaf()) {
            return data.toString();
        }
        else {
            if (this.left!=null && this.right!=null) 
                return  this.left.inOrder() + " " + this.data.toString() +  " " +this.right.inOrder();
            else {
                if (this.left!=null) return " " + this.left.inOrder() + " " +  this.data.toString();
                else return  this.data.toString() + " " + this.right.inOrder();
            }
        }
        
    }
    public String postOrder() {
        if (isLeaf()) {
            return data.toString();
        }
        else {
            if (this.left!=null && this.right!=null) 
                return  this.left.postOrder() + " " +this.right.postOrder() + " " +this.data.toString();
            else 
                if (this.left!=null) return this.left.postOrder() + " " +  this.data.toString();
            else return  this.right.postOrder() + " " + this.data.toString();
        }
    }
    
    public int nodeSum() {
        if (isLeaf()) {
            return Integer.valueOf(data.toString());
        }
        else {
            if (this.left!=null && this.right!=null) 
                return  this.left.nodeSum() + this.right.nodeSum() + Integer.valueOf(data.toString());
            else 
                if (this.left!=null) return this.left.nodeSum() +  Integer.valueOf(data.toString());
            else return  this.right.nodeSum() +  Integer.valueOf(data.toString());
        }
    }
    public int maxPathSum() {
        if (isLeaf()) {
            return Integer.valueOf(data.toString());
        }
        else {
            if (this.left!=null && this.right!=null) 
                return Integer.valueOf(data.toString()) + Math.max(this.left.maxPathSum(), this.right.maxPathSum());
            else 
                if (this.left!=null) return Integer.valueOf(data.toString()) + this.left.maxPathSum();
            else return Integer.valueOf(data.toString()) + this.right.maxPathSum();
        }
    }
    
public static boolean isMirror(BinaryTree root1, BinaryTree root2) {
    if (root1.isLeaf() && root2.isLeaf() && Integer.valueOf(root1.data.toString()) == Integer.valueOf(root2.data.toString())) return true;
    else if (root1.left != null && root1.right != null && root2.left !=null && root2.right != null) {
       if (root1.left != root2.right || root1.right != root2.left) return false;
       else return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);      
    }
    else if (root1.left == null && root1.right != null && root2.left !=null && root2.right != null ) {
        return isMirror(root1.right, root2.left);
    }
    else if (root1.left != null && root1.right == null && root2.left !=null && root2.right != null) {
        return isMirror(root1.left, root2.right);
    }
    else if (root1.left != null && root1.right != null && root2.left ==null && root2.right != null) {
        return isMirror(root2.right, root1.left);
    }
    else if (root1.left != null && root1.right != null && root2.left !=null && root2.right == null) {
        return isMirror(root1.right, root2.left);
    }
    else if (root1.left == null && root1.right == null && root2.left !=null && root2.right != null) {
        return true;
    }
    else if (root1.left != null && root1.right != null && root2.left ==null && root2.right == null) {
        return true;
    }
    else if (root1.left == null && root1.right != null && root2.left ==null && root2.right != null) {
        return true;
    }
    else if (root1.left != null && root1.right == null && root2.left !=null && root2.right == null) {
        return true;
    }
    else if(root1.left == null && root1.right != null && root2.left !=null && root2.right == null) {
        return isMirror(root1.right, root2.left);
}
    else if (root1.left != null && root1.right == null && root2.left ==null && root2.right != null) {
        return isMirror(root1.left,root2.right);
    }
    else if (root1.left == null && root1.right == null && root2.left ==null && root2.right == null) {
        return true;
    }
    else if (root1.left != null && root1.right == null && root2.left ==null && root2.right == null) {
        return true;
    }
    else if (root1.left == null && root1.right != null && root2.left ==null && root2.right == null) {
        return true;
    }
    else if (root1.left == null && root1.right == null && root2.left !=null && root2.right == null) {
        return true;
    }
    else if (root1.left == null && root1.right == null && root2.left ==null && root2.right != null) {
        return true;
    }
    else return false;
}
        
        
 
    public static void main(String[] args){
        /** The following codes can construct a binary tree based upon a given array. The array index can
          * be used to identify parent nodes and children's nodes, and their relationship can be described
          * as: If a node's index is i, its parent's index is i/2; its left child's index is 2*i, and its right 
          * child's index is 2*i+1.  Note that root node is at index 1. Entry at index 0 is not used.
          * Giving the following array, the binary tree we can build is:
          *                                12
          *                               /   \
          *                             2       8
          *                            /  \       \
          *                          10    4        6
          *                         / 
          *                         8
          */  
        Integer[] treeA = {12, 2, 8, 10, 4, null, 6, 8, null, null, null, null, null};
        List<BinaryTree<Integer>> treeList = new ArrayList<BinaryTree<Integer>>();
        treeList.add(null);
        for (int i=0; i<treeA.length; i++){
            if (treeA[i]!=null){
                treeList.add(new BinaryTree<Integer>(treeA[i]));
            }
            else {
                treeList.add(null);
            }
        }
        
        int i=1;
        while (2*i+1<treeList.size()){
            if (treeList.get(i)!=null){
                treeList.get(i).setLeft(treeList.get(2*i));
                treeList.get(i).setRight(treeList.get(2*i+1));
            } 
            i++;
        }
        
        BinaryTree<Integer> root = treeList.get(1);  
        System.out.println("The height of this tree is: " + root.getHeight());
        System.out.println("Is this a leaf?: " + root.isLeaf());
        System.out.println("PreOrder sequence: " + root.preOrder());
        System.out.println("LeafCount is: " + root.leafCount());
        System.out.println("LevelOrder sequence: " + root.levelOrder());
        System.out.println("InOrder sequence: " + root.inOrder());
        System.out.println("PostOrder sequence: " + root.postOrder());
        System.out.println("NodeSum: " + root.nodeSum());
        System.out.println("MaxPathSum: " + root.maxPathSum());
        System.out.println("IsMirror: ");
                           
                           }
}
