package tasks.task1_Reservation_System.bean;

public class TicketPrice {
    private double firstAC;
    private double secondAc;
    private double sleeper;

    public TicketPrice(double firstAC, double secondAc, double sleeper) {
        this.firstAC = firstAC;
        this.secondAc = secondAc;
        this.sleeper = sleeper;
    }

    public double getFirstAC() {
        return firstAC;
    }

    public void setFirstAC(double firstAC) {
        this.firstAC = firstAC;
    }

    public double getSecondAc() {
        return secondAc;
    }

    public void setSecondAc(double secondAc) {
        this.secondAc = secondAc;
    }

    public double getSleeper() {
        return sleeper;
    }

    public void setSleeper(double sleeper) {
        this.sleeper = sleeper;
    }

    @Override
    public String toString() {
        return String.format("| %-15s | %-15s | %-15s |", firstAC,secondAc,sleeper);
    }
}
