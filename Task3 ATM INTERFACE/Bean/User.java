
package tasks.task3_Atm_Interface.bean;

public class User {

    private String userName;
    private int password;
    private long phone;
    private long accNum;
    private double balance;

    public User(String userName, int password, long phone, long accNum, double balance) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.accNum = accNum;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Atm_Impl{" +
                "userName='" + userName + '\'' +
                ", password=" + password +
                ", phone=" + phone +
                ", accNum=" + accNum +
                ", balance=" + balance +
                '}';
    }
}
