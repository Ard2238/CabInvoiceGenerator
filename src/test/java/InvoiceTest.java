import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {
    CalculateFare calculateFare = new CalculateFare();
    RideRepository repo = new RideRepository();

    @Test
    public void testCalculateTotalFare(){
        Assert.assertEquals(45, calculateFare.getTotalFare(3.5,10), 0);
        Assert.assertEquals(5, calculateFare.getTotalFare(0.3,1),0);
    }

    @Test
    public void testCalculateFareForInvalidInputs(){
        Assert.assertEquals(-1, calculateFare.getTotalFare(-3,2),0);
        Assert.assertEquals(-1, calculateFare.getTotalFare(3,-3),0);
    }

    @Test
    public void testCalculateFare_ForMultipleRides(){
        Ride[] ride = {new Ride(3.5, 10),
                        new Ride(0.3,1),
                        new Ride(3,2)};
        //Assert.assertEquals(82,calculateFare.getTotalFare(ride),0);

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,82);
        InvoiceSummary actualInvoiceSummary = calculateFare.getTotalFare(ride);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void testInvoiceService(){
        Ride[] ride1 = {new Ride(3.5, 10),new Ride(0.3,1),new Ride(3,2)};
        InvoiceSummary setInvoice1 = calculateFare.getTotalFare(ride1);
        repo.rideRepo.put("001", setInvoice1);
        Ride[] ride2 = {new Ride(2, 5),new Ride(0.7,0),new Ride(6,1)};
        InvoiceSummary setInvoice2 = calculateFare.getTotalFare(ride1);
        repo.rideRepo.put("002", setInvoice2);

        InvoiceSummary actual = new InvoiceSummary(3, 82);
        InvoiceSummary expected = repo.rideRepo.get("001");
        Assert.assertEquals(expected, actual);
    }
}
