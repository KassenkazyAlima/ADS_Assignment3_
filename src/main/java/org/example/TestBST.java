package org.example;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(1, "I didnt really understand how Big O Notation works...");
        bst.put(32, "What is the difference between Time Complexity and Space Complexity");
        bst.put(90, "Have a good day");

        for (Entry<Integer, String> elem : bst.iterator()) {
            System.out.println("Key is " + elem.getKey() + " and Value is " + elem.getValue());
        }

    }
}
