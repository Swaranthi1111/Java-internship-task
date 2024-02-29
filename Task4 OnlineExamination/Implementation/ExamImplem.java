
package tasks.task4_Online_Examination.implementation;

import tasks.task4_Online_Examination.controller.Online_Examination_System;

import java.util.Scanner;

public class ExamImpl {

    public static void main(String[] args) {
        Online_Examination_System oes = new Online_Examination_System();
        Scanner sc = new Scanner(System.in);
        boolean exit = true;
        boolean flag = true;
        System.out.println();

        do {
            System.out.println("--------------- M C Q - T E S T----------------");
            System.out.println();
            System.out.println("For Test Press 1 otherwise 2 to Exit");
            System.out.print("Enter 1 or 2 : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Options ====> 1. Register");
                        System.out.println("              2. Login");
                        System.out.println("              3. Exit");

                        System.out.print("Enter Option : ");
                        int option = sc.nextInt();
                        sc.nextLine();
                        switch (option) {
                            case 1:
                                System.out.println("Provide your details here..!");
                                System.out.print("Enter UserName: ");
                                String uName = sc.nextLine();

                                System.out.print("Enter Password: ");
                                String uPassword = sc.nextLine();

                                System.out.print("Enter your phone number: ");
                                long phoneNo = sc.nextLong();
                                oes.registerUser(uName,uPassword,phoneNo);
                                flag = true;
                                break;
                            case 2:
                                System.out.println("Login first to start the test");
                                System.out.print("Enter User Name: ");
                                String name = sc.nextLine();
                                System.out.print("Enter Password: ");
                                String password = sc.nextLine();
                                oes.login(name,password);
                                flag = true;
                                break;
                            case 3:
                                flag = false;
                                oes.logOut();
                                break;
                            default:
                                System.out.println("Choose a correct option");
                                break;
                        }
                    } while (flag);
                    break;
                case 2 :
                    System.out.println("Thanks you");
                    exit = false;
                    break;
                    default:
                    System.out.println("Choose correct Option");
                    break;
            }
        }while (exit);
    }
}
