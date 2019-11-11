package PizzaTypes;

import Ingredients.Ingredient;

import java.util.ArrayList;

public class Pizza {

    boolean isCalzone = false;
    ArrayList<Ingredient> ingridients;
    String pizzaName = "";
    int numberOfPizzas;

    String orderNumber;
    String clientNumber;
    int numberInRow;

    Pizza(){}

    Pizza(String orderNumber, String clientName, int numberInRow, boolean isCalzone) {
        this.orderNumber = orderNumber;
        this.clientNumber = clientName;
        this.numberInRow = numberInRow;
        this.isCalzone = isCalzone;
    }

    private String checkPizzaName(){
        if(pizzaName.length() > 4 && pizzaName.length() < 21) {
            return pizzaName;
        }else{
            return clientNumber + "_" + numberInRow;
        }
    }

    public double getPizzaPrice(){
        double result = 1; //Because pizza base costs 1 Euro by default.
        if(isCalzone){
            result += 0.5;
        }
        for(Ingredient i : ingridients){
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
        if(ingridients.size() > 7) {
            throw new IndexOutOfBoundsException("PizzaTypes.Pizza is full!");
        }
        for(Ingredient i : ingridients){
            if(i.getClass().getName().equals(ingredient.getClass().getName())){
                throw new ArrayStoreException("PizzaTypes.Pizza can't contain 2 equal ingredients. Check your order.");
            }
        }
    }

    public String getIngredientsCheck(){
        StringBuilder sb = new StringBuilder();
        if (isCalzone){
            sb.append("Pizza Base (Calzone)\t1,50 Eu\n");
        }else {
            sb.append("Pizza Base (Original)\t1,00 Eu\n");
        }
        for(Ingredient i : ingridients){
            sb.append(i.getClass().getName() + "\t" + i.getPrice() + " Eu\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return "[" + orderNumber + " : " + clientNumber + " : "
                + pizzaName + " : " + numberOfPizzas + "]";
    }
}
