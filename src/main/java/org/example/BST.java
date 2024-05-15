package org.example;
import java.util.List;
import java.util.ArrayList;
public class BST<K extends Comparable<K>, V>{
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value=value;
        }
    }

    public int size(){
        return size;
    }

    public void put(K key,V value){
        root = put(root, key, value);
    }

    private Node put(Node n, K key, V value){
        if(n == null) return new Node(key,value);
        int comp = key.compareTo(n.key);
        if(comp < 0){
            n.left = put(n.left,key,value);
        } else if(comp > 0){
            n.right = put(n.right,key,value);
        }else{
            n.value = value;
        }
        return n;
    }
    public V get(K key){
        return get(root,key);
    }

    private V get(Node n, K key){
        while (n != null){
            int comp = key.compareTo(n.key);
            if(comp < 0){
                n = n.left;
            } else if (comp > 0){
                n = n.right;
            } else {
                return n.value;
            }
        }
        return null;
    }

    public void delete(K key){
        root = delete(root,key);
    }
    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }
    private Node min(Node x) {
        while (x.left != null) x = x.left;
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public Iterable<K> iterator(){
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }
    private void inOrder(Node x, List<K> keys) {
        if (x == null) return;
        inOrder(x.left, keys);
        keys.add(x.key);
        inOrder(x.right, keys);
    }

}
