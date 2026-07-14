import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create some food items
        MenuItem maxi = new MenuItem(3, 1.50f, "Maxi", "Cold drink");
        MenuItem burger = new MenuItem(1, 5.99f, "Burger", "Beef with cheese");
        MenuItem fries = new MenuItem(2, 2.50f, "Fries", "Salted potato fries");

        // Put them in the menu
        List<MenuItem> menuList = new ArrayList<>();
        menuList.add(burger);
        menuList.add(fries);
        menuList.add(maxi);
        Menu restaurantMenu = new Menu(menuList);

        // Set up customer and checkout service
        Customer.Builder builder = new Customer.Builder();
        builder.setName("Ali")
                .setEmail("ali123@email.com")
                .setPhoneNumber("01122223333");
        Customer customer = builder.build();
        CheckoutService checkout = CheckoutService.getInstance();
        Order currentOrder = new Order(customer);

        // The main loop
        while (true) {
            System.out.println("\n--- FOOD ORDER SYSTEM ---");
            System.out.println("1. View Menu");
            System.out.println("2. Add Item to Order");
            System.out.println("3. View Current Order Summary");
            System.out.println("4. Checkout and Pay");
            System.out.println("5. Exit Application");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                restaurantMenu.displayMenu();
            }
            else if (choice == 2) {
                System.out.print("Enter item number from the menu: ");
                int itemChoice = scanner.nextInt();
                MenuItem selectedItem = restaurantMenu.getItem(itemChoice);

                if (selectedItem == null) {
                    System.out.println("Invalid menu item number!");
                } else {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    currentOrder.addItem(selectedItem, quantity);
                    System.out.println(quantity + "x " + selectedItem.getName() + " added successfully!");
                }
            }
            else if (choice == 3) {
                currentOrder.displayOrderSummary();
            }
            else if (choice == 4) {
                if (currentOrder.getTotalPrice() == 0) {
                    System.out.println("Your cart is empty! Add items first.");
                    continue;
                }

                //  Handle Payment Object
                System.out.println("\n1. Cash\n2. Card");
                System.out.print("Select Payment Method: ");
                int payChoice = scanner.nextInt();

                Payment payment;
                if (payChoice == 2) {
                    System.out.print("Enter card number: ");
                    payment = new CardPayment(scanner.next());
                } else {
                    payment = new CashPayment();
                }

                System.out.println("\n1. Email\n2. SMS\n3. Both");
                System.out.print("Select Notification Channel: ");
                int notificationChoice = scanner.nextInt();

                List<Notification> channels = new ArrayList<>();
                if (notificationChoice == 1 || notificationChoice == 3)
                    channels.add(new EmailNotification());
                if (notificationChoice == 2 || notificationChoice == 3)
                    channels.add(new SmsNotification());

                checkout.processCheckout(currentOrder, payment, channels);

                currentOrder = new Order(customer);
                System.out.println("\nReady for a new order!");
            }
            else if (choice == 5) {
                System.out.println("Have a nice day!");
                break;
            }
            else {
                System.out.println("Invalid choice. Please select 1-5.");
            }
        }
        scanner.close();
    }
}