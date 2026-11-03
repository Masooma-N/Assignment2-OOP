package problemdomain;

public class Hatchback extends Vehicle {
    private String HatchType;

    public Hatchback(int CarID, String VehicleType, String Subtype, int Speed, double Fuel, int Seats, int Year,
                     String Drivetrain, int Price, int Quantity, String HatchType){
        super(CarID, VehicleType, Subtype, Speed, Fuel, Seats, Year, Drivetrain, Price, Quantity);
        this.HatchType = HatchType;
    }
    public String getHatchType(){
        return this.HatchType;
    }

    public void setHatchType(String HatchType) {
        if ( HatchType.equals("S") || HatchType.equals("T") || HatchType.equals("P")){
            this.HatchType = HatchType;
        }
    }
    @Override
    public String toString(){
        String Type = "";
        if (HatchType.equals("S")){
            Type = "Standard Liftgate";
        } else if (HatchType.equals("T")) {
            Type = "Split Liftgate";
        } else if (HatchType.equals("P")) {
            Type = "Power Liftgate";
        }
        return super.toString() +
                "Hatch Type:   "+Type;
    }
}
