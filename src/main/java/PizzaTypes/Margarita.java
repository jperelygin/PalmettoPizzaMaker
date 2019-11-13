package PizzaTypes;

import Ingredients.Cheese;
import Ingredients.Garlic;
import Ingredients.Salami;
import Ingredients.TomatoPaste;

public class Margarita extends Pizza {

    public Margarita(){
        // it is not a proper Margarita, but ingredient list was in the task.
        this.ingredients.add(new TomatoPaste());
        this.ingredients.add(new Cheese());
        this.ingredients.add(new Garlic());
        this.ingredients.add(new Salami());
        // totalPrice = 3.8
    }
	
	public Margarita(String orderNumber, int clientNumber, int numberInRow, boolean isCalzone) {
        super();
		this.orderNumber = orderNumber;
        this.clientNumber = clientNumber;
        this.numberInRow = numberInRow;
        this.isCalzone = isCalzone;
    }
}
