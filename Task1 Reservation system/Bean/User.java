package tasks.task1_Reservation_System.bean;

public class User {
    private String userName;
    private String password;
    private long mobileNo;
    private int userId;

    public User() {
    }

    public User(String userName, String password, long mobileNo, int userId) {
        this.userName = userName;
        this.password = password;
        this.mobileNo = mobileNo;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo=" + mobileNo + '\'' +
                ", userId =" +userId +
                '}';
    }
}
