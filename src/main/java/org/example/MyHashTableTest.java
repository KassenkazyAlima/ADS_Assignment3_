package org.example;
import java.util.Random;


public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<Group, Student> hashTable = new MyHashTable<>(11);

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String groupID = "Group number is " + random.nextInt(10000);
            Group group = new Group(groupID);

            int studentId = random.nextInt(10000);
            String firstName = "[Firstname " + random.nextInt(10000) + ",";
            String surname = "Surname " + (random.nextInt(10000))+ "]";

            Student student = new Student(studentId, firstName, surname);
            hashTable.put(group, student);

            System.out.println(group + " - student id is " + student);

        }
        printDistribution(hashTable);


        Group testGroup = new Group("Group2312 ");
        Student retrievedStudent = hashTable.get(testGroup);
        if (retrievedStudent != null) {
            System.out.println("Retrieved " + retrievedStudent);
        } else {
            System.out.println("No student " + testGroup.getGroupId());
        }

        Student removedStudent = hashTable.remove(testGroup);
        if (removedStudent != null) {
            System.out.println("Removed " + removedStudent);
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

