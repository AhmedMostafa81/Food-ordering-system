
import java.util.List;

public class CheckoutService {

    private static CheckoutService instance;

    private CheckoutService() {}

    public static CheckoutService getInstance() {
        if (instance == null) {
            instance = new CheckoutService();
        }
        return instance;
    }

    public void processCheckout(Order order, Payment paymentMethod, List<Notification> channels) {

        order.displayOrderSummary();
        paymentMethod.pay(order.getTotalPrice());
        String message = String.format("Thank you %s! Your order for $%.2f is confirmed.",
                order.getCustomer().getName(), order.getTotalPrice());

        System.out.println("---------------------");
        for (Notification channel : channels) {
            channel.sendNotification(order.getCustomer(), message);
        }
    }

}
