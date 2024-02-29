package tasks.task1_Reservation_System.bean;

import java.util.Random;

public class Train {
    private String trainName;
    private String trainNumber;
    private String from;
    private String to;
    private int availableSeats;
    private TicketPrice ticketPrice;


    public Train() {

    }

    public Train(String trainName, String trainNumber, String from, String to,TicketPrice ticketPrice) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.from = from;
        this.to = to;
        Random ran = new Random();
        int seat = ran.nextInt(1,31);
        this.availableSeats = seat;
        this.ticketPrice = ticketPrice;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
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

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        Random ran = new Random();
        this.availableSeats = ran.nextInt(1,101);
    }

    public TicketPrice getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return String.format("| %-20s | %-14s | %-16s | %-16s | %-15d |", trainName, trainNumber, from, to, availableSeats);
    }
}
