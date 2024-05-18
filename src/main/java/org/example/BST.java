package org.example;
import javax.swing.tree.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class BST<K extends Comparable<K>, V>{
    private TreeNode root;
    private int size;

    private class TreeNode{
        private K key;
        private V value;
        private TreeNode left, right;
        public TreeNode(K key, V value){
            this.key = key;
            this.value=value;
        }
    }
    public int size() {
        return size;
    }
    public void put(K key,V value){
        root = put(root, key, value);
    }

    private TreeNode put(TreeNode root, K key, V value){
        if(root== null){
            root = new TreeNode(key,value);
            return root;
        }
        int comp = key.compareTo(root.key);
        if(comp < 0){
            root.left = put(root.left,key,value);
        } else if(comp > 0){
            root.right = put(root.right,key,value);
        }else{
            root.value = value;
        }
        return root;
    }

    public V get(K key){
        return get(root,key);
    }

    private V get(TreeNode root, K key){
        while (root != null){
            int comp = key.compareTo(root.key);
            if(comp < 0){
                root = root.left;
            } else if (comp > 0){
                root = root.right;
            } else {
                return root.value;
            }
        }
        return null;
    }

    public void delete(K key){
        root = delete(root,key);
    }
    private TreeNode delete(TreeNode root, K key) {
        if (root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = delete(root.left, key);
        } else if (cmp > 0) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode t = root;
            root = getMin(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    private TreeNode deleteMin(TreeNode root) {
        if (root.left == null) return root.right;
        root.left = deleteMin(root.left);
        return root;
    }

//    public Iterable<K> iterator(){
//        List<K> keys = new ArrayList<>();
//        inOrder(root, keys);
//        return keys;
//    }
//    private void inOrder(TreeNode root, List<K> keys) {
//        if (root == null) return;
//        inOrder(root.left, keys);
//        keys.add(root.key);
//        inOrder(root.right, keys);
//    }

    public Iterable<Entry<K, V>> iterator() {
        List<Entry<K, V>> entries = new ArrayList<>();
        inOrder(root, entries);
        return entries;
    }

    // Here is in order  method to populate the entries list
    private void inOrder(TreeNode root, List<Entry<K, V>> entries) {
        if (root == null) return;
        inOrder(root.left, entries);
        entries.add(new Entry<>(root.key, root.value));
        inOrder(root.right, entries);
    }

}
