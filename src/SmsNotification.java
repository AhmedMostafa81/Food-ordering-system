public class SmsNotification implements Notification {
    @Override
    public void sendNotification(Customer customer, String message) {
        System.out.println("SMS sent to " + customer.getPhoneNumber() + ":");
        System.out.println("Message: " + message);
    }
}