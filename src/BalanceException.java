public class BalanceException extends Exception {

    BalanceException() {
        TicketBooth.setFlag(1);
    }

    public String toString() {
        return "Insufficient balance" ;
    }
}