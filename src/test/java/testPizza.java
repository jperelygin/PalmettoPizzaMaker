import org.junit.Test;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

import PizzaTypes.Pizza;

// toString: [00001 : 1 : Margarita : 1]
// order.getOrderNumber(), order.getClientNumber(), 1, false
// Pizza p = new Pizza("1", 1, 1, false);

public class testPizza{
    
    @Test
    public void testPizzaName(){
        Pizza p = new Pizza("1", 1, 1, false);
        p.setPizzaName("BZZpizza");
        //Figure out why such method is depricated
        Assert.assertEquals("BZZpizza", p.getPizzaName());
    }

    @Test
    public void testSetSmallPizzaName(){
        Pizza p = new Pizza("1", 1, 1, false);
        p.setPizzaName("B");
        //Figure out why such method is depricated
        Assert.assertEquals("1_1", p.getPizzaName());
    }

    @Test
    public void testSetBigPizzaName(){
        Pizza p = new Pizza("1", 1, 1, false);
        p.setPizzaName("BBBBBBBBBBBBBBBBBBBBq");
        //Figure out why such method is depricated
        Assert.assertEquals("1_1", p.getPizzaName());
    }

    @Test
    public void testGetPizzaPrice(){
        Pizza p = new Pizza("1", 1, 1, false);
        Assert.assertEquals(1.0, p.getPizzaPrice(), 0.001);
    }

    @Test
    public void testSetNumberOfPizzas(){
        // Do we really need this test?
        Pizza p = new Pizza("1", 1, 1, false);
        p.setNumberOfPizzas(12);
        Assert.assertEquals(12, p.getNumberOfPizzas());
    }

    @Test
    public void testAddIngredient(){
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza Base (Original)\t1,00 Eu\n");
        sb.append("TomatoPaste\t1.00 Eu\n");

        Pizza p = new Pizza("1", 1, 1, false);
        p.addIngredient(new Ingredients.TomatoPaste());

        Assert.assertEquals(sb.toString(), p.getIngredientsCheck());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none(); 

    @Test
    public void testAddTooManyIngrediens(){
        Pizza p = new Pizza("1", 1, 1, false);
        p.addIngredient(new Ingredients.TomatoPaste());
        p.addIngredient(new Ingredients.Bacon());
        p.addIngredient(new Ingredients.Cheese());
        p.addIngredient(new Ingredients.Corn());
        p.addIngredient(new Ingredients.Olives());
        p.addIngredient(new Ingredients.Pepperoni());
        p.addIngredient(new Ingredients.Salami());

        ExpectedException ee = ExpectedException.none();
        ee.expect(IndexOutOfBoundsException.class);
        ee.expectMessage("PizzaTypes.Pizza is full!");
        p.addIngredient(new Ingredients.Garlic());
    }

    @Test
    public void testAddTwoSameIngredients(){
        Pizza p = new Pizza("1", 1, 1, false);
        p.addIngredient(new Ingredients.TomatoPaste());

        ExpectedException ee = ExpectedException.none();
        ee.expect(ArrayStoreException.class);
        ee.expectMessage("PizzaTypes.Pizza can't contain 2 equal ingredients. Check your order.");
        p.addIngredient(new Ingredients.TomatoPaste());     
    }

    @Test
    public void testGetPizzaPriceWithIngridients(){
        Pizza p = new Pizza("1", 1, 1, false);
        p.addIngredient(new Ingredients.TomatoPaste());
        Assert.assertEquals(2.0, p.getPizzaPrice(), 0.001);
    }
}