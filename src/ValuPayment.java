public class ValuPayment implements Payment {
    private int months;

    public ValuPayment(int months) {
        this.months = months;
    }

    @Override
    public void pay(float amount) {
        float monthlyInstallment = amount / months;
        System.out.printf("Processing Valu installment payment of $%.2f split over %d months ($%.2f/month).\n",
                amount, months, monthlyInstallment);
    }
}