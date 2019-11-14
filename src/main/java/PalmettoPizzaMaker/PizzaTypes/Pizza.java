package PalmettoPizzaMaker.PizzaTypes;

import java.util.ArrayList;

import PalmettoPizzaMaker.LineFormatter;
import PalmettoPizzaMaker.Ingredients.Ingredient;


public class Pizza {

    boolean isCalzone = false;
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    String pizzaName = "";
    int numberOfPizzas;

    String orderNumber;
	int clientNumber;
	// how to get this number in row?
    int numberInRow;

    public Pizza(){}

    public Pizza(String orderNumber, int clientNumber, int numberInRow, boolean isCalzone) {
        this.orderNumber = orderNumber;
        this.clientNumber = clientNumber;
        this.numberInRow = numberInRow;
        this.isCalzone = isCalzone;
        this.numberOfPizzas = 1;
    }

    public void setPizzaName(String pizzaName) {
        checkPizzaName(pizzaName);
    }

    public String getPizzaName(){
        if(this.pizzaName.equals("")){
            return this.pizzaName;
        } else {
            return this.getClass().getSimpleName();
        }
    }

    private void checkPizzaName(String pizzaName){
        if(pizzaName.length() > 4 && pizzaName.length() < 21) {
            this.pizzaName = pizzaName;
        }else{
            this.pizzaName = clientNumber + "_" + numberInRow;
        }
    }

    public double getPizzaPrice(){
        double result = 1; //Because pizza base costs 1 Euro by default.
        if(isCalzone){
            result += 0.5;
        }
        for(Ingredient i : ingredients){
            result += i.getPrice();
        }
        return result * this.numberOfPizzas;
    }

    public void setNumberOfPizzas(int number){
        this.numberOfPizzas = number;
    }

    public int getNumberOfPizzas(){
        return this.numberOfPizzas;
    }

    public void addIngredient(Ingredient ingredient){
        if(ingredients.size() > 7) {
            throw new IndexOutOfBoundsException("PizzaTypes.Pizza is full!");
        }
        for(Ingredient i : ingredients){
            if(i.getClass().getName().equals(ingredient.getClass().getName())){
                throw new ArrayStoreException("PizzaTypes.Pizza can't contain 2 equal ingredients. Check your order.");
            }
        }
        ingredients.add(ingredient);
    }

    public String getIngredientsCheck(){
        StringBuilder sb = new StringBuilder();
        if (isCalzone){
            sb.append(LineFormatter.formatForReciept("Pizza Base (Calzone)@1,50 Eu\n"));
        }else {
            sb.append(LineFormatter.formatForReciept("Pizza Base (Original)@1,00 Eu\n"));
        }
		//System.out.println("Ingredients: " + this.ingredients.toString());
        for(Ingredient i : this.ingredients){
            String string = i.getClass().getSimpleName() + "@" + i.getPrice() + " Eu\n";
            sb.append(LineFormatter.formatForReciept(string));
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return "[" + orderNumber + " : " + clientNumber + " : "
                + pizzaName + " : " + numberOfPizzas + "]";
    }
}
