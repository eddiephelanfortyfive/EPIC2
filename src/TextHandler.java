import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class TextHandler {
    private static final String USERS_FILE_PATH = "users.csv";
    private static final String TAXIS_FILE_PATH = "Taxis.csv";
    public int getLines(String file){
        int count=0;
        try (BufferedReader resultReader = new BufferedReader(new FileReader(file))) {
            while ((resultReader.readLine()) != null) {
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
    public User[] readUsersAndPasswords() {
        User[] usersAndPasswords = new User[getLines(USERS_FILE_PATH)];
        try (BufferedReader resultReader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;
            int i = 0;
            while ((line = resultReader.readLine()) != null) {
                String[] values = line.split(",");
                usersAndPasswords[i] = new User(values[0], values[1]);
                i++;
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
    public Taxi[] readTaxiData() {
        Taxi[] TaxiData = new Taxi[getLines(TAXIS_FILE_PATH)];
        try (BufferedReader resultReader = new BufferedReader(new FileReader(TAXIS_FILE_PATH))) {
            String line;
            int i = 0;
            while ((line = resultReader.readLine()) != null) {
                String[] values = line.split(",");
                TaxiData[i] = new Taxi(values[0], values[1], Integer.parseInt(values[2]),values[3],values[4],Integer.parseInt(values[5]));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TaxiData;
    }
}
