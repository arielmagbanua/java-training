import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PetRequestHandler implements HttpHandler {
    // object mapper for mapping json to object and object to json
    private final ObjectMapper objectMapper = new ObjectMapper();

    // data source for all pets
    private final List<Pet> pets = new ArrayList<>();

    public PetRequestHandler() {
        // create pets, they should be fetched from database but for proof of concept this will do the job.
        Pet felix = new Pet("Felix", "cat");
        Pet garfield = new Pet("Garfield", "cat");
        Pet douglas = new Pet("Douglas", "dog");
        Pet bruno = new Pet("Bruno", "dog");
        Pet birdy = new Pet("Birdy", "parrot");
        Pet ninja = new Pet("ninja", "turtle");

        // add all pets
        pets.add(felix);
        pets.add(garfield);
        pets.add(douglas);
        pets.add(bruno);
        pets.add(birdy);
        pets.add(ninja);
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        // get the request payload and convert it as input stream and feed it to the reader
        InputStreamReader inputStreamReader = new InputStreamReader(
                httpExchange.getRequestBody(),
                StandardCharsets.UTF_8
        );
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // read the payload
        String jsonPayload =  bufferedReader.lines().collect(Collectors.joining());

        if (jsonPayload.isEmpty()) {
            // no specific payload meaning client wants to get all pets
            // convert list of members as json array
            jsonPayload = objectMapper.writeValueAsString(pets);
        } else {
            // parse and convert to family request object
            try {
                // convert the payload and get the email
                PetRequestPayload requestPayload = objectMapper.readValue(jsonPayload, PetRequestPayload.class);
                String petType = requestPayload.getType();

                // get the pet that matches the pet type
                List<Pet> pets = new ArrayList<>();
                for (Pet pet : this.pets) {
                    if (pet.getType().equals(petType)) {
                        pets.add(pet);
                    }
                }

                jsonPayload = objectMapper.writeValueAsString(pets);
            } catch (IOException e) {
                // invalid payload
                httpExchange.sendResponseHeaders(400, 0);
                writeHttpResponse(httpExchange.getResponseBody(), "Bad Request");
                return;
            }
        }

        // set the needed headers for creating json response
        Headers headers = httpExchange.getResponseHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");

        // write the response
        httpExchange.sendResponseHeaders(200, jsonPayload.length());
        writeHttpResponse(httpExchange.getResponseBody(), jsonPayload);
    }

    /**
     * Writes the http response.
     *
     * @param outputStream The output stream instance
     * @param message The message to write
     * @throws IOException
     */
    public void writeHttpResponse(OutputStream outputStream, String message) throws IOException {
        outputStream.write(message.getBytes());
        outputStream.close();
    }
}
