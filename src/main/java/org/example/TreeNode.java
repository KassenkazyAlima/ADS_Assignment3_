package org.example;

public class TreeNode<T> {
    private TreeNode left;
    private TreeNode right;
    private T data;

    public TreeNode(T data){
        this.data = data;
    }

    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }
}
