public class Ride {
    private final double dist;
    private final int time;

    public Ride(double dist, int time) {
        this.dist = dist;
        this.time = time;
    }

    public double getDist() {
        return dist;
    }

    public int getTime() {
        return time;
    }
}
