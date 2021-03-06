package PalmettoPizzaMaker;

import PalmettoPizzaMaker.PizzaTypes.Pizza;
import PalmettoPizzaMaker.PizzaTypes.Margarita;
import PalmettoPizzaMaker.PizzaTypes.PepperoniOro;

import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Order {

	private static int orderNumberCounter = 1;
	
    private String orderNumber;
    private int clientNumber;
    ArrayList<Pizza> pizzaArray = new ArrayList<>();

    private double totalOrderPrice;

    public Order(int clientNumber){
		this.clientNumber = clientNumber;
		setOrderNumber(Order.orderNumberCounter);
		Order.incOrderNumberCounter();
    }

    public static void resetCounter(){
        orderNumberCounter = 1;
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
        totalOrderPrice();
        return this.totalOrderPrice;
    }

    private void totalOrderPrice(){
        double result = 0;
        for (Pizza p : this.pizzaArray){
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

	private String getDateTime(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy@HH:mm:ss");
        return dtf.format(ldt);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        // Multiplying "stars" and "lines"
        DecimalFormat df = new DecimalFormat("#0.00");
        String stars = new String(new char[32]).replace("\0", "*") + "\n";
        String line = new String(new char[32]).replace("\0", "-") + "\n";
        sb.append(stars);
        sb.append("Order: " + this.orderNumber + "\n");
        sb.append("Client: " + this.clientNumber + "\n");
        // This is an "extra" task, that I dont want to include into tests.
        //sb.append(LineFormatter.formatForReciept(  getDateTime() + "\n"));
        for(Pizza p : pizzaArray){
            sb.append(LineFormatter.formatForReciept("Pizza Name:@" + p.getPizzaName() + "\n"));
            sb.append(line);
            sb.append(p.getIngredientsCheck());
            sb.append(line);
            sb.append(LineFormatter.formatForReciept("Total:@" + df.format(p.getPizzaPrice()) + " Eu\n"));
            sb.append(LineFormatter.formatForReciept("Pizzas:@" + df.format(p.getNumberOfPizzas()) + "\n"));
            sb.append(line);
        }
        sb.append(LineFormatter.formatForReciept("Total amount:@" + df.format(this.totalOrderPrice) + " Eu\n"));
        sb.append(stars);
        return sb.toString();
    }


}
