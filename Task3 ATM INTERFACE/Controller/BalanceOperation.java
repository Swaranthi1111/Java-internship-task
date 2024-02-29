
package tasks.task3_Atm_Interface.controller;

import tasks.task3_Atm_Interface.bean.Transaction;
import tasks.task3_Atm_Interface.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalanceOperation {

    Scanner sc = new Scanner(System.in);

    List<User> users = new ArrayList<>();
    List<Transaction> transactions = new ArrayList<>();

    public List<User> addUser(User userData){

        boolean userExist = false;
        for(User user : users ){
            if(user.getPhone()==userData.getPhone()){
                System.out.println("User already exist...!");
                userExist = true;
                break;
            }
        }
        if(!userExist){
            users.add(userData);
            System.out.println("Your Account has been created..!");
            System.out.println("Your Account Number is : "+userData.getAccNum());
        }
        return users;
    }

    public void getUser(long accNum, int pin){
        boolean userExist = false;

        for(User user:users){
            if(user.getAccNum()==accNum && user.getPassword()==pin){
                displayUser(user);
                userExist = true;
                break;
            }
        }
        if(!userExist){
            System.out.println("Check the PIN and Account Number Again..!");
        }
    }

    public void deposit(double amount,long accNum,int pin){
        boolean userExist = false;

        for(User user:users){
            if(user.getAccNum()==accNum && user.getPassword()==pin){
                double currentAmt =  user.getBalance();
                double updatedAmt = currentAmt+amount;
                user.setBalance(updatedAmt);
                System.out.println("Money deposited successfully..!");
                displayUser(user);
                userExist = true;
                addTransaction(user,"deposit",amount);
                break;
            }
        }
        if(!userExist){
            System.out.println("Check the PIN and Account Number Again..!");
        }
    }

    public void withdrawMoney(double amount,long accNum, int pin){
        boolean userExist = false;

        for(User user:users){
            if(user.getAccNum()==accNum && user.getPassword()==pin){
                double currentAmt =  user.getBalance();
                while (amount>currentAmt){
                    System.out.println("Entered Amount is greater then the available balance..");
                    System.out.println("Your current balance is : "+currentAmt);
                    System.out.println();
                    System.out.print("Enter the new Amount : ");
                    amount = sc.nextDouble();
                }
                double updatedAmt = currentAmt-amount;
                user.setBalance(updatedAmt);
                System.out.println("Amount deducted successfully..!");
                addTransaction(user,"withdrawal",amount);
                displayUser(user);
                userExist = true;
                break;
            }
        }
        if(!userExist){
            System.out.println("Check the PIN and Account Number Again..!");
        }
    }

    public void changePIN(long accNum, int pin){
        for(User user:users){
            if(accNum== user.getAccNum() && pin==user.getPassword()){
                System.out.print("Enter the new PIN: ");
                int newPin = sc.nextInt();
                System.out.print("Confirm the new PIN again: ");
                int againPIN = sc.nextInt();
                if(newPin==againPIN){
                    user.setPassword(newPin);
                    System.out.println("Your PIN have been Changed..! 😶🔥");
                }
            }
        }
    }

    public void transferMoney(long accNum,int pin,long transferAccNum, double amt){

        for(User user:users){
            if(accNum==user.getAccNum() && pin==user.getPassword()){
               double currentAmt = user.getBalance();
               user.setBalance(currentAmt-amt);
                addTransaction(user,"Transfer",amt);
                System.out.println();
                System.out.println("Your Current Balance...! ");
                displayUser(user);
            }

            if(transferAccNum==user.getAccNum()){

                double transUserBalance = user.getBalance();
                user.setBalance(transUserBalance+amt);
                addTransaction(user,"Transfer",amt);
                System.out.println("Payment Done successfully..!");

            }
            else {
                System.out.println("Account number not existed..");
            }
        }
    }

    public void addTransaction(User user, String type,double amount){
        Transaction transaction = new Transaction(user,type,amount);
           transactions.add(transaction);
    }

    public void getTransactionDetails(long accNum){
        List<Transaction> addTransaction = new ArrayList<>();
        System.out.println("+----------------------------------------------------------------------------------------------------------+");
        System.out.format("|\t%-20s|\t%-20s|\t%-20s|\t%-26s|\n","Account Holder","Type","Amount","Time");
        System.out.println("+----------------------------------------------------------------------------------------------------------+");
        for(Transaction transaction : transactions){
            if(accNum==transaction.getUser().getAccNum()){
                addTransaction.add(transaction);
                 displayTransaction(transaction);
            }
        }
    }

    public void displayUser(User user){
        System.out.println("+-----------------------------------------------------------------------------------------+");
        System.out.format("|\t%-20s|\t%-20s|\t%-20s|\t%-14s|\n","Account Holder","Phone Number","Account Number","Balance");
        System.out.println("+-----------------------------------------------------------------------------------------+");
        System.out.format("|\t%-20s|\t%-20d|\t%-20d|\t%-14s|\n",user.getUserName(),user.getPhone(),user.getAccNum(),user.getBalance());
        System.out.println("+-----------------------------------------------------------------------------------------+");
    }

    public void displayTransaction(Transaction transaction){
        System.out.format("|\t%-20s|\t%-20s|\t%-20s|\t%-14s|\n",transaction.getUser().getUserName(),transaction.getType(),transaction.getAmt(),transaction.getCurrentTime());
        System.out.println("+----------------------------------------------------------------------------------------------------------+");
    }
}
