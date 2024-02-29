package tasks.task1_Reservation_System.bean;

public class ReservationDetails {
    private String passengerName;
    private String from;
    private String to;
    private String pnrNumber;
    private String trainNumber;
    private  double price;
    private  int userId;

    public ReservationDetails(String passengerName, String from, String to, String pnrNumber, String trainNumber, double price,int userId) {
        this.passengerName = passengerName;
        this.from = from;
        this.to = to;
        this.pnrNumber = pnrNumber;
        this.trainNumber = trainNumber;
        this.price = price;
        this.userId = userId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |",passengerName,from,to,pnrNumber,trainNumber,price);
    }
}
