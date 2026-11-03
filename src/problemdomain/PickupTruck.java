package problemdomain;

public class PickupTruck extends Vehicle {
    private String CargoBedType;
    private int CargoCapacity;

    public PickupTruck(int CarID, String VehicleType, String Subtype, int Speed, double Fuel, int Seats, int Year,
               String Drivetrain, int Price, int Quantity, String CargoBedType, int CargoCapacity){
        super(CarID, VehicleType, Subtype, Speed, Fuel, Seats, Year, Drivetrain, Price, Quantity);
        this.CargoBedType = CargoBedType;
        this.CargoCapacity = CargoCapacity;
    }

    public String getCargoBedType(){
        return this.CargoBedType;
    }

    public void setCargoBedType(String CargoBedType) {
        if( CargoBedType.equals("SB") || CargoBedType.equals("EB") || CargoBedType.equals("DB")){
            this.CargoBedType = CargoBedType;
        }
    }

    public int getCargoCapacity() {
        return CargoCapacity;
    }

    public void setCargoCapacity(int CargoCapacity) {
        this.CargoCapacity = CargoCapacity;
    }
    @Override
    public String toString(){
        String Cargo = "";
        if (CargoBedType.equals("SB")){
            Cargo = "Short Bed";
        } else if (CargoBedType.equals("EB")) {
            Cargo = "Extended Bed";
        } else if (CargoBedType.equals("DB")) {
            Cargo = "Dump Bed";
        }
        return super.toString() +
                "Cargo Capacity:   "+CargoCapacity+"Cargo Bed Type:   "+Cargo;
    }
}
