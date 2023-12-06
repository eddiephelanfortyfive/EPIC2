import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       TaxiAppUI.generateMap();
       Login newLogin = new Login();
       newLogin.loginOrSignUp();
    }
}