package org.example;

public class MyHashTable <K, V> {
    private final HashNode<K, V>[] chainArray; // buckets in the hash table(array of hash node)
    private int M = 11; // default number of chains，capacity
    private int size; // number of key-value pairs & num of hash nodes

    // when we create an instance of hash table
    // It will call the parameterised constructor
    // creates hash table with a default capacity 10
    public MyHashTable(){
        chainArray = new HashNode[M];
    }
    // we are providing how many buckets the hash table will have
    public MyHashTable(int M){
        this.M = M;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next; //reference to next hash node

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    public int size(){
        return size;
    }

    public int getBucketsCount() {
        return chainArray.length;  //this method eturns the number of buckets
    }
    public int getBucketSize(int bucketIndex) {
        if (bucketIndex < 0 || bucketIndex >= chainArray.length) {
            throw new IndexOutOfBoundsException("Bucket index out of range: " + bucketIndex);
        }
        int count = 0;
        HashNode<K, V> current = chainArray[bucketIndex];
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


    private int hash(K key){
        return Math.abs(key.hashCode() % M); //calculate the hash code for the key and take the absolute value.
    } //here, we used modules to ensure the index falls with the range of arr size
    //key % chainArray.length - is also okay

    public void put(K key, V value){ // inserts a key-value part into the hash table
        if(key == null || value == null){
            throw new IllegalArgumentException("Key or Value is null.");
        }

        //Firstly, we take the key and pass it to hash function
        int index = hash(key);
        HashNode<K,V> currentNode = chainArray[index]; //travers the linkedList to find the right position to insert the new one
        while(currentNode != null){
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
    public V get(K key){
        //returns the corresponding value associated with a specific key
        if(key == null){
            throw new IllegalArgumentException("Key is null.");
        }
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
        if(key == null){
            throw new IllegalArgumentException("Key is null.");
        }
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
        if(prevNode != null){
            prevNode.next = currentNode.next;
        } else{
            chainArray[index] = currentNode.next;
        }
        return currentNode.value;

    }
    public boolean contains(V value){
        for (HashNode<K, V> HashNode : chainArray) {
            HashNode<K, V> currentNode = HashNode;
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

}
