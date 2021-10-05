public class WebSite {
    private String url;
    private String name;
    private int currentDayVisit;
    private int totalVisits;

    public WebSite() {
        super();
    }

    public WebSite(String url, String name, int currentDayVisit, int totalVisits) {
        super();
        this.url = url;
        this.name = name;
        this.currentDayVisit = currentDayVisit;
        this.totalVisits = totalVisits;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentDayVisit() {
        return currentDayVisit;
    }

    public void setCurrentDayVisit(int currentDayVisit) {
        this.currentDayVisit = currentDayVisit;
    }

    public int getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(int totalVisits) {
        this.totalVisits = totalVisits;
    }
}
