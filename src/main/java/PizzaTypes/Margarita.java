package PizzaTypes;

import Ingredients.Cheese;
import Ingredients.Garlic;
import Ingredients.Salami;
import Ingredients.TomatoPaste;

public class Margarita extends Pizza {

    Margarita(){
        // it is not a proper Margarita, but ingredient list was in the task.
        this.ingridients.add(new TomatoPaste());
        this.ingridients.add(new Cheese());
        this.ingridients.add(new Garlic());
        this.ingridients.add(new Salami());
    }
}
