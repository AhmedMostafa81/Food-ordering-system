public class CashPayment implements Payment {

    @Override
    public void pay(float amount) {
        System.out.printf("Processing cash payment of $%.2f upon delivery.\n", amount);
    }

}
