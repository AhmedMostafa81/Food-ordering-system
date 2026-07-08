public class Customer {

    private String name , email , phoneNumber;

    public Customer(String name , String email  ,String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public Customer(Customer customer){
        this.name = customer.name;
        this.email = customer.email;
        this.phoneNumber = customer.phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

}
