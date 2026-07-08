public class CardPayment implements Payment{

        private String cardNumber;

        public CardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(float amount) {
            System.out.printf("Processing card payment of $%.2f .\n", amount);
        }
    }