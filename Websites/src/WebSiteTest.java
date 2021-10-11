import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import static java.util.Collections.*;

public class WebSiteTest {
    private static List<WebSite> webSites = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input;

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

            if (input >= 1 && input <= 3) {
                break;
            }
        }

        if (input == 2) {
            initializeWebSiteList();

            for (int i = 0; i < 5; i++) { // Set I originally to 5
                System.out.println("-----------[Day " + (i + 1) + " ]-----------");
                visit20WebsitesRandomly();
                displayPopularWebSiteEachDay();
            }

            System.out.println("********* Top 3 WebSites **********");
            displayTop3PopularWebSite();
        } else {
            getWebsitesFromInput();

            for (int i = 0; i < 5; i++) { // Set I originally to 5
                System.out.println("-----------[Day " + (i + 1) + " ]-----------");
                visit20WebsitesRandomly();
                displayPopularWebsitesPerDay();
            }

            System.out.println("********* Top 3 WebSites **********");
            displayPopularWebsitesTop3();
        }
    }

    private static void getWebsitesFromInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int input;
            System.out.println("Please choose: ");
            System.out.println(" - Add a website manually by inputting (1)");
            System.out.println("Else");
            System.out.println(" - Exit (2)");

            try {
                // grab the choice
                // System.out.print(" Input choice 2 to begin: ");
                System.out.print("choice: ");
                input = scanner.nextInt();
                scanner.nextLine();

            } catch (Exception e) {
                continue;
            }


            if (input == 2) {
                //webSite.toString();
                System.out.println(" Bye");
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
                // webSite.toString();
                //System.out.println(webSite);
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
            Reader reader = new FileReader(projectSourceDir + "/websites.json");
            // parse the websites as json array
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            // iterate and create website objects
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                // get the website object
                JSONObject websiteObj = (JSONObject) iterator.next();

                // get the properties
                String url = websiteObj.get("url").toString();
                String name = websiteObj.get("name").toString();
                int currentDayVisit = Integer.parseInt(websiteObj.get("currentDayVisit").toString());
                int totalVisits = Integer.parseInt(websiteObj.get("totalVisits").toString());

                WebSite webSite = new WebSite(url, name, currentDayVisit, totalVisits);
                webSites.add(webSite);
                System.out.println(websiteObj.toString());
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void visit20WebsitesRandomly() {
        Random rand = new Random();

        // grab the actual number or count of website
        // since you want to loop or randomize base on the number of websites
        // this is to avoid any index bounds exception.
        int webSiteCount = webSites.size();

        for (int i = 0; i < webSiteCount; i++) {
            // select random website from among the available websites
            // this will generate random index from 0 - (webSiteCount - 1)
            int randomIndex = rand.nextInt(webSiteCount);

            // Generate random number 0-3 for daily visit
            int randomNumberOfVisits = rand.nextInt(4);

            int totalVisits = webSites.get(randomIndex).getTotalVisits();

            webSites.get(randomIndex).setCurrentDayVisit(randomNumberOfVisits);
            webSites.get(randomIndex).setTotalVisits(totalVisits + randomNumberOfVisits);
            //System.out.println(rand.toString());
        }
    }


    private static void displayPopularWebSiteEachDay() {
        sort(webSites, new SortWebSitesByCurrentDayVisit());

        for (int i = 0; i < webSites.size(); i++) {
            System.out.printf("%-30s  : [" + (i + 1) + "]\n", webSites.get(i).getUrl());
        }
    }
    private static void displayTop3PopularWebSite() {
        sort(webSites, new SortWebSitesByTotelVisit());

        int upperBound = webSites.size()-3;
        for (int i = 0; i<upperBound; i++) {
            System.out.printf("%-20s [totelVisit : %s] : [" + (i + 1) + "]\n", webSites.get(i).getUrl(),
                    webSites.get(i).getTotalVisits());
        }
    }

    private static void displayPopularWebsitesPerDay() {
        int n = webSites.size();

        // convert to array
        WebSite[] sites = webSites.toArray(WebSite[]::new);

        // sort the websites by current day visit
        for (int i = 0; i < n; i++) {
            int maxRank = i;
            for (int j = i + 1; j < n; j++) {
                if (sites[j].getCurrentDayVisit() > sites[maxRank].getCurrentDayVisit()) {
                    maxRank = j;
                }
            }

            WebSite temp = sites[maxRank];
            sites[maxRank] = sites[i];
            sites[i] = temp;
        }

        for (int i = 0; i < sites.length; i++) {
            System.out.printf("%-30s  : [" + (i + 1) + "]\n", sites[i].getUrl());
        }
    }

    private static void displayPopularWebsitesTop3()
    {
        int n = webSites.size();

        // convert to array
        WebSite[] sites = webSites.toArray(WebSite[]::new);

        // sort the websites by total visit
        for (int i = 0; i < n; i++) {
            int maxRank = i;
            for (int j = i + 1; j < n; j++) {
                if (sites[j].getTotalVisits() > sites[maxRank].getTotalVisits()) {
                    maxRank = j;
                }
            }

            WebSite temp = sites[maxRank];
            sites[maxRank] = sites[i];
            sites[i] = temp;
        }

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-20s [totalVisit : %s] : [" + (i + 1) + "]\n", sites[i].getUrl(),
                    sites[i].getTotalVisits());
        }
    }
}

   /* private static void displayTop3PopularWebSite() {
        Collections.sort(webSites, new SortWebSitesByTotelVisit());

        for (int i = 0; i < 3; i++) {
            System.out.printf("%-20s [totelVisit : %s] : [" + (i + 1) + "]\n", webSites.get(i).getUrl(),
                    webSites.get(i).getTotalVisits());
        }
    }*/

/* private static void displayTop3PopularWebSite() {

     //Collections.sort(webSites, new SortWebSitesByTotelVisit());
     int upperBound = webSites.size() & webSites.size();
     for (int i = 0; i < upperBound; i++) {
         System.out.printf("%-20s [totelVisit : %s] : [" + (i + 1) + "]\n", webSites.get(i).getUrl(),
                 webSites.get(i).getTotalVisits());
     }
    /* Collections.sort(webSites, new SortWebSitesByTotelVisit());

     for (int i = 0; i < 3; i++) {
         System.out.printf("%-20s [totelVisit : %s] : [" + (i + 1) + "]\n", webSites.get(i).getUrl(),
                 webSites.get(i).getTotalVisits());


 /**
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
