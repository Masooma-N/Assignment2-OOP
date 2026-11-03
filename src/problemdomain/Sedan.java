package problemdomain;

public class Sedan extends Vehicle {
    private String TrunkSize;

    public Sedan(int CarID, String VehicleType, String Subtype, int Speed, double Fuel, int Seats, int Year,
                 String Drivetrain, int Price, int Quantity, String TrunkSize){
        super(CarID, VehicleType, Subtype, Speed, Fuel, Seats, Year, Drivetrain, Price, Quantity);
        this.TrunkSize = TrunkSize;
    }
    public String getTrunkSize(){
        return this.TrunkSize;
    }

    public void setTrunkSize(String TrunkSize) {
        if ( TrunkSize.equals("L") || TrunkSize.equals("S") || TrunkSize.equals("M")){
            this.TrunkSize = TrunkSize;
        }
    }
    @Override
    public String toString(){
        String Size = "";
        if (TrunkSize.equals("L")){
            Size = "Large/spacious Trunk";
        } else if (TrunkSize.equals("S")) {
            Size = "Small Trunk";
        } else if (TrunkSize.equals("M")) {
            Size = "Moderate Trunk";
        }
        return super.toString() +
                "Trunk Size:   "+Size;
    }
}
