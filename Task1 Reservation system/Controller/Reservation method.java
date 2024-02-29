package tasks.task1_Reservation_System.controller;


import tasks.task1_Reservation_System.bean.ReservationDetails;
import tasks.task1_Reservation_System.bean.TicketPrice;
import tasks.task1_Reservation_System.bean.Train;
import tasks.task1_Reservation_System.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Reservation_Methods {

       boolean loggedIn = false;
       int userIdNum = 0;
       ReservationDetails reservationDetails;
       Random ran = new Random();
       Scanner sc = new Scanner(System.in);
       List<User> userList = new ArrayList<>();
       List<ReservationDetails> passengerDetails = new ArrayList<>();
       List<ReservationDetails> currentTicketList = new ArrayList<>();
       public void registerUser(String uName, String password, long phoneNo){

              boolean userExist = false;
              int usedId = ran.nextInt(1000,9999);

              User addUser = new User(uName,password,phoneNo,usedId);
              for(User user:userList){
                     if(phoneNo==user.getMobileNo()){
                            userExist = true;
                            System.out.println("User with this phone number is already exist..!");
                            break;
                     }
              }
              if (!userExist){
                     userList.add(addUser);
                     System.out.println("Registered Successfully....!");
              }
       }


       public void login(String userN, String userPass){

              for(User user:userList){
                     if(userN.equals(user.getUserName()) && userPass.equals(user.getPassword())){
                            loggedIn = true;
                            userIdNum = user.getUserId();
                            System.out.println("Logged In successfully..!!");
                            System.out.println();
                            reservationMenu();
                     }
              }
       }

       public void logOut(){
              userIdNum = 0;
              loggedIn = false;
       }

       public void reservationMenu(){
              List<Train> listOfTrain = trains();
              while (loggedIn){
                     System.out.println("+--------------------------------------------+");
                     System.out.println("              Reservation Interface           ");
                     System.out.println("+--------------------------------------------+");
                     System.out.println("1. Make Reservation\n2. Cancel Reservation\n3. Check Tickets\n4. Logout");
                     System.out.println("+--------------------------------------------+");
                     System.out.println();
                     System.out.print("Choose option : ");
                     int opt = sc.nextInt();
                     sc.nextLine();
                     switch (opt){
                            case 1 -> makeReservation(listOfTrain);

                            case 2 -> cancelReservation(passengerDetails);

                            case 3 -> displayAllTickets(passengerDetails);

                            case 4 -> logOut();

                            default -> System.out.println("Choose a correct a option");
                     }
              }
       }

       public void makeReservation(List<Train> trainList){
              List<Train> addTrain = new ArrayList<>();
              addTrain.clear();
              System.out.println("+-----------------------------------+");
              System.out.println("           Make Reservation          ");
              System.out.println("+-----------------------------------+");

              System.out.println("Enter your Source station : ");
              String source = sc.nextLine();

              System.out.println("Enter your destination : ");
              String destination = sc.nextLine();

              for (Train train:trainList){
                     if(destination.equals(train.getTo())){
                            addTrain.add(train);
                     }
              }
              displayTrains(addTrain);
              System.out.print("Choose your train...\nEnter the train number: ");
              String trainNum = sc.nextLine();


              System.out.print("No.of Passengers : ");
              int noOfPassengers = sc.nextInt();
              sc.nextLine();

              while (noOfPassengers-->0) {
                     System.out.print("Enter the name of the passenger: ");
                     String passName = sc.nextLine();

                     displayTrainPrice(trainList,trainNum);
                     System.out.println("Enter the amount according to class : ");
                     double amount = sc.nextDouble();
                     sc.nextLine();


                     long pnr = ran.nextLong(70000000, 100000000);
                     String pnrNum = "PNR" + pnr;
                     reservationDetails = new ReservationDetails(passName, source, destination, pnrNum, trainNum, amount,userIdNum);
                     passengerDetails.add(reservationDetails);
                     currentTicketList.add(reservationDetails);
              }
              System.out.println("Reservation Done Successfully...!");
              displayTickets(currentTicketList);
              currentTicketList.clear();
       }


       public void cancelReservation(List<ReservationDetails>list){
              System.out.println("To cancel Ticket enter your PNR Number : ");
              String pnr = sc.nextLine();
              for(ReservationDetails rd : list){
                     if(pnr.equals(rd.getPnrNumber())){
                            passengerDetails.remove(rd);
                            System.out.println("Ticket Cancelled Successfully..!");
                            System.out.println("Refund will be initiated in 48hrs..!");
                            System.out.println();
                            break;
                     }
              }
       }

       public List<Train> trains(){
              List<Train> trainList = new ArrayList<>();
              trainList.add(new Train("Shatabdi Express","12034","Delhi","Kanpur",new TicketPrice(1200,990,350)));
              trainList.add(new Train("Gomti Express","12420","Delhi","Kanpur",new TicketPrice(900,650,280)));
              trainList.add(new Train("Jammu Tawi Express","19027","Mumbai","Ahmedabad",new TicketPrice(1400,1090,450)));
              trainList.add(new Train("Punjab Mail","12138","Delhi","Mumbai",new TicketPrice(1350,1190,550)));

              return trainList;
       }

       public void displayTrains(List<Train> trainList){
              trains();
              System.out.println("+-----------------------------------------------------------------------------------------------+");
              System.out.format("| %-20s | %-14s | %-16s | %-16s | %-15s |\n", "Train Name", "Train Number", "Source", "Destination", "Avail Seats");
              System.out.println("+-----------------------------------------------------------------------------------------------+");
              for(Train trains:trainList){
                     System.out.println(trains);
              }
              System.out.println("+-----------------------------------------------------------------------------------------------+");
       }

       public void displayTrainPrice(List<Train> trainList,String trainNum){

              System.out.println();
              System.out.println("+--------------------------------------------------------------------------------+");
              System.out.println("|                                 Train Pricing                                  |");
              System.out.println("+--------------------------------------------------------------------------------+");
              System.out.format("| %-16s | %-14s | %-12s | %-12s | %-12s |\n", "Train Name", "Train Number", "1st AC", "2nd AC", "Sleeper");
              System.out.println("+--------------------------------------------------------------------------------+");
              for(Train trains:trainList){
                     if(trainNum.equals(trains.getTrainNumber())){
                            System.out.format("| %-16s | %-14s | %-12s | %-12s | %-12s |\n",trains.getTrainName(),trains.getTrainNumber(),trains.getTicketPrice().getFirstAC(),trains.getTicketPrice().getSecondAc(),trains.getTicketPrice().getSleeper());
                     }
              }
              System.out.println("+--------------------------------------------------------------------------------+");
       }


       public void displayTickets(List<ReservationDetails> list){
              System.out.println();
              System.out.println("+===============================================================================================+");
              System.out.println("|                                              Tickets                                          |");
              System.out.println("+-----------------------------------------------------------------------------------------------+");
              System.out.format("| %-16s | %-14s | %-12s | %-12s | %-12s | %-12s |\n", "Passenger Name", "Source Station", "Destination", "PNR Number", "Train Number", "Amount Paid");
              System.out.println("+-----------------------------------------------------------------------------------------------+");

              for (ReservationDetails rd : list){

                    System.out.format("| %-16s | %-14s | %-12s | %-12s | %-12s | %-12s |\n",rd.getPassengerName(), rd.getFrom(),rd.getTo(), rd.getPnrNumber(), rd.getTrainNumber(), rd.getPrice());
                    System.out.println("+-----------------------------------------------------------------------------------------------+");

                    }

       }

       public void displayAllTickets(List<ReservationDetails> list){
              System.out.println();
              System.out.println("+===============================================================================================+");
              System.out.println("|                                              Tickets                                          |");
              System.out.println("+-----------------------------------------------------------------------------------------------+");
              System.out.format("| %-16s | %-14s | %-12s | %-12s | %-12s | %-12s |\n", "Passenger Name", "Source Station", "Destination", "PNR Number", "Train Number", "Amount Paid");
              System.out.println("+-----------------------------------------------------------------------------------------------+");

              for (ReservationDetails rd : list){
                     if(userIdNum==rd.getUserId()){
                            System.out.format("| %-16s | %-14s | %-12s | %-12s | %-12s | %-12s |\n",rd.getPassengerName(), rd.getFrom(),rd.getTo(), rd.getPnrNumber(), rd.getTrainNumber(), rd.getPrice());
                            System.out.println("+-----------------------------------------------------------------------------------------------+");
                     }
              }

       }
}
