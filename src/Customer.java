public class Customer {

    private String name , email , phoneNumber;

    private Customer(Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }
    public Customer(Customer customer){
        this.name = customer.name;
        this.email = customer.email;
        this.phoneNumber = customer.phoneNumber;
    }

    public static class Builder {
        private String name;
        private String email;
        private String phoneNumber;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
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
