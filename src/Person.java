public class Person {

    private double money;
    private double ticketPrice;

    public Person(double money, double ticketPrice) {
        this.money = money;
        this.ticketPrice = ticketPrice;
    }

    public void checkBalance() throws BalanceException {

        try {
            if (money < ticketPrice) {
                throw new BalanceException();
            }
        }
        catch (BalanceException b) {
            System.out.println(b);
        }

        if (money > ticketPrice) {
            System.out.println("Returned money : " + (money - ticketPrice));
        }
    }
}