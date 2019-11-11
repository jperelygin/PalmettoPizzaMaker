import PizzaTypes.Pizza;

public class Order {

    private int orderNumer;
    private int clientNumber;
    Pizza[] pizzaArray = new Pizza[10];

    Order(int orderNumer){
        this.orderNumer = orderNumer;
    }

    public String getOrderNumber(){
        String orderNumberString;
        if(this.orderNumer > 99999){
            orderNumberString = Integer.toString(this.orderNumer % 100000);
        }
        else if (Integer.toString(orderNumer).length() < 5){
            orderNumberString = Integer.toString(orderNumer);
            while(orderNumberString.length() < 5){
                orderNumberString = "0" + orderNumberString;
            }
        }
        else {
            orderNumberString = Integer.toString(orderNumer);
        }
        return orderNumberString;
    }

    private double totalOrderPrice(){
        double result = 0;
        for (Pizza p : pizzaArray){
            result += p.getPizzaPrice();
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        // Multiplying "stars"
        String stars = new String(new char[32]).replace("\0", "*") + "\n";
        String line = new String(new char[32]).replace("\0", "-") + "\n";
        sb.append(stars);
        sb.append("Order: " + this.orderNumer + "\n");
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
        sb.append("Total amount:\t" + this.totalOrderPrice() + " Eu\n");
        sb.append(stars);
        return sb.toString();
    }


}
