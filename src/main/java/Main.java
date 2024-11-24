import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            URL usersURL = new URL("https://fake-json-api.mock.beeceptor.com/users");
            String usersJSON = NetworkingMethods.getJsonInStringFrom(usersURL);
            List<User> receivedUsers = NetworkingMethods.parseUsersJSON(usersJSON);

            for (User user : receivedUsers) {
                System.out.println(user);
            }

            URL continentsURL = new URL("https://dummy-json.mock.beeceptor.com/continents");
            String continentsJSON = NetworkingMethods.getJsonInStringFrom(continentsURL);
            List<Continent> receivedContinents = NetworkingMethods.parseContinentsJSON(continentsJSON);

            for (Continent continent : receivedContinents) {
                System.out.println(continent);
            }
        } catch (MalformedURLException e) {
            System.err.println("Exception while opening URL, incorrect URL exception. Details: " + e);
        } catch (IOException e) {
            System.err.println("Exception while opening URL input stream. Details: " + e);
        }
    }
}
