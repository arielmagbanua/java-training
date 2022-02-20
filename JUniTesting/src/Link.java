public class Link implements Comparable<Link> {
    public City city1;
    public City city2;
    public int length;
    public boolean used = false;
    public Link(City c1, City c2, int len) {
        if (c1.compareTo(c2) < 0) {
            city1 = c1;
            city2 = c2;
        } else {
            city1 = c2;
            city2 = c1;
        }
        length = len;
        c1.addLink(this);
        c2.addLink(this);
        used = true;
    }
    public int getLength() {
        return length;
    }
    public City getAdj(City c) {
        return c == city1 ? city2 : city1;
    }
    public boolean isUsed() {
        return used;
    }
    public void setUsed(boolean u) {
        used = u;
    }

    public String toString() {
        return city1.toString() + " " + city2.toString();
    }
    public int compareTo(Link l) {
        int diff = city1.compareTo(l.city1);
        if (diff == 0) {
            diff = city1.compareTo(l.city1);
        }
        return diff;
    }
}
