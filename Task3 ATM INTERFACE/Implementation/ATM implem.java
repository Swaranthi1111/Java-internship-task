
package tasks.task3_Atm_Interface.implementation;

import tasks.task3_Atm_Interface.bean.User;
import tasks.task3_Atm_Interface.controller.BalanceOperation;

import java.util.Random;
import java.util.Scanner;

public class Atm_Impl {

    public static void main(String[] args) {

        BalanceOperation balanceOperation =  new BalanceOperation();

        Scanner sc = new Scanner(System.in);

        System.out.println("ATM Interface...!");
        System.out.println();
        boolean flag = false;
        do{
            System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw Money\n4. Change PIN\n5. Transfer Money\n6. Transaction Details\n7. Create Account");

            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter your account number : ");
                    long accountNum = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter your pin: ");
                    int pin_pass = sc.nextInt();

                    balanceOperation.getUser(accountNum,pin_pass);
                    flag = true;
                    break;
                case 2:
                    System.out.print("Enter the Account number : ");
                    long accNum1 = sc.nextLong();

                    System.out.print("Enter your PIN : ");
                    int userPin1 = sc.nextInt();

                    System.out.print("Enter the amount you want to deposit : ");
                    double amount1 = sc.nextDouble();
                    balanceOperation.deposit(amount1,accNum1,userPin1);

                    flag = true;
                    break;
                case 3:
                    System.out.print("Enter the Account number : ");
                    long accNum2 = sc.nextLong();

                    System.out.print("Enter your PIN : ");
                    int userPin2 = sc.nextInt();

                    System.out.print("Enter the amount you want to withdraw : ");
                    double amount2 = sc.nextDouble();
                    balanceOperation.withdrawMoney(amount2,accNum2,userPin2);
                    flag = true;
                    break;
                case 4:
                    System.out.print("Enter the Account number : ");
                    long accNum3 = sc.nextLong();

                    System.out.print("Enter your PIN : ");
                    int userPin3 = sc.nextInt();

                    balanceOperation.changePIN(accNum3,userPin3);
                    flag = true;
                    break;
                case 5:
                    System.out.print("Enter your account number : ");
                    long accNum4 = sc.nextLong();

                    System.out.print("Enter your PIN : ");
                    int userPin4 = sc.nextInt();

                    System.out.print("Enter Transfer Account Number : ");
                    long tAccNum = sc.nextLong();

                    System.out.print("Enter the amount you want to transfer : ");
                    double money = sc.nextDouble();

                    balanceOperation.transferMoney(accNum4,userPin4,tAccNum,money);
                    flag = true;
                    break;
                case 6:
                    System.out.print("Enter your Account Number: ");
                    long accNumber = sc.nextLong();
                    balanceOperation.getTransactionDetails(accNumber);
                    flag = true;
                    break;
                case 7:
                    Random ran = new Random();
                    long accNum = ran.nextLong(1,9999999999999L);
                    sc.nextLine();
                    System.out.print("Enter your Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Your Phone Number : ");
                    long phoneNum = sc.nextLong();
                    boolean pinCorrect = false;
                    int userPin=1111;

                    while (!pinCorrect){
                        System.out.print("Enter your Pin : ");
                        userPin = sc.nextInt();
                        if(userPin>9999 || userPin<1000){
                            System.out.println("PIN should be of 4 Digits..!");
                            System.out.println();
                            System.out.println("Enter PIN Again");
                        }
                        else {
                            pinCorrect=true;
                        }
                    }
                    System.out.println("Deposit At least 2000 rupees..!");
                    System.out.print("Enter the Amount: ");
                    double amt = sc.nextDouble();

                    User user = new User(name,userPin,phoneNum,accNum,amt);
                    balanceOperation.addUser(user);
                    flag = true;
                    break;
                default:
                    System.out.println("Enter a Correct Option..!");
                    flag = true;
                    break;

            }
        }
        while (flag);
    }

}
