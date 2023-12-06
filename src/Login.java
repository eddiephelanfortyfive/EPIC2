import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public void loginOrSignUp(){
        Scanner input = new Scanner(System.in);
        TextHandler text = new TextHandler();
        ArrayList<User> usernames =text.readUsersAndPasswords();
        System.out.println("---\nWelcome to the TaxiApp.\n Sign up [0]\n or\n Log in[1]");
        for(int i =0; i<1; i++) {
            String logInOrSignUp = input.nextLine();
            if (logInOrSignUp.equals("0")) {
                signUpToApp(usernames,text);
            } else if (logInOrSignUp.equals("1")) {
                loginToApp(usernames, text);
            } else {--i;
                System.out.println("Invalid input please try again.");
            }
        }
    }
    public void loginToApp( ArrayList<User> usernames,TextHandler text){
        Scanner input = new Scanner(System.in);
        for(int i=0; i<1; i++) {
            System.out.println("---\nLogin please enter your username: ");
            String username = input.nextLine();
            String usernameLowerCase = username.toLowerCase();
            if (doesContain(usernameLowerCase, usernames) != -1) {
                int index = doesContain(usernameLowerCase, usernames);
                System.out.println("Welcome back " + username + " please enter your password.");
                for (int k = 0; k < 1; k++) {
                    String password = input.nextLine();
                    if (password.equals((usernames.get(index)).getPassword())) {
                        System.out.println("Correct, you are now logged into the account " + username);
                    } else {
                        System.out.println("Incorrect password for the account " + username + " please try again.");
                        k--;
                    }
                }
            } else {
                System.out.println("The account " + username + " does not exist.\n Would you like to try again?[0]\n Or\n Sign up?[1]");
                for (int j = 0; j < 1; j++) {
                    String choice = input.nextLine();
                    if (choice.equals("0")) {
                        i--;
                        System.out.println("You chose to try again.");

                    } else if (choice.equals("1")) {
                        System.out.println("You chose Sign up.");
                        signUpToApp(usernames, text);
                    } else {
                        System.out.println("Invalid input please try again.");
                        j--;

                    }
                }

            }

        }
    }
    public void signUpToApp( ArrayList<User> usernames, TextHandler text){
        Scanner input = new Scanner(System.in);
    for(int i=0; i<1; i++){
        System.out.println("---\nSign up enter your chosen username: ");
        String username=input.nextLine();
        String usernameLowerCase = username.toLowerCase();
        if(doesContain(usernameLowerCase, usernames)!=-1) {
            System.out.println("The account "+username+" already exists.\n Would you like to log in to this account?[0]\n Or\n Input a different username?[1]\n");
            for(int j=0; j<1; j++) {
                String choice = input.nextLine();
                if (choice.equals("0")) {
                    System.out.println("You chose to login to the account "+username);
                    loginToApp(usernames, text);
                } else if (choice.equals("1")) {
                    i--;
                    System.out.println("You chose to input a different username.");
                } else {
                    System.out.println("Invalid input please try again.");
                    j--;

                }
            }


        }else{
            System.out.println("---\nWelcome "+username+" please enter your chosen password:");
            String password= input.nextLine();
            String passwordLowerCase = password.toLowerCase();
            text.writeInNewUser(usernameLowerCase,passwordLowerCase);
            System.out.println("Congratulations "+username+" you are now registered!");
        }

        }
    }
    public int doesContain(String username, ArrayList<User> usernames) {
        int result = -1;
        for (int i = 0; i < usernames.size(); i++) {
            if (username.equals((usernames.get(i)).getUsername())) {
                result = i;
                break;
            }
        }
        return result;
    }


}
