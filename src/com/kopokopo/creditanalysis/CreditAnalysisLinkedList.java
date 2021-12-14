package com.kopokopo.creditanalysis;

import java.util.Arrays;
import java.util.ListIterator;

/**
 * created with love by mundiaem
 * <p>
 * ⚡  - CreditScoreAnalysisImplementation
 */

public class CreditAnalysisLinkedList<T> implements IList<T> {
    Node<T> head;
    Node<Score> scoreHead;
    Node<String> checkedHead;


    private Node<T> sorted = null;
    private Node<Score> sortedScores = null;


    @Override
    public void insertFirst(T t) {
        Node<T> newNode = new Node<>();
        newNode.data = t;
        newNode.next = head;
        head = newNode;

    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public void add(int position, T t) {
        Node<T> currentNode = head;
        if (position < 1) {
            System.out.println("position invalid");
        }
        if (position == 1) {
            Node<T> newNode = new Node<>();
            newNode.data = t;
            newNode.next = currentNode;
            currentNode.next = newNode;
        } else {
            while (position-- != 0 && currentNode != null) {
                if (position == 1) {

                    Node<T> newNode = new Node<>();
                    newNode.data = t;
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    break;
                }
                currentNode = currentNode.next;
            }

        }


    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            current.displayData();
            current = current.next;
        }
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public T set(int position, T t) {
        Node<T> current = head;
        Node<T> setNode = new Node<T>();
        setNode.data = t;
        if (position == 0) {
            insertFirst(t);
        } else if (head == null) {
            insertFirst(t);
        } else {
            for (int j = 0; current != null && j < (position - 1); j++) {
                current = current.next;
            }

            assert current != null;
            Node<T> temp = current.next;
            current.next = setNode;
            setNode.next = temp;
        }
        return setNode.data;
    }

    @Override
    public void compareConsequentiveElements() {
        Node<T> currentNode = head, prev = null;


        while (currentNode != null) {
            Node<T> temp = currentNode;

//            while (temp.next != null && (difference_In_Days == -1 || difference_In_Days == 0)) {
//                System.out.printf("\n%s : %s", ((Transactions) temp.data).getTransaction_date(), ((Transactions) temp.data).getCustomer_id());
//                //  System.out.printf("\n%s : difference in days %s > %s:: %s = %s", difference_In_Days, ((Transactions) currentNode.data).getTransaction_date(), ((Transactions) currentNode.next.data).getTransaction_date(),((Transactions) currentNode.data).getCustomer_id(),((Transactions) temp.data).getCustomer_id() );
//                temp = temp.next;
//            }


            while (temp != null && temp.data == currentNode.data) {
                temp = temp.next;
            }

           // System.out.printf("\n%s : %s", ((Transactions) currentNode.data).getTransaction_date(), ((Transactions) currentNode.data).getCustomer_id());




  /*Set current node next to the next different
            element denoted by temp*/
            currentNode.next = temp;
            currentNode = currentNode.next;
//            prev = currentNode;
//            currentNode = currentNode.next;
        }


    }


    public Node<Score> userExist(Node<Score> currentNode) {
        Node<Score> scoreNode = scoreHead;
        while (scoreNode.next != null) {

            Node<Score> temp = scoreNode;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while (temp.next != null) {

                if (temp.data.getCustomer_id().equalsIgnoreCase(scoreNode.data.getCustomer_id())) {
                    System.out.println(" Temp : " + temp.data);
                }
                temp = temp.next;


            }
            /*Set current node next to the next different
            element denoted by temp*/
            scoreNode.next = temp;
            scoreNode = scoreNode.next;

//            scoreNode = scoreNode.next;
        }
        return scoreNode;

    }

    @Override
    public String[] peekUpto(int n) {
        String[] customers = new String[4];
        Node<T> currentNode = head;
        int position = 4;
        int index = 0;
        /*return element from fist element up to position*/
        while (currentNode.next != null && position-- != 0) {
            System.out.println(currentNode.data);
            customers[index] = currentNode.data.toString();
            index++;
            currentNode = currentNode.next;

        }
        System.out.println(Arrays.toString(customers));


        return customers;
    }

    @Override
    public String[] peekUpToPosition(int n) {
        String[] customers = new String[n];
        Node<Score> currentNode = scoreHead;
        int position =n;
        int index = 0;
        /*return element from fist element up to position*/
        while (currentNode.next != null && position-- != 0) {
//            System.out.println(currentNode.data);
            customers[index] = currentNode.data.toIDString();
            index++;
            currentNode = currentNode.next;

        }
        System.out.println(Arrays.toString(customers));


        return customers;
    }


    @Override
    public void replace(T value, int position) {
        System.out.println("Size " + size());
        // Initialize sorted linked list
        sorted = null;
        Node<T> current = head;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null) {
            // Store next for next iteration
            Node<T> next = current.next;
            // insert current in sorted linked list
            sortedDateInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        head = sorted;

    }

    public void sortedDateInsert(Node<T> newnode) {
        /* Special case for the head end */
        if (sorted == null || ((Transactions) sorted.data).getTransaction_date().compareTo(((Transactions) newnode.data).getTransaction_date()) > 0) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Node<T> current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && ((Transactions) current.next.data).getTransaction_date().compareTo(((Transactions) newnode.data).getTransaction_date()) < 0) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    /* Counts the no. of occurrences of a node
       (search_for) in a linked list (head)*/
    public void count() {

        Node<T> current = head;


        while (current.next != null) {
            Node<T> temp = current;


            int count = 0;
            // System.out.printf("\nCurrent customer:  %s Score: %s : date : %s", ((Transactions) current.data).getCustomer_id(), count, ((Transactions) current.data).getTransaction_date());
            //compare the size with the number of elements if not equal grows the array size


            String customer_id = ((Transactions) current.data).getCustomer_id();


            // System.out.printf("\nMy Array : %s : current : %s ", Arrays.toString(checked), ((Transactions) current.data).getCustomer_id());

            if (!isChecked(customer_id)) {
                addToChecked(customer_id);
//                System.out.printf("\n-----------------------------FOR  %s------------------------------", customer_id);
                while (temp.next != null) {
                    long difference_In_Time
                            = (((Transactions) temp.data).getTransaction_date().getTime() - (((Transactions) temp.next.data).getTransaction_date().getTime()));
                    long difference_In_Days
                            = (difference_In_Time
                            / (1000 * 60 * 60 * 24))
                            % 365;
                    boolean isNextDay = (difference_In_Days == -1) ? true : false;
//                    System.out.printf(" \ndays %s : current %s next %s", difference_In_Days, ((Transactions) current.data).getTransaction_date(), ((Transactions) current.next.data).getTransaction_date());


                    if (customer_id.equalsIgnoreCase(((Transactions) temp.next.data).getCustomer_id()) && isNextDay) {

                        count++;
                      //  System.out.printf(" \ndays %s : current %s next %s", difference_In_Days, ((Transactions) temp.data).getTransaction_date(), ((Transactions) temp.next.data).getTransaction_date());
                       // System.out.printf("\nCurrent : %s at %s is  same day: %s", customer_id, count, isNextDay);
                    }


//                    if (((Transactions) current.data).getCustomer_id().equalsIgnoreCase(((Transactions) current.next.data).getCustomer_id())) {
//
//                    }
                    temp = temp.next;
                }
                Score score = new Score(customer_id, count);
                Node<Score> scoreNode = new Node<>();
                scoreNode.data = score;
                scoreNode.next = scoreHead;
                scoreHead = scoreNode;
//                System.out.println("\n-----------------------------------------------------------");
//                System.out.printf("\n Count C: %s number: %s", customer_id, count);
            }


            current = current.next;
        }


    }

    @Override
    public void sortDate() {
        // Initialize sorted linked list
        sorted = null;
        Node<T> current = head;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null) {
            // Store next for next iteration
            Node<T> next = current.next;
            // insert current in sorted linked list
            sortedDateInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        head = sorted;

    }

    @Override
    public void sort() {
        // Initialize sorted linked list
        sortedScores = null;
        Node<Score> current = scoreHead;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null) {
            // Store next for next iteration
            Node<Score> next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        scoreHead = sortedScores;

    }

    @Override
    public void sortedInsert(Node<Score> newnode) {
        /* Special case for the head end */
        if (sortedScores == null || sortedScores.data.getScore() <newnode.data.getScore()) {
            newnode.next = sortedScores;
            sortedScores = newnode;
        } else {
            Node<Score> current = sortedScores;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.data.getScore() < newnode.data.getScore()) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }

    }

    @Override
    public void sortedCustomerWithEqualScore(Node<T> cNode) {

    }

    private void addToChecked(String checked) {
        Node<String> newNode = new Node<>();
        newNode.data = checked;
        newNode.next = checkedHead;
        checkedHead = newNode;
    }

    private boolean isChecked(String checked) {
        Node<String> current = checkedHead;
        while (current != null) {
            // System.out.printf("\n%s is Checked %s",checked, current.data.equalsIgnoreCase(checked));
            if (current.data.equalsIgnoreCase(checked)) {
                return true;
            }

            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;

        }
        return size;
    }
}
