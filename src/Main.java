

public class Main {
    public static void main(String[] args) {
       Login newLogin = new Login();
       newLogin.loginOrSignUp();
       AppLogic.anythingToContinue();
       AppLogic.clearConsole();
       TaxiAppUI.generateMap();

    }
}