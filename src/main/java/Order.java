import PizzaTypes.Pizza;
import PizzaTypes.Margarita;
import PizzaTypes.PepperoniOro;
import java.util.ArrayList;

public class Order {

	private static int orderNumberCounter = 1;
	
    private String orderNumber;
    private int clientNumber;
    ArrayList<Pizza> pizzaArray = new ArrayList<>();

    private double totalOrderPrice;

    Order(int clientNumber){
		this.clientNumber = clientNumber;
		setOrderNumber(Order.orderNumberCounter);
		Order.incOrderNumberCounter();
    }

	
	private static void incOrderNumberCounter(){
		Order.orderNumberCounter++;
	}
	
	private void setOrderNumber(int order){
		if(order > 99999){
            this.orderNumber = Integer.toString(order % 100000);
        } else if (Integer.toString(order).length() < 5){
            this.orderNumber = Integer.toString(order);
            while(this.orderNumber.length() < 5){
                this.orderNumber = "0" + this.orderNumber;
            }
        } else {
            this.orderNumber = Integer.toString(order);
        }
		
	}

    public String getOrderNumber(){
        return this.orderNumber;
    }
	
	public int getClientNumber(){
		return this.clientNumber;
    }
    
    public double getTotalOrderPrice(){
        return this.totalOrderPrice;
    }

    private void totalOrderPrice(){
        double result = 0;
        for (Pizza p : pizzaArray){
            result += p.getPizzaPrice();
        }
        this.totalOrderPrice = result;
    }
	
	private boolean checkSize(){
		if(pizzaArray.size() < 11){
			return true;
		} else {
			return false;
		}
	}
	
	public void addPizza(Pizza pizza){
		if(checkSize()){
			pizzaArray.add(pizza);
		} else {
			throw new ArrayStoreException("Too many pizzas!");
        }
        totalOrderPrice();
	}

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        // Multiplying "stars" and "lines"
        String stars = new String(new char[32]).replace("\0", "*") + "\n";
        String line = new String(new char[32]).replace("\0", "-") + "\n";
        sb.append(stars);
        sb.append("Order: " + this.orderNumber + "\n");
        sb.append("Client: " + this.clientNumber + "\n");
        for(Pizza p : pizzaArray){
            sb.append("Pizza Name: " + p.getClass().getName() + "\n");
            sb.append(line);
            sb.append(p.getIngredientsCheck());
            sb.append(line);
            sb.append("Total:\t\t" + p.getPizzaPrice()+ "\n");
            sb.append("Pizzas:\t\t" + p.getNumberOfPizzas()+ "\n") ;
            sb.append(line);
        }
        sb.append("Total amount:\t" + this.totalOrderPrice + " Eu\n");
        sb.append(stars);
        return sb.toString();
    }


}
