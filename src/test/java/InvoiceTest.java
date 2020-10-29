import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {
    CalculateFare calculateFare = new CalculateFare();

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
        Assert.assertEquals(82,calculateFare.getTotalFare(ride),0);

    }
}
