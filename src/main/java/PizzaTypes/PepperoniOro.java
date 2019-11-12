package PizzaTypes;

import Ingredients.Cheese;
import Ingredients.Olives;
import Ingredients.Pepperoni;
import Ingredients.TomatoPaste;

public class PepperoniOro extends Pizza {

    PepperoniOro(){
        this.ingridients.add(new TomatoPaste());
        this.ingridients.add(new Cheese());
        this.ingridients.add(new Pepperoni());
        this.ingridients.add(new Olives());
    }
	
	PepperoniOro(String orderNumber, int clientNumber, int numberInRow, boolean isCalzone) {
        this();
		this.orderNumber = orderNumber;
        this.clientNumber = clientNumber;
        this.numberInRow = numberInRow;
        this.isCalzone = isCalzone;
    }

}
