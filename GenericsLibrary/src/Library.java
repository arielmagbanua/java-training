import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Library<E> {
    private Class<E> resourceClass = null;
    private final List<E> resources = new ArrayList<E>();
    private String resourceFilePath;

    public Library(Class<E> resourceClass, String resourceFilePath) {
        this.resourceClass = resourceClass;
        this.resourceFilePath = resourceFilePath;

        loadResources(resourceFilePath);
    }

    public void addMedia(E x) {
        resources.add(x);
    }

    public E retrieveLast() {
        int size = resources.size();
        if (size > 0) {
            return (E)resources.get(size - 1);
        }
        return null;
    }

    public E search(String name) {
        // looks for the item by name in the list of resources
        return (E)resources.stream()
                .filter(resource -> resource.toString().equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Loads the entire library from a json file.
     *
     * @param filename The name of json file.
     */
    public void loadResources(String filename) {
        resourceFilePath = filename;

        // get the project source directory
        String projectSourceDir = Paths.get("src")
                .toAbsolutePath()
                .toString();

        try {
            // read the json file
            Reader reader = new FileReader(projectSourceDir + "/" + filename);

            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray)parser.parse(reader);

            // iterate and create resource objects
            for (Object o : jsonArray) {
                // get the object
                JSONObject jsonObject = (JSONObject) o;
                String name = jsonObject.get("name").toString();

                // create an instance of the object with expected constructor that needs a string argument.
                E item = resourceClass.getDeclaredConstructor(String.class)
                        .newInstance(name);

                // add to the resources
                resources.add(item);
            }

        } catch (ParseException | IOException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        // get the project source directory
        String projectSourceDir = Paths.get("src")
                .toAbsolutePath()
                .toString();

        Gson gson = new Gson();

        // parser for parsing the json representation of each resource
        JSONParser parser = new JSONParser();

        // create the json array
        JSONArray jsonArray = new JSONArray();

        try {
            // create json object per resource
            for (E item: resources) {
                String jsonStr = gson.toJson(item);
                JSONObject jsonObject = (JSONObject) parser.parse(jsonStr);
                // add the json object
                jsonArray.add(jsonObject);
            }

            // write the json
            FileWriter writer = new FileWriter(projectSourceDir + "/" + resourceFilePath);
            writer.write(jsonArray.toJSONString());

            // close the writer
            writer.flush();
            writer.close();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
