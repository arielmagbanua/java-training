public abstract class MediaItem extends Item {
    private double runtime;

    public MediaItem(String id, String title) {
        super(id, title);
    }

    public MediaItem(String id, String title, double runtime) {
        super(id, title);
        this.runtime = runtime;
    }

    public double getRuntime() {
        return runtime;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return String.format(
                "Id: %s\nTitle: %s\nIn Stock: %s\nRuntime: %.2f",
                this.getId(),
                this.getTitle(),
                this.isAvailable() ? "Yes" : "No",
                this.getRuntime()
        );
    }
}
