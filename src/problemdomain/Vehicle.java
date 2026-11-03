package problemdomain;

public abstract class Vehicle {
    private int CarID;
    private String VehicleType;
    private String Subtype;
    private int Speed;
    private double Fuel;
    private int Seats;
    private int Year;
    private String Drivetrain;
    private int Price;
    private int Quantity;

    public Vehicle(int CarID, String VehicleType, String Subtype, int Speed, double Fuel, int Seats, int Year,
                   String Drivetrain, int Price, int Quantity){
        this.CarID = CarID;
        this.VehicleType = VehicleType;
        this.Subtype = Subtype;
        this.Speed = Speed;
        this.Fuel = Fuel;
        this.Seats = Seats;
        this.Year = Year;
        this.Drivetrain = Drivetrain;
        this.Price = Price;
        this.Quantity = Quantity;
    }
    public int getCarID() {
        return this.CarID;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    public String getVehicleType(){
        return this.VehicleType;
    }

    public void setVehicleType(String VehicleType){
        this.VehicleType = VehicleType;
    }

    public String getSubtype(){
        return this.Subtype;
    }

    public void setSubtype(String Subtype) {
        this.Subtype = Subtype;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }

    public double getFuel() {
        return this.Fuel;
    }

    public void setFuel(double Fuel) {
        this.Fuel = Fuel;
    }

    public int getSeats() {
        return this.Seats;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }

    public int getYear() {
        return this.Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getDrivetrain() {
        return this.Drivetrain;
    }

    public void setDrivetrain(String Drivetrain) {
        this.Drivetrain = Drivetrain;
    }

    public int getPrice() {
        return this.Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString(){
        return "Car ID:   "+CarID+"\nVehicle Type:   "+VehicleType+"\nSub Type:   "+Subtype+"\nSpeed:   "
        +Speed+"\nFuel:   "+Fuel+"\nNumber of Seats:   "+Seats+"\nYear:   "+Year+"\nDrivetrain:   "+Drivetrain
        +"\nPrice:   "+Price+"\nAvailable:   "+Quantity;
    }
}
