package PalmettoPizzaMaker.PizzaTypes;

import PalmettoPizzaMaker.Ingredients.Cheese;
import PalmettoPizzaMaker.Ingredients.Olives;
import PalmettoPizzaMaker.Ingredients.Pepperoni;
import PalmettoPizzaMaker.Ingredients.TomatoPaste;

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
