import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private List<OrderItem> items;
    private float totalPrice ;

    public Order(Customer customer){
        this.customer = new Customer(customer);
        this.totalPrice = 0 ;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item , int quantity){
        OrderItem newItem = new OrderItem(item , quantity);
        this.items.add(newItem);
        this.totalPrice += item.getPrice() * quantity;
    }

    public float getTotalPrice(){
        return totalPrice;
    }

    public void displayOrderSummary(){
        System.out.println("your chosen items are :- ");
        int id = 1;
        for(OrderItem item:items){
            System.out.printf("%d - " , id);
            System.out.println(item.getName() + " (" + item.getQuantity() + ")");
            ++id;
        }
        System.out.printf("Total Price = %.2f\n", this.totalPrice);
        System.out.println("===============");
    }


    public Customer getCustomer(){
        return this.customer;
    }

}
