package org.example;
import java.util.Random;


public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<Group, Student> hashTable = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            String groupID = "Group" + random.nextInt(100);
            Group group = new Group(groupID);


            int studentId = i;
            String firstName = "Student" + i;
            String surname = "Surname" + (random.nextInt(100) + 10);

            Student student = new Student(studentId, firstName, surname);
            hashTable.put(group, student);
        }
        System.out.println("Distribution of elements in the hash table:");
        printDistribution(hashTable);

    }

    private static void printDistribution(MyHashTable<Group, Student> hashTable) {
        int numOfBuckets = hashTable.getBucketsCount();
        for (int i = 0; i < numOfBuckets; i++) {
            int count = 0;
            int bucketSize = hashTable.getBucketSize(i);

            System.out.println("Bucket " + i + " has " + bucketSize + " elements.");
        }
    }



}

