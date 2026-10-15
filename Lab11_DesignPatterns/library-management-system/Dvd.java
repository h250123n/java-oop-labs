public class Dvd extends LibraryItem {

    private final int runtimeMinutes;

    public Dvd(String id, String title, int runtimeMinutes) {
        super(id, title);
        if (runtimeMinutes <= 0) {
            throw new IllegalArgumentException("Runtime must be positive");
        }
        this.runtimeMinutes = runtimeMinutes;
    }

    public int getRuntimeMinutes() { return runtimeMinutes; }

    @Override
    public int loanPeriodDays() { return 7; }

    @Override
    public String type() { return "DVD"; }

    @Override
    public String extraField() { return String.valueOf(runtimeMinutes); }

    @Override
    public String toString() {
        return super.toString() + ", " + runtimeMinutes + " min";
    }
}
