public class EmailNotification implements Notification {
    @Override
    public void sendNotification(Customer customer, String message) {
        System.out.println("EMAIL sent to " + customer.getEmail() + ":");
        System.out.println("Message: " + message);
    }
}