public class CalculateFare{
    private static final double COST_PERKM = 10.0;
    private static final int COST_PERUNITTIME = 1;

    public double getTotalFare(double dist, int time) {
        if(dist < 0 || time < 0)
            return -1;
        return (dist * COST_PERKM + time * COST_PERUNITTIME) < 5 ? 5 : dist * COST_PERKM + time * COST_PERUNITTIME;
    }

    public InvoiceSummary getTotalFare(Ride[] ride) {
        double sum = 0;
        for(Ride r : ride){
            sum = sum + this.getTotalFare(r.getDist(), r.getTime());
        }
        return new InvoiceSummary(ride.length, sum);
    }
}
