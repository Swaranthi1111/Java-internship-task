
package tasks.task2_Number_Guessing;

import java.util.Random;
import java.util.Scanner;

public class Number_Guessing {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int min = 1;
        int max = 100;
        int num = ran.nextInt(min,max+1);

        System.out.println();
        System.out.println("Guess the number b/w "+min+" to "+max);

        int lives = 7;
        int games = 7;

        System.out.println("You have "+lives+" lives to win this game");
        System.out.println("+-----------------------------------+");
        while (games-->0){

            System.out.print("Enter the guessed number : ");
            int guess= sc.nextInt();
            if(guess>num){
                System.out.println("Entered number higher ");
                lives--;
                System.out.println("You have "+lives+" live left..");
            } else if (guess<num) {
                System.out.println("Entered number is lower ");
                lives--;
                System.out.println("You have "+lives+" live left..");
            }
            else {
                System.out.println("Excellent, you guessed a right number !");
            }
        }
        if(lives==0){
            System.out.println("Oops, you have lost the game, Try again");
            System.out.println("Correct number is : "+num);
        }
    }
}
