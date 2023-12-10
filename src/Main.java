import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
      AppLogic.clearConsole();
       Login newLogin = new Login();
       newLogin.loginOrSignUp();
       AppLogic.anythingToContinue();
       AppLogic.clearConsole();
       TaxiAppUI.generateMap();

    }


    }