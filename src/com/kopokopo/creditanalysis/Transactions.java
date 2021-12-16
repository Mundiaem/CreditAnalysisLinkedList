package com.kopokopo.creditanalysis;

import java.util.Date;

/**
 * created with love by mundiaem

 * ⚡  - CreditScoreAnalysisImplementation
 */
//mapping transaction of the customers
public class Transactions {
    private String customer_id;
    private Date transaction_date;

    public Transactions(String customer_id, Date transaction_date) {
        this.customer_id = customer_id;
        this.transaction_date = transaction_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "customer_id='" + customer_id + '\'' +
                ", transaction_date=" + transaction_date +
                '}'+"\n";
    }
}
