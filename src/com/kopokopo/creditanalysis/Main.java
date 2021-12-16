package com.kopokopo.creditanalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String transactions_csv_file_path_1 = "src/com/kopokopo/creditanalysis/interview_code_test/test_data/transaction_data_1.csv";
        makeAnalysis(transactions_csv_file_path_1, 1);
        String transactions_csv_file_path_2 = "src/com/kopokopo/creditanalysis/interview_code_test/test_data/transaction_data_2.csv";
        makeAnalysis(transactions_csv_file_path_2, 3);

        String transactions_csv_file_path_3 = "src/com/kopokopo/creditanalysis/interview_code_test/test_data/transaction_data_3.csv";
        makeAnalysis(transactions_csv_file_path_3, 5);


    }
// take path of the file and integer n (number of customer to output)
    private static void makeAnalysis(String transactions_csv_file_path, int n) {
        String data = "";
        String[] transactions = {};
        int count = 0;
        Date transaction_date = null;
        CreditAnalysisLinkedList<Transactions> creditAnalysisLinkedList = new CreditAnalysisLinkedList<>();
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(transactions_csv_file_path));
            while ((data = readFile.readLine()) != null) {
                transactions = data.split(",");
                if (count > 0) {
                    try {
                        transaction_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(transactions[2]);
//                        System.out.println(transaction_date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    creditAnalysisLinkedList.insertFirst(new Transactions(transactions[0], transaction_date));

                }
                count++;


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("---------------------------------------");
//        creditAnalysisLinkedList.display();
//        System.out.println("------------------SORTING DATE---------------------");
        creditAnalysisLinkedList.sortDate();
//        creditAnalysisLinkedList.display();
//        System.out.println("------------------Score ---------------------");
       creditAnalysisLinkedList.compareConsequentiveElements();
       creditAnalysisLinkedList.count();
        creditAnalysisLinkedList.sort();
        creditAnalysisLinkedList.peekUpToPosition(n);

//        while (scoreNode != null) {
//            System.out.println(scoreNode.data.toString());
//            scoreNode = scoreNode.next;
//        }

    }
}
