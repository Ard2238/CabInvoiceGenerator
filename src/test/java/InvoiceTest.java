import org.junit.Assert;
import org.junit.Test;

public class InvoiceTest {
    @Test
    public void testCalculateTotalFare(){
        CalculateFare calculateFare = new CalculateFare();
        Assert.assertEquals(45, calculateFare.getTotalFare(3.5,10), 0);
        Assert.assertEquals(5, calculateFare.getTotalFare(0.3,1),0);
        Assert.assertEquals(-1, calculateFare.getTotalFare(-3,2),0);
        Assert.assertEquals(-1, calculateFare.getTotalFare(3,-3),0);
    }
}
