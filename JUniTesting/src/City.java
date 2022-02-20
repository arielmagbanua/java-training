import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class City {
    public static HashMap<String, City> cities = new HashMap<String, City>();
    public String name;
    public final HashSet<Link> links = new HashSet<Link>();
    public int distance;
    public Link parent;
    public City(String nm) {
        name = nm;
        cities.put(name, this);
    }
    public static City find(String nm) {
        City p = cities.get(nm);
        if (p == null) {
            p = new City(nm);
            return null;
        }
        return p;
    }

    public void addLink(Link lnk) {
        links.add(lnk);
    }

    public int compareTo(City p) {
        return this.name.compareTo(p.name);
    }
    public String toString() {
        return name;
    }
    public int compare(City c1, City c2) {
        return c1.distance - c2.distance;
    }
    public boolean getLinksTo(City dest, Set<Link> routeLinks) {
        for (Link l : links) {
            if (l.isUsed() && (l != parent)) {
                City child = l.getAdj(this);
                if ((dest == child) || child.getLinksTo(dest, routeLinks)) {
                    routeLinks.add(l);
                }
            }
        }
        return false;
    }
}
