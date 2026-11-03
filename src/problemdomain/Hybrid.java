package problemdomain;

public class Hybrid extends Vehicle {
    private String Powertrain;
    private int ElectricRange;

    public Hybrid(int CarID, String VehicleType, String Subtype, int Speed, double Fuel, int Seats, int Year,
               String Drivetrain, int Price, int Quantity, String Powertrain, int ElectricRange){
        super(CarID, VehicleType, Subtype, Speed, Fuel, Seats, Year, Drivetrain, Price, Quantity);
        this.Powertrain = Powertrain;
        this.ElectricRange = ElectricRange;
    }

    public String getPowertrain(){
        return this.Powertrain;
    }

    public void setPowertrain(String Powertrain) {
        if( Powertrain.equals("E") || Powertrain.equals("A") || Powertrain.equals("PHEV")){
            this.Powertrain = Powertrain;
        }
    }

    public int getElectricRange(){
        return this.ElectricRange;
    }

    public void setElectricRange(int ElectricRange) {
        this.ElectricRange = ElectricRange;
    }
    @Override
    public String toString(){
        String Train = "";
        if (Powertrain.equals("E")) {
            Train = "Series Hybrid";
        } else if (Powertrain.equals("A")) {
            Train = "Parallel Hybrid";
        } else if (Powertrain.equals("PHEV")) {
            Train = "Plug-in Hybrid";
        }
        return super.toString() +
                "Powertrain:   "+Train+"\nElectric Range:   "+ElectricRange;

    }
}
