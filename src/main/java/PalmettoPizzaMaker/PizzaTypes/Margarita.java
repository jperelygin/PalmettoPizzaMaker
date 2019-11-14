package PalmettoPizzaMaker.PizzaTypes;

import PalmettoPizzaMaker.Ingredients.Cheese;
import PalmettoPizzaMaker.Ingredients.Garlic;
import PalmettoPizzaMaker.Ingredients.Salami;
import PalmettoPizzaMaker.Ingredients.TomatoPaste;

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
        this();
		this.orderNumber = orderNumber;
        this.clientNumber = clientNumber;
        this.numberInRow = numberInRow;
        this.isCalzone = isCalzone;
    }
}
