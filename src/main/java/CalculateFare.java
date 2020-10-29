public class CalculateFare{
    private static final double COST_PERKM_NORMAL = 10.0;
    private static final int COST_PERUNITTIME_NORMAL = 1;

    private static final double COST_PERKM_PREMIUM = 15.0;
    private static final int COST_PERUNITTIME_PREMIUM = 2;

    public double getTotalFare(String type, double dist, int time) {
        double totalFare = 0;
        if(dist < 0 || time < 0)
            return -1;
        if(type.equals("normal"))
            totalFare = dist * COST_PERKM_NORMAL + time * COST_PERUNITTIME_NORMAL < 5 ? 5 : dist * COST_PERKM_NORMAL + time * COST_PERUNITTIME_NORMAL;
        else
            totalFare = dist * COST_PERKM_PREMIUM + time * COST_PERUNITTIME_PREMIUM < 20 ? 20 : dist * COST_PERKM_PREMIUM + time * COST_PERUNITTIME_PREMIUM;
        return totalFare;
    }

    public InvoiceSummary getTotalFare(String type, Ride[] ride) {
        double sum = 0;
        for(Ride r : ride){
            sum = sum + this.getTotalFare(type, r.getDist(), r.getTime());
        }
        return new InvoiceSummary(ride.length, sum);
    }
}
