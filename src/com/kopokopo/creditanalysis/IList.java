package com.kopokopo.creditanalysis;

import java.util.ListIterator;

/**
 * created with love by mundiaem
 * <p>
 * ⚡  - CreditScoreAnalysisImplementation
 */
public interface IList<T> {
    //add specific element to the linkedList
    void insertFirst(T t);

    boolean add(T t);

    boolean isEmpty();

    //add specific element to the list at specific index
    void add(int index, T t);

    //return list iterator from specific index
    ListIterator<T> listIterator(int index);

    //set by replacing element from a specific index
    T set(int index, T t);

    //compare element that follow each other
    void compareConsequentiveElements();

    // return specific number of items upto specific item
    String[] peekUpto(int n);

    String[] peekUpToPosition(int n);


    void replace(T value, int position);

    int size();

    void sortedDateInsert(Node<T> newnode);

    void sortDate();

    void sort();

    void sortedInsert(Node<Score> newnode);

    void sortedCustomerWithEqualScore(Node<T> cNode);


    //


}
