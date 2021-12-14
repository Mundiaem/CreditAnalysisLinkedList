package com.kopokopo.creditanalysis;

/**
 * created with love by mundiaem
 * <p>
 * ⚡  - CreditScoreAnalysisImplementation
 */

public class Score {
    private String customer_id;
    private int score;

    public Score(String customer_id, int score) {
        this.customer_id = customer_id;
        this.score = score;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScoreIncrement(int score) {
        this.score += score;
    }

    @Override
    public String toString() {
        return "\nScore{" +
                "customer_id='" + customer_id + '\'' +
                ", score=" + score +
                '}';
    }
    public String toIDString() {
        return "'" + customer_id + '\'';
    }
}
