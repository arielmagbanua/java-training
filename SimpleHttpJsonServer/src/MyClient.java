import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class MyClient {
    /**
     * Creates and executes a http request to any server.
     *
     * @param verb The verb of the request (GET, POST, PUT, etc...)
     * @param endpoint The url endpoint of the request.
     * @param payload The payload of the request
     * @return Response string from json server.
     * @throws IOException
     */
    public static String executeHttpRequest(String verb, String endpoint, String payload) throws Exception {
        if (endpoint == null || endpoint.isEmpty()) {
            throw new IllegalArgumentException("Url endpoint missing! Please provide one!");
        }

        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod(verb);
        conn.setRequestProperty("Content-Type", "application/json");

        // write the response body
        OutputStream os = conn.getOutputStream();
        os.write(payload.getBytes());
        os.flush();

        int code = conn.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK && code != HttpURLConnection.HTTP_CREATED) {
            // cannot connect to server
            throw new Exception("Something went wrong! \nHTTP error code : " + code);
        }

        // read the response and return it
        InputStreamReader inputStreamReader = new InputStreamReader((conn.getInputStream()));
        BufferedReader br = new BufferedReader(inputStreamReader);
        return br.lines().collect(Collectors.joining());
    }

    /**
     * Retrieve pets by pet type
     *
     * @param type The type of pet
     * @return List of pets
     * @throws IOException
     */
    public static List<Pet> getPetsByType(String type) throws Exception {
        String response = executeHttpRequest(
                "GET",
                "http://localhost:9000/pets",
                String.format("{\"type\": \"%s\"}", type)
        );

        ObjectMapper objectMapper = new ObjectMapper();
        Pet[] pets = objectMapper.readValue(response, Pet[].class);
        return Arrays.asList(pets);
    }

    /**
     * Retrieves all pets
     *
     * @return List of pets
     * @throws IOException
     */
    public static List<Pet> getAllPets() throws Exception {
        String response = executeHttpRequest("GET", "http://localhost:9000/pets", "");

        // convert the response
        ObjectMapper objectMapper = new ObjectMapper();
        Pet[] pets = objectMapper.readValue(response, Pet[].class);
        return Arrays.asList(pets);
    }

    public static void main(String[] args) throws Exception {
        // get all pets
        List<Pet> pets = getAllPets();
        for (Pet pet : pets) {
            System.out.println(pet);
        }

        // attempt to get pets with non-existing type
        List<Pet> petsFoo = getPetsByType("foo");
        System.out.println("pets foo: " + petsFoo.size());

        // get all cats
        List<Pet> cats = getPetsByType("cat");
        for (Pet cat : cats) {
            System.out.println(cat);
            System.out.println("Meowww!");
        }

        // get all dogs
        List<Pet> dogs = getPetsByType("cat");
        for (Pet dog : dogs) {
            System.out.println(dog);
            System.out.println("Arf!");
        }
    }
}
