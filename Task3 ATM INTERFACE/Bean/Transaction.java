
package tasks.task3_Atm_Interface.bean;

import java.time.LocalDateTime;

public class Transaction {
    private User user;
    private  String type;
    private double amt;
    private LocalDateTime currentTime;

    public Transaction(){

    }
    public Transaction(User user, String type,double amt) {
        this.user = user;
        this.type = type;
        this.amt = amt;
        this.currentTime = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public double getAmt() {
        return amt;
    }

//    public void setAmt(double amt) {
//        this.amt = amt;
//    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "user=" + user +
                ", type='" + type + '\'' +
                ", currentTime=" + currentTime +
                '}';
    }
}
