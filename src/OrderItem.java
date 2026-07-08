public class OrderItem {
    private MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getName(){
        return this.item.getName();
    }

    public int getQuantity(){
        return this.quantity;
    }

}