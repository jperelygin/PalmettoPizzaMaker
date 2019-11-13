package PizzaTypes;

import Ingredients.Cheese;
import Ingredients.Olives;
import Ingredients.Pepperoni;
import Ingredients.TomatoPaste;

public class PepperoniOro extends Pizza {

    public PepperoniOro(){
        this.ingredients.add(new TomatoPaste());
        this.ingredients.add(new Cheese());
        this.ingredients.add(new Pepperoni());
        this.ingredients.add(new Olives());
    }
	
	public PepperoniOro(String orderNumber, int clientNumber, int numberInRow, boolean isCalzone) {
        this();
		this.orderNumber = orderNumber;
        this.clientNumber = clientNumber;
        this.numberInRow = numberInRow;
        this.isCalzone = isCalzone;
    }

}
