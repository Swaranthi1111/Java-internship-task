
package tasks.task1_Reservation_System.implementation;

import tasks.task1_Reservation_System.controller.Reservation_Methods;
import java.util.Scanner;

public class Reservation_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reservation_Methods reservationMethods = new Reservation_Methods();
        boolean flag = true;

        do {
            System.out.println();
            System.out.println("+         || Reservation System ||           +");
            System.out.println("+--------------------------------------------+");
            System.out.println("                1. Register                   ");
            System.out.println("                2. Login                      ");
            System.out.println("                3. Exit                       ");
            System.out.println("+--------------------------------------------+");
            System.out.println();
            System.out.print("Select Your Option: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1 -> {
                    System.out.print("Enter Your Name : ");
                    String userName = sc.nextLine();
                    System.out.print("Enter Your Password : ");
                    String password = sc.nextLine();
                    System.out.print("Enter Your Mobile Number : ");
                    long phoneNum = sc.nextLong();
                    reservationMethods.registerUser(userName, password, phoneNum);
                }
                case 2 -> {
                    System.out.print("Enter Your Name : ");
                    String userName1 = sc.nextLine();
                    System.out.print("Enter Your Password : ");
                    String password1 = sc.nextLine();
                    reservationMethods.login(userName1, password1);
                }
                case 3 ->{
                    flag = false;
                    System.out.println("Thanks for using us..!");
                }

                default -> System.out.println("Choose correct option");
            }
        }while (flag);


    }
}
