import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class NetworkingMethods {
    public static String getJsonInStringFrom(URL url) throws IOException {
        try (
            InputStream inputStream = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            // Reading
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
            bufferedReader.close();

            return response.toString();
        }
    }

    public static List<User> parseUsersJSON(String userJSON) {
        // Parsing with com.google.gson.Gson
        Gson gson = new Gson();
        Type userListType = (new TypeToken<List<User>>() {}).getType(); // creating anonymous class from superclass TypeToken
        return gson.fromJson(userJSON, userListType);
    }

    public static List<Continent> parseContinentsJSON(String userJSON) {
        Gson gson = new Gson();
        Type continentListType = (new TypeToken<List<Continent>>() {}).getType();
        return gson.fromJson(userJSON, continentListType);
    }
}
