import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
@SuppressWarnings({"ClassEscapesDefinedScope", "CallToPrintStackTrace"})
public class TextHandler {
    private static final String USERS_FILE_PATH = "users.csv";
    private static final String TAXIS_FILE_PATH = "Taxis.csv";
    public LinkedList<User> readUsersAndPasswords() {
        LinkedList<User> usersAndPasswords = new LinkedList<>();
        try (BufferedReader resultReader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;
            while ((line = resultReader.readLine()) != null) {
                String[] values = line.split(",");
                usersAndPasswords.insert(new User(values[0], values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersAndPasswords;
    }
    public void writeInNewUser(String username, String password){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE_PATH, true));

            String[] data = { username, password };
            String dataLine = String.join(",", data);
            writer.write(dataLine);
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static LinkedList<Taxi> readTaxiData() {
        LinkedList<Taxi> taxis = new LinkedList<>();
        try (BufferedReader resultReader = new BufferedReader(new FileReader(TAXIS_FILE_PATH))) {
            String line;
            taxis.moveToFirst();
            while ((line = resultReader.readLine()) != null) {
                String[] values = line.split(",");
                taxis.insert( new Taxi(values[0], values[1], Integer.parseInt(values[2]),values[3],values[4],Integer.parseInt(values[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taxis;
    }
}
