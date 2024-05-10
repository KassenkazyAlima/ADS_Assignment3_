package org.example;

public class MyHashTable <K, V> {
    private HashNode<K, V>[] chainArray; // or Object[], array of hash node
    private int M = 11; // default number of chains，capacity
    private int size; // number of key-value pairs

    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    public MyHashTable(){

    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    private int hash(K key){
    }

    public void put(K key, V value){

    }
    public V get(K key){ //get the value by using the key
        return null;
    }
    public V remove(K key){
        return null;
    }
    public boolean contains(V value){

    }
    public K getKey(V value){

    }

}
