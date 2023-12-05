import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public void loginOrSignUp(){
        Scanner input = new Scanner(System.in);
        TextHandler text = new TextHandler();
        ArrayList<User> usernames =text.readUsersAndPasswords();
        System.out.println("Welcome to the TaxiApp.\n Sign up [0]\n or\n Log in[1]");
        for(int i =0; i<1; i++) {
            int logInOrSignUp = input.nextInt();
            if (logInOrSignUp == 0) {
                signUpToApp(usernames,text);
            } else if (logInOrSignUp==1) {
                loginToApp(usernames, text);
            } else {--i;
                System.out.println("Invalid input please try again.");
            }
        }
    }
    public void loginToApp( ArrayList<User> usernames,TextHandler text){
        Scanner input = new Scanner(System.in);
        System.out.println("You would like to login please enter your username: ");
        String username=input.nextLine();
        String usernameLowerCase = username.toLowerCase();
        if(doesContain(usernameLowerCase, usernames)!=-1){
            int index =doesContain(usernameLowerCase, usernames);
            System.out.println("Welcome back "+username+" please enter your password.");
            for(int i=0; i<1; i++) {
                String password = input.nextLine();
                if(password.equals((usernames.get(index)).getPassword())){
                    System.out.println("Correct, you are now logged into the account "+username);
                }else{
                    System.out.println("Incorrect password for the account "+username+" please try again.");
                    i--;
                }

                }
            }else{
            System.out.println("The account "+username+" does not exist you are being moved to the signup page");
            signUpToApp(usernames,text);
        }


    }
    public void signUpToApp( ArrayList<User> usernames, TextHandler text){
        Scanner input = new Scanner(System.in);
    System.out.println("You would like sign up with us what is your chosen username: ");
    for(int i=0; i<1; i++){
        String username=input.nextLine();
        String usernameLowerCase = username.toLowerCase();
        if(doesContain(usernameLowerCase, usernames)!=-1) {
            System.out.println("The account "+username+" does not exist you are being moved to the log in page");
            loginToApp(usernames,text);
        }else{
            System.out.println("Welcome "+username+" please enter your chosen password:");
            String password= input.nextLine();
            String passwordLowerCase = password.toLowerCase();
            text.writeInNewUser(usernameLowerCase,passwordLowerCase);
            System.out.println("Congratulations "+username+" you are now registered!");
        }

        }
    }
    public int doesContain(String username, ArrayList<User> usernames){
        int result = -1;
        for (int i=0; i<usernames.size();i++) {
            if (username.equals((usernames.get(i)).getUsername())) {
                result = i;
                break;
            }
        }
        return result;
    }


}
