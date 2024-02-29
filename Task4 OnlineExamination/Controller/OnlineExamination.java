
package tasks.task4_Online_Examination.controller;

import tasks.task4_Online_Examination.bean.Questions;
import tasks.task4_Online_Examination.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Online_Examination_System {

    private boolean isLoggedIn;
    int timeRemaining = 3;
    int points = 0;

    Scanner sc = new Scanner(System.in);
    List<User> userList = new ArrayList<>();
    List<Questions> questions = new ArrayList<>();


    public void registerUser(String name, String password, long phoneNo){

        boolean userExist  = false;
        User addUser = new User(name,password,phoneNo);
        for(User user1:userList){
            if(name.equals(user1.getUserName()) && password.equals(user1.getUserPassword()) ){
                System.out.println("User Already Exists..!");
                userExist = true;
                break;
            }
        }
        if(!userExist){
            userList.add(addUser);
            System.out.println("Registered Successfully..!");
        }

    }

    public void login(String name, String password){
        boolean logFailed = false;
        for(User userData:userList) {

            if (name.equals(userData.getUserName()) && password.equals(userData.getUserPassword())) {

                isLoggedIn = true;
                logFailed = true;
                System.out.println("Logging Successfully..!");
                System.out.println("Best of luck for your exam");
                System.out.println();
                startExam();
                break;
            }
        }
        if(!logFailed){
            System.out.println("Login Failed..!🙅, Try Again..!");
            System.out.print("If forget password press 1 else 0 : ");
            int choice = sc.nextInt();
            if(choice==1){
                changePassword();
            }
        }
    }

    public void logOut(){
        isLoggedIn = false;
        System.out.println("Logged Out Successfully..!");
    }

    public void changePassword(){

        System.out.print("Enter your phone number : ");
        long phNum = sc.nextLong();

        for(User user1:userList){
            if(phNum==user1.getPhoneNo()){
                sc.nextLine();
                System.out.print("Enter your new password: ");
                String userPass = sc.nextLine();

                user1.setUserPassword(userPass);
                System.out.println("Password Changed Successfully...");
                break;
            }
        }
    }
    public void examQuestions(){

        questions.clear();  // clear the list before every new exam.

        String q1 ="Q1. What is the capital of India?";
        questions.add(new Questions(q1,List.of("1) Delhi","2) Lahore"),1));
        String q2 ="Q2. Which Programming language is known as 'Mother of all Language'?";
        questions.add(new Questions(q2,List.of("1) Python","2) Java"),2));
        String q3 ="Q3. Which one on these is biggest mammal?";
        questions.add(new Questions(q3,List.of("1) Giraffe","2) Elephant"),2));

        for(Questions examQues:questions){
            System.out.println(examQues.getQuestions());
            System.out.println("     "+examQues.getOptions());
            int userAns = sc.nextInt();
            if(userAns==examQues.getCorrectAnswer()){
                points = points+10;
            }
            else {
                points = points-5;
            }
        }

        System.out.println();
        System.out.println("Press 's' to submit");
        String sub = sc.next().toLowerCase();
        if(sub.equals("s")){
            System.out.println("submitted..!");
            result();
        }
    }

    public void startExam(){

        if(!isLoggedIn){
            System.out.println("Check credentials again..!");
        }
        else {
            System.out.println("----------------- Test -----------------");
            System.out.println();
            System.out.println("You have "+timeRemaining+" minutes to complete your exam");
            System.out.println("Note -: For each correct answer you get 10 Points and for incorrect answer 5 points will be deducted.");
            examQuestions();
        }
    }

    public void result(){
        System.out.println("\n+----------Result----------+\n    Your Score : "+points+"/30");
        System.out.println();
        points = 0;
    }

}
