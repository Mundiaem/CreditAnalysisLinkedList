package com.kopokopo.creditanalysis;

/**
 * created with love by mundiaem
 * <p>
 * ⚡  - CreditScoreAnalysisImplementation

 *
 */
/*generic node class*/
public class Node<T> {
    T data;
    Node<T> next;

    public void displayData() {
        System.out.println(" This is the node data: " + data.toString());
    }
}
