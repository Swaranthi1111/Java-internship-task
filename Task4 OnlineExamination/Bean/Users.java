
package tasks.task4_Online_Examination.bean;

public class User {
    private String userName;
    private String userPassword;
    private long phoneNo;

    public User(){}

    public User(String userName, String userPassword,long phoneNo) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
