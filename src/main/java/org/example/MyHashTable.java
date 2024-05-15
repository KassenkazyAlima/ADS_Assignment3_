package org.example;

public class MyHashTable <K, V> {
    private HashNode<K, V>[] chainArray; // buckets in the hash table(arr of hash node)
    private int M = 11; // default number of chains，capacity
    private int size; // number of key-value pairs

    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    private int hash(K key){
        return Math.abs(key.hashCode() % M); //calculate the hash code for the key and take the absolute value.
    } //here, we used modules to ensure the index falls with the range of arr size

    public void put(K key, V value){ // inserts a key-value part into the hash table
        int index = hash(key);
        HashNode<K,V> currentNode = chainArray[index]; //travers the linkedList to find the right position to insert the new one
        while(currentNode!=null){
           if(currentNode.key.equals(key)){
               currentNode.value = value;
               return;
           }
           currentNode = currentNode.next;
        }
       size++;
       currentNode = chainArray[index];
       HashNode<K,V> newNode = new HashNode<>(key,value);
       newNode.next = currentNode;
       chainArray[index] = newNode;
    }
    public V get(K key){ //get the value by using the key
        int index = hash(key);
        HashNode<K,V> currentNode = chainArray[index];
        while (currentNode != null){
            if(currentNode.key.equals(key)){
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null; //if key is not found then return null
    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K,V> currentNode = chainArray[index];
        HashNode<K,V> prevNode = null;

        while(currentNode != null){
            if(currentNode.key.equals(key)){
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if(currentNode == null) return null;

        size--;

        if(prevNode!=null){
            prevNode.next = currentNode.next;
        }
        else{
            chainArray[index] = currentNode.next;
        }
        return currentNode.value;

    }
    public boolean contains(V value){
        for (HashNode<K,V> currentNode :  chainArray){
            while(currentNode != null){
                if(currentNode.value.equals(value)){
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for(HashNode<K,V> currentNode:chainArray){
            while(currentNode != null){
                if(currentNode.value.equals(value)){
                    return currentNode.key;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }
    public void printDistribution() {
        for (int i = 0; i < chainArray.length; i++) {
            int count = 0;
            for (HashNode<Group, Student> node = chainArray[i]; node != null; node = node.next) {
                count++;
            }
            System.out.println("Bucket " + i + " has " + count + " elements.");
        }
    }

}
