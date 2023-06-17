public class BusStation {

    private String stationName;
    private int stationCode;

    public BusStation(String stationName, int stationCode) {
        this.stationName = stationName;
        this.stationCode = stationCode;
    }

    //getter method for stationName
    public String getStationName()
    {
        return stationName;
    }

    //getter method for stationCode
    public int getStationCode()
    {
        return stationCode;
    }

    public String toString()
    {
        return "Bus station : " + stationName + " Station code : " + stationCode;
    }
}