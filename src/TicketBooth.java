public class TicketBooth implements StationCode {

    private final int totalBus = 12;
    private int totalBooths = 7;
    public BusStation[] booth;
    private String route;
    private int location;
    private static int ticketsSold;
    private double ticketPrice;
    private static double totalTicketMoney;
    private static int flag;

    //Constructor method
    public TicketBooth(String route, int location) {

        booth = new BusStation[totalBooths];
        this.route = route;
        this.location = location;
        ticketsSold = 0;
        ticketPrice = 0.0;
        totalTicketMoney = 0.0;

        if (route == "Full Gyration") {
            fullCircleStations();
        }

        if (route == "Shorter Gyration") {
            shortCircleStations();
        }
    }

    //Initializes the booth array if the route (Full Gyration) is selected
    public void fullCircleStations() {

        booth[0] = new BusStation("F.D.C", FDC);
        booth[1] = new BusStation("Kunipara", Kunipara);
        booth[2] = new BusStation("Tejgaon I/A", TejgaonIA);
        booth[3] = new BusStation("Police Plaza", PolicePlaza);
        booth[4] = new BusStation("Rampura", Rampura);
        booth[5] = new BusStation("Mohanagar", Mohanagar);
        booth[6] = new BusStation("Modhubagh", Modhubagh);
    }

    //Initializes the booth array if the route (Shorter Gyration) is selected
    public void shortCircleStations() {
        booth[0] = new BusStation(null, Invalid);
        booth[1] = new BusStation("Kunipara", Kunipara);
        booth[2] = new BusStation("Tejgaon I/A", TejgaonIA );
        booth[3] = new BusStation("Police Plaza", PolicePlaza);
        booth[4] = new BusStation("Rampura", Rampura);
        booth[5] = new BusStation("Mohanagar", Mohanagar);
        booth[6] = new BusStation(null, Invalid);
    }

    //This method calculates distance between two bus stations. Fixes ticket price accordingly. Checks the balance. Prints the ticket.

    public void purchase(int destination, int ticketAmount, double money) throws BalanceException {

        int ticketCode = 99999;
        String ticketSlip = "";

        ticketCode = booth[location - 1].getStationCode() - booth[destination - 1].getStationCode();

        if(getRoute() == "Full Gyration") {

            if (ticketCode == -1 || ticketCode == -2 || ticketCode == 5 || ticketCode == 6) { ticketPrice = 10.0; }
            else if (ticketCode == -3 || ticketCode == -4 || ticketCode == 3 || ticketCode == 4) { ticketPrice = 15.0; }
            else if (ticketCode == -5 || ticketCode == -6 || ticketCode == 1 || ticketCode == 2) { ticketPrice = 20.0; }
            else if (ticketCode == 0) { ticketPrice = 30.0; }
            else { return; }
        }

        if(getRoute() == "Shorter Gyration") {

            if(booth[location - 1].getStationCode() == Invalid || booth[destination - 1].getStationCode() == Invalid){
                System.out.println("Select valid station");
                return;
            }

            if (ticketCode == -1 || ticketCode == -2 || ticketCode == 3 || ticketCode == 4) { ticketPrice = 10.0; }
            else if (ticketCode == -3 || ticketCode == -4 || ticketCode == 1 || ticketCode == 2) { ticketPrice = 15.0; }
            else if (ticketCode == 0) { ticketPrice = 20.0; }
            else { return; }
        }

        ticketPrice *= ticketAmount;


        Person person = new Person(money, getTicketPrice());

        setFlag(0);

        person.checkBalance();

        if(flag == 1) return;

        ticketsSold += ticketAmount;

        totalTicketMoney += ticketPrice;

        ticketSlip = "Hatirjheel Circular Bus \uD83D\uDE8C \nFrom " + booth[location - 1].getStationName() + " To " + booth[destination - 1].getStationName()
                + ",  Booth no. " +  booth[location - 1].getStationCode()  + "\nRoute : " + getRoute() + ", Amount : " + ticketAmount + ",  Ticket price : "
                + getTicketPrice() + " BDT";

        System.out.println(ticketSlip);
    }

    public static void setFlag(int number) {
        flag = number;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public double getTotalTicketMoney() {
        return totalTicketMoney;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getRoute() {
        return route;
    }

    public String toString() {

        String nameOfBooths = "";

        for(int i=0; i<booth.length; i++) {
            nameOfBooths += booth[i].getStationName() + ", ";
        }

        return "Total booths : " + totalBooths + " \nBus Stops : " + nameOfBooths;
    }
}