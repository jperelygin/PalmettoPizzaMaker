import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import PizzaTypes.Margarita;
import PizzaTypes.Pizza;

public class testOrder {

    @Test
    public void testClientNumberStorage(){
        Order order = new Order(123);
        Assert.assertEquals(123, order.getClientNumber());
    }

    @Test
    public void testOrderNumberStorage(){
        Order order = new Order(1234);
        Assert.assertEquals("00001", order.getOrderNumber());
    }

    @Test
    public void testOrderNumberIncrimintation(){
        Order order1 = new Order(1234);
        Assert.assertEquals("00001", order1.getOrderNumber());
        Order order2 = new Order(4567);
        Assert.assertEquals("00002", order2.getOrderNumber());
        Order order3 = new Order(123);
        Assert.assertEquals("00003", order3.getOrderNumber());
    }

    @Test
    public void testOrderNumberMaxValue(){
        //Owkward test
        for(int i = 0; i < 99999 ; i++){
            Order order = new Order(123);
        }
        Order order1 = new Order(2);
        Assert.assertEquals("00000", order1.getClientNumber());
    }

    @Test
    public void totalOrderPrice(){
        Order order = new Order(213);
        Pizza p1 = new Margarita(order.getOrderNumber(), order.getClientNumber(), 1, true);
        // p1 = 5.3 Eu
        Pizza p2 = new Margarita(order.getOrderNumber(), order.getClientNumber(), 1, false);
        // p2 = 4.8 Eu
        order.addPizza(p1);
        order.addPizza(p2);
        Assert.assertEquals(10.1, order.getTotalOrderPrice(), 0.1);
    }

    @Test
    public void testAddPizza(){
        Order order = new Order(1);
        Pizza p = new Margarita(order.getOrderNumber(), order.getClientNumber(), 1, true);
        order.addPizza(p);
        String pizzaToString = "[00001 : 1 : Margarita : 1]";
        String actualResult = "";
        for(Pizza pizza : order.pizzaArray){
            actualResult = pizza.toString();
        }
        Assert.assertEquals(pizzaToString, actualResult);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none(); 

    @Test
    public void testMaxSizeOfOrder(){
        Order order = new Order(1234);
        for(int i = 0; i < 10; i++){
            Pizza p = new Margarita(order.getOrderNumber(), order.getClientNumber(), i, true);
            order.addPizza(p);
        }
        Pizza p = new Margarita(order.getOrderNumber(), order.getClientNumber(), 10, true);
        expectedException.expect(ArrayStoreException.class);
        expectedException.expectMessage("Too many pizzas!");
        order.addPizza(p);
    }

}
