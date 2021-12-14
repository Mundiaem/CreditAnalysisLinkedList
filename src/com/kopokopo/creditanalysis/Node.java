package com.kopokopo.creditanalysis;

/**
 * created with love by mundiaem
 * <p>
 * ⚡  - CreditScoreAnalysisImplementation
 * https://www.geeksforgeeks.org/insertion-sort-for-singly-linked-list/
 * https://www.javatpoint.com/program-to-sort-the-elements-of-the-singly-linked-list
 * https://www.codeproject.com/Questions/1241326/How-to-make-my-sort-method-sorts-in-alphabetical-o
 * https://www.dreamincode.net/forums/topic/314725-help-sorting-a-linkedlist-alphabetically/
 * https://crunchify.com/how-to-implement-a-linkedlist-class-from-scratch-in-java/
 *
 */
public class Node<T> {
    T data;
    Node<T> next;

    public void displayData() {
        System.out.println(" This is the node data: " + data.toString());
    }
}
