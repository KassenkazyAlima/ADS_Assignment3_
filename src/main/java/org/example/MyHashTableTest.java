package org.example;
import java.util.Random;


public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<Group, Student> hashTable = new MyHashTable<>();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            String groupID = "Group" + random.nextInt(1000);
            Group group = new Group(groupID);

            int studentId;
            studentId = i;
            String firstName = "Student" + i;
            String surname = "Surname" + (random.nextInt(100) + 10);

            Student student = new Student(studentId, firstName, surname);
            hashTable.put(group, student);
        }
        System.out.println("Distribution of elements in the hash table:");
        printDistribution(hashTable);


        Group testGroup = new Group("Group2312");
        Student retrievedStudent = hashTable.get(testGroup);
        if (retrievedStudent != null) {
            System.out.println("Retrieved Student: " + retrievedStudent);
        } else {
            System.out.println("No student" + testGroup.getGroupId());
        }

        Student removedStudent = hashTable.remove(testGroup);
        if (removedStudent != null) {
            System.out.println("Removed Student: " + removedStudent);
            printDistribution(hashTable); // Print distribution again to see the effect of removal
        } else {
            System.out.println("No student " + testGroup.getGroupId());
        }
    }

    private static void printDistribution(MyHashTable<Group, Student> hashTable) {
        int numOfBuckets = hashTable.getBucketsCount();
        for (int i = 0; i < numOfBuckets; i++) {
            int bucketSize = hashTable.getBucketSize(i);

            System.out.println("Bucket " + i + " has " + bucketSize + " elements.");
        }
    }



}

