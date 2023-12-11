import java.util.Random;

public class Main {
    public static void main(String[] args) {
      AppLogic.clearConsole();
       Login newLogin = new Login();
       newLogin.loginOrSignUp();
       AppLogic.anythingToContinue();
       AppLogic.clearConsole();
       TaxiAppUI.generateMap();

    }


    }