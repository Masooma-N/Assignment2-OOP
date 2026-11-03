import problemdomain.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import problemdomain.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> Vehicle = new ArrayList<Vehicle>();
        File vehiclefile = new File("src/res/Vehicle.txt");
        try (BufferedReader vehicleReader =
                     new BufferedReader(new FileReader(vehiclefile))) {
            String currentLine;
            while ((currentLine = vehicleReader.readLine()) != null) {
                String items[] = currentLine.split(";");
                if (items[0].startsWith("1")) {
                    Vehicle.add(new Sedan(Integer.parseInt(items[0]), items[1], items[2], Integer.parseInt(items[3]), Double.parseDouble(items[4]), Integer.parseInt(items[5]), Integer.parseInt(items[6]), items[7], Integer.parseInt(items[8]), Integer.parseInt(items[9]), items[10]));
                } else if (items[0].startsWith("2")) {
                    Vehicle.add(new Hatchback(Integer.parseInt(items[0]), items[1], items[2], Integer.parseInt(items[3]), Double.parseDouble(items[4]), Integer.parseInt(items[5]), Integer.parseInt(items[6]), items[7], Integer.parseInt(items[8]), Integer.parseInt(items[9]), items[10]));
                } else if (items[0].startsWith("3")) {
                    Vehicle.add(new SUV(Integer.parseInt(items[0]), items[1], items[2], Integer.parseInt(items[3]), Double.parseDouble(items[4]), Integer.parseInt(items[5]), Integer.parseInt(items[6]), items[7], Integer.parseInt(items[8]), Integer.parseInt(items[9])));
                } else if (items[0].startsWith("4") || items[0].startsWith("5")) {
                    Vehicle.add(new Hybrid(Integer.parseInt(items[0]), items[1], items[2], Integer.parseInt(items[3]), Double.parseDouble(items[4]), Integer.parseInt(items[5]), Integer.parseInt(items[6]), items[7], Integer.parseInt(items[8]), Integer.parseInt(items[9]), items[10], Integer.parseInt(items[11])));
                } else if (items[0].startsWith("6")) {
                    Vehicle.add(new PickupTruck(Integer.parseInt(items[0]), items[1], items[2], Integer.parseInt(items[3]), Double.parseDouble(items[4]), Integer.parseInt(items[5]), Integer.parseInt(items[6]), items[7], Integer.parseInt(items[8]), Integer.parseInt(items[9]), items[10], Integer.parseInt(items[11])));
                }
            }

        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        Scanner input = new Scanner(System.in);
        displayMenu();
        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        if (choice == 1) {
            purchaseVehicle(Vehicle, input);
        }
    }
    public static void purchaseVehicle(List<Vehicle> vehicles, Scanner input) {
        System.out.println("Enter CarID: ");
        int carID = input.nextInt();
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getCarID() == carID) {
                found = true;
                int quantity = v.getQuantity();
                if (quantity > 0) {
                    v.setQuantity(quantity - 1);
                    System.out.println("The vehicle " + v.getVehicleType() + " has been purchased.");
                } else {
                    System.out.println("Vehicle unavailable.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle not found.");
        }
    }
    public static void displayMenu() {
        System.out.println("Welcome to Drive Masters");
        System.out.println("Please choose any option below");
        System.out.println("---------------------------------");
        System.out.println("1     Purchase Vehicle");
        System.out.println("2     Display Vehicles by Type");
        System.out.println("3     Display Vehicles by Type-Specific Attribute");
        System.out.println("4     Produce a Random List of Vehicles");
        System.out.println("5     Save & Exit");
    }
}


