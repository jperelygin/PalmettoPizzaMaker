package PalmettoPizzaMaker;

import PalmettoPizzaMaker.PizzaTypes.Pizza;
import PalmettoPizzaMaker.PizzaTypes.Margarita;
import PalmettoPizzaMaker.PizzaTypes.PepperoniOro;
import PalmettoPizzaMaker.Ingredients.*;

public class Main {
	
	private static String firstOrder(){
		Order order = new Order(7717);
		Margarita margarita = new Margarita(order.getOrderNumber(), order.getClientNumber(), 0, true);
		margarita.setNumberOfPizzas(2);
		PepperoniOro pepPizza = new PepperoniOro(order.getOrderNumber(), order.getClientNumber(), 2, false);
		pepPizza.setNumberOfPizzas(3);
		order.addPizza(margarita);
		order.addPizza(pepPizza);
		return order.toString();
	}
	
	private static String secondOrder(){
		Order order = new Order(4372);
		Pizza basePZZ = new Pizza(order.getOrderNumber(), order.getClientNumber(), 0, false);
		basePZZ.addIngredient(new Cheese());
		basePZZ.addIngredient(new Bacon());
		basePZZ.addIngredient(new TomatoPaste());
		basePZZ.setNumberOfPizzas(12);
		order.addPizza(basePZZ);
		return order.toString();
	}

    public static void main(String[] args) {
		//System.out.print(firstOrder());
		System.out.print(secondOrder());
	}
	
}
