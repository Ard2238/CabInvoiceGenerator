public class InvoiceSummary {
    private final int num_rides;
    private final double totalFare;
    private final double average_Fare;

    public InvoiceSummary(int num_rides, double totalFare) {
        this.num_rides = num_rides;
        this.totalFare = totalFare;
        this.average_Fare = this.totalFare / this.num_rides;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj  == null || getClass() != obj.getClass()) return false;

        InvoiceSummary that = (InvoiceSummary) obj;
        return num_rides == that.num_rides && totalFare == that.totalFare && average_Fare == that.average_Fare;
    }
}
