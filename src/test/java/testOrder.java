import org.junit.Assert;
import org.junit.Test;

public class testOrder {

    @Test
    public void testSetOrderNumberBigger(){
        Order testOrder = new Order(123456);
        Assert.assertEquals("23456", testOrder.getOrderNumber());
    }

    @Test
    public void testSetOrderNumberSmaller(){
        Order testOrder = new Order(1234);
        Assert.assertEquals("01234", testOrder.getOrderNumber());
        Order testOrder2 = new Order(2);
        Assert.assertEquals("00002", testOrder2.getOrderNumber());
        System.out.println(testOrder2.getClass().getName());
    }
}
