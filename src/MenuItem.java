public class MenuItem {

    private int itemID;
    private float price;
    private String description , name ;

    public MenuItem(int itemId , float price , String name , String  description){
        this.itemID = itemId;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public float getPrice(){
        return this.price;
    }

    public void displayItem(){
        System.out.println(name + " : " + description);
        System.out.printf("Price : %.2f\n" , price);
    }

    public String getName(){
        return this.name;
    }

}
