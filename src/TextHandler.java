import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class TextHandler {
    private static final String USERS_FILE_PATH = "users.csv";
    public ArrayList<User> readUsersAndPasswords(){
        ArrayList<User> usersAndPasswords = new ArrayList<>();
        try (BufferedReader resultReader = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;

            while ((line = resultReader.readLine()) != null) {
                String[] values = line.split(",");
                usersAndPasswords.add(new User(values[0],values[1]));
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
}
