import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class WebSiteTest {
    private static List<WebSite> webSites = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = -1;

        while (true) {
            System.out.println("Please choose: ");
            System.out.println(" - Manually Input Websites (1)");
            System.out.println(" - Read from Json file (2)");

            try {
                // grab the choice
                System.out.print("choice: ");
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                continue;
            }

            if (input >= 1 && input <=3) {
                break;
            }
        }

        if (input == 2) {
            initializeWebSiteList();
        } else {
            getWebsitesFromInput();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("-----------[Day " + (i + 1) + " ]-----------");
            visit10WebsiteRandomly();
            displayPopularWebSiteEachDay();
        }

        System.out.println("********* Top 3 WebSites **********");
        displayTop3PopularWebSite();
    }

    private static void getWebsitesFromInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int input = -1;
            System.out.println("Please choose: ");
            System.out.println(" - Add website (1)");
            System.out.println(" - Exit (2)");

            try {
                // grab the choice
                System.out.print("choice: ");
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                continue;
            }

            if (input == 2) {
                break;
            } else {
                // scan for website properties and add to websites
                System.out.print("url: ");
                String url = scanner.nextLine();
                System.out.print("name: ");
                String name = scanner.nextLine();
                System.out.print("Current day visit: ");
                int currentDayVisit = scanner.nextInt();
                System.out.print("Total visits: ");
                int totalVisits = scanner.nextInt();

                // create website instance and add it
                WebSite webSite = new WebSite(url, name, currentDayVisit, totalVisits);
                webSites.add(webSite);
            }
        }
    }

    /**
     * Initialize and read the websites from json file
     */
    private static void initializeWebSiteList() {
        // read json file

        JSONParser parser = new JSONParser();

        // get the project source directory
        String projectSourceDir = Paths.get("src")
                .toAbsolutePath()
                .toString();

        try {
            // read the json file
            Reader reader = new FileReader(projectSourceDir + "./websites.json");
            // parse the websites as json array
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            // iterate and create website objects
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                // get the website object
                JSONObject websiteObj = (JSONObject)iterator.next();

                // get the properties
                String url = websiteObj.get("url").toString();
                String name = websiteObj.get("name").toString();
                int currentDayVisit = Integer.parseInt(websiteObj.get("currentDayVisit").toString());
                int totalVisits = Integer.parseInt(websiteObj.get("totalVisits").toString());

                WebSite webSite = new WebSite(url, name, currentDayVisit, totalVisits);
                webSites.add(webSite);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void visit10WebsiteRandomly() {
        Random rand = new Random();

        for (int i = 0; i < webSites.size(); i++) {
            // select random website from 20
            int random_integer1 = rand.nextInt(20);

            // Generate random number 0-3 for daily visit
            int random_integer2 = rand.nextInt(4);

            int totalVisit = webSites.get(random_integer1).getTotalVisits();
            webSites.get(random_integer1).setCurrentDayVisit(random_integer2);
            webSites.get(random_integer1).setTotalVisits(totalVisit + random_integer2);
        }
    }

    private static void displayPopularWebSiteEachDay() {
        Collections.sort(webSites, new SortWebSitesByCurrentDayVisit());

        for (int i = 0; i < webSites.size(); i++) {
            System.out.printf("%-30s  : [" + (i + 1) + "]\n", webSites.get(i).getUrl());
        }
    }

    private static void displayTop3PopularWebSite() {
        Collections.sort(webSites, new SortWebSitesByTotelVisit());

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-20s [totelVisit : %s] : [" + (i + 1) + "]\n", webSites.get(i).getUrl(),
                    webSites.get(i).getTotalVisits());
        }
    }
}

/**
 *
 * Comparator class for Sort Web Sites By CurrentDayVisit descending order
 */
class SortWebSitesByCurrentDayVisit implements Comparator<WebSite> {
    @Override
    public int compare(WebSite o1, WebSite o2) {
        return o2.getCurrentDayVisit() - o1.getCurrentDayVisit();
    }
}

/**
 *
 * Comparator class for Sort WebSites By TotelVisit descending order
 */
class SortWebSitesByTotelVisit implements Comparator<WebSite> {
    @Override
    public int compare(WebSite o1, WebSite o2) {
        return o2.getTotalVisits() - o1.getTotalVisits();
    }
}
