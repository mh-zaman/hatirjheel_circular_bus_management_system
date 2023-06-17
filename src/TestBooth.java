
public class TestBooth implements StationCode
{
    public static void main(String[] args) throws BalanceException {

        TicketBooth fdc = new TicketBooth("Full Gyration", FDC);

        TicketBooth kuniparaOne = new TicketBooth("Full Gyration", Kunipara);
        TicketBooth kuniparaTwo = new TicketBooth("Shorter Gyration", Kunipara);

        TicketBooth tejgaonOne = new TicketBooth("Full Gyration", TejgaonIA);
        TicketBooth tejgaonTwo = new TicketBooth("Shorter Gyration", TejgaonIA);

        TicketBooth policePlazaOne = new TicketBooth("Full Gyration", PolicePlaza);
        TicketBooth policeplazaTwo = new TicketBooth("Shorter Gyration", PolicePlaza);

        TicketBooth rampuraOne = new TicketBooth("Full Gyration", Rampura);
        TicketBooth rampuraTwo = new TicketBooth("Shorter Gyration", Rampura);

        TicketBooth mohanagarOne = new TicketBooth("Full Gyration", Mohanagar);
        TicketBooth mohanagarTwo = new TicketBooth("Shorter Gyration", Mohanagar);

        TicketBooth modhubagh = new TicketBooth("Full Gyration" , Modhubagh);

        System.out.println(fdc);

        System.out.println();

        fdc.purchase(Rampura, 8, 200);

        System.out.println(fdc.getTicketsSold());
        System.out.println(fdc.getTotalTicketMoney());


        System.out.println();

        fdc.purchase(Rampura, 8, 0);

        System.out.println(fdc.getTicketsSold());
        System.out.println(fdc.getTotalTicketMoney());



        System.out.println();

        kuniparaOne.purchase(Rampura, 8, 50);

        System.out.println();

        kuniparaTwo.purchase(Mohanagar, 5, 100);

        System.out.println();


        policePlazaOne.purchase(Modhubagh, 1, 30);

        System.out.println();

        policeplazaTwo.purchase(Modhubagh, 1, 40);
    }
}