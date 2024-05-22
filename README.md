
<h1 align="center">Hi 👋 Nursultan Khaimuldin! Welcome </h1>


This assignment covers two main tasks: implementing a hash table and a binary search tree.



This project contains the following classes:
<h3 align ="left"> 🚀 MyHashTable: </h3> 

This class is the generic class that uses chaining to resolve collisions. What is more, it also represents the hash table data structure. We have a **HashNode** class to store key-value pairs and a reference to the next node for collisions.


Fields: 
- chainArray - represents the buckets or the chains in the hash table. Simply, it is an array of hash nodes.
- M - represents the default number of chains or the capacity of the hash table.
- size - represents the number of key-value pairs stored in the hash table.

Constructors:
- MyHashTable() is default constructor
- MyHashtable(int M) initializes the hash table with a specific capacity.

Methods:

- size() - return the number of key-value pairs
- isEmpty() - checks whether the hash table is empty or not

  
- hash(K key) - calculates the hash code for a specific key
- put(K key, V value) - inserts value and key
- get(K key) - retrieves the value of a specific key
- remove(K key) - removes the value of a specific key
- contains(V value) - check whether the hash table contains the value
- getKey(V value) - returns the key of a specific value

<h3 align ="left"> 🚀 MyHashTableTest: </h3>

This class is designed to test the functionality of the MyHashTable.

Methods:
- main(String[] args): The main method which runs the tests
- printDistribution(MyHashTable<Group, Student> hashTable): Prints the distribution of elements across the buckets of the hash table



<h3 align ="left"> 🚀 Student: </h3> 

This class represents an entity with attributes that might be used as a **value** in a hash table

Fields:
- id
- firstname
- surname

Methods:

- getId(), setId(int id).
- getFirstname(), setFirstname(String firstname)
- getSurname(), setSurname(String surname)
- toString()


<h3 align ="left"> 🚀 Group: </h3> 

Еhis class can be used as a **key** in the hash table. It includes methods to ensure it functions correctly in this capacity,such as equals and hashCode.

Fields:

- groupId

Methods:

- getGroupId(), setGroupId(String groupId)
- equals(Object obj): Overrides the Object class's equals method to compare based on groupId.
- hashCode(): Provides a hash code consistent with the definition of equality, ensuring that Group objects hash correctly when used as keys in MyHashTable.

<h3 align ="left"> 🚀 BST (Binary Search Tree): </h3>

This class implements a binary search tree which allows for efficient storage and retrieval of data in a sorted manner.

Fields:

- root: The root node of the tree.
- size: num of nodes

Methods:

- put(K key, V value): Inserts a key-value pair into the BST.
- get(K key): Retrieves the value associated with a specific key.
- delete(K key): Removes a key-value pair from the BST.
- iterator(): Provides an iterator that yields the elements of the BST in sorted order.
- inOrder(): A helper method used by the iterator to perform in-order traversal of the tree.


<h3 align ="left"> 🚀 Entry: </h3> 

This class is Used in the BST to encapsulate key-value pairs for iteration purposes, ensuring that both key and value are accessible during iteration

Fields:
- key
- value

Methods:
- getKey()
- getValue()


<p align="left">
</p>

<h3 align="left">Language</h3>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> </p>
