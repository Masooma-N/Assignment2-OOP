import problemdomain.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int choice = 0;
    while (choice !=5) {
        displayMenu();
        System.out.println("Enter your choice: ");
        choice = input.nextInt();
        if (choice == 1) {
            purchaseVehicle(Vehicle, input);
        } else if (choice == 2) {
            input.nextLine();
            displayVehiclesByType(Vehicle, input);
        } else if (choice == 3) {
            input.nextLine();
            displayVehiclesByAttribute(Vehicle, input);
        } else if (choice == 4) {
            displayRandomVehicles(Vehicle, input);
        } else if (choice == 5) {
            saveVehiclesToFile(Vehicle, "src/res/Vehicle.txt");
            System.out.println("Goodbye!");
        }
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
                    System.out.println("The Vehicle \"" + v.getVehicleType() + " " + v.getSubtype() + "\" has been purchased.");
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
    public static void displayVehiclesByType(List<Vehicle> vehicles, Scanner input) {

        System.out.println("\n1. Sedan");
        System.out.println("2. Hatchback");
        System.out.println("3. SUV");
        System.out.println("4. Hybrid");
        System.out.println("5. Pickup Truck");
        System.out.print("Enter type of vehicle: ");

        String choice = input.nextLine().trim();

        boolean found = false;

        for (Vehicle vehicle : vehicles) {

            if (choice.equals("1") && vehicle instanceof Sedan) {
                System.out.println(vehicle);
                found = true;

            } else if (choice.equals("2") && vehicle instanceof Hatchback) {
                System.out.println(vehicle);
                found = true;

            } else if (choice.equals("3") && vehicle instanceof SUV) {
                System.out.println(vehicle);
                found = true;

            } else if (choice.equals("4") && vehicle instanceof Hybrid) {
                System.out.println(vehicle);
                found = true;

            } else if (choice.equals("5") && vehicle instanceof PickupTruck) {
                System.out.println(vehicle);
                found = true;
            }
        }

        if (!found) {
            if (choice.equals("1") || choice.equals("2") ||
                    choice.equals("3") || choice.equals("4") ||
                    choice.equals("5")) {

                System.out.println("No vehicles found for this type.");

            } else {
                System.out.println("Invalid vehicle type.");
            }
        }
    }
    public static void displayVehiclesByAttribute(
            List<Vehicle> vehicles, Scanner scanner) {

        System.out.println("\n1. Sedan");
        System.out.println("2. Hatchback");
        System.out.println("3. SUV");
        System.out.println("4. Hybrid");
        System.out.println("5. Pickup Truck");
        System.out.print("Enter type of vehicle: ");

        String choice = scanner.nextLine().trim();

        // Request the attribute for the selected vehicle type.
        switch (choice) {
            case "1":
                System.out.print(
                        "Enter trunk size (L for Large/Spacious Trunk, "
                                + "S for Small Trunk, or M for Moderate Trunk): ");
                break;

            case "2":
                System.out.print(
                        "Enter hatch type (S for Standard Liftgate, "
                                + "T for Split Liftgate, P for Power Liftgate): ");
                break;

            case "3":
                System.out.print(
                        "Enter drivetrain (AWD for All Wheel Drive, "
                                + "4WD for Four Wheel Drive): ");
                break;

            case "4":
                System.out.print(
                        "Enter a powertrain (E for Series Hybrid, "
                                + "A for Parallel Hybrid, PHEV for Plug-in Hybrid): ");
                break;

            case "5":
                System.out.print(
                        "Enter cargo bed type (SB for Short Bed, "
                                + "EB for Extended Bed, or DB for Dump Bed): ");
                break;

            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        String searchValue = scanner.nextLine().trim();

        if (searchValue.isEmpty()) {
            System.out.println("Attribute cannot be empty.");
            return;
        }

        boolean found = false;
        System.out.println("\nMatching Vehicles:");

        // Only inspect the attribute belonging to the selected type.
        for (Vehicle vehicle : vehicles) {
            String attributeValue = null;

            switch (choice) {
                case "1":
                    if (vehicle instanceof Sedan) {
                        Sedan sedan = (Sedan) vehicle;
                        attributeValue =
                                String.valueOf(sedan.getTrunkSize());
                    }
                    break;

                case "2":
                    if (vehicle instanceof Hatchback) {
                        Hatchback hatchback = (Hatchback) vehicle;
                        attributeValue =
                                String.valueOf(hatchback.getHatchType());
                    }
                    break;

                case "3":
                    if (vehicle instanceof SUV) {
                        SUV suv = (SUV) vehicle;
                        attributeValue =
                                String.valueOf(suv.getDrivetrain());
                    }
                    break;

                case "4":
                    if (vehicle instanceof Hybrid) {
                        Hybrid hybrid = (Hybrid) vehicle;
                        attributeValue =
                                String.valueOf(hybrid.getPowertrain());
                    }
                    break;

                case "5":
                    if (vehicle instanceof PickupTruck) {
                        PickupTruck pickupTruck = (PickupTruck) vehicle;
                        attributeValue =
                                String.valueOf(pickupTruck.getCargoBedType());
                    }
                    break;
            }

            if (attributeValue != null
                    && attributeValue.trim()
                    .equalsIgnoreCase(searchValue)) {

                System.out.println(vehicle);
                System.out.println("----------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching vehicles found.");
        }
    }
    public static void displayRandomVehicles(List<Vehicle> vehicles, Scanner scanner) {
        System.out.print("Enter number of vehicles to display: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available in the inventory.");
            return;
        }

        List<Vehicle> shuffledList = new ArrayList<>(vehicles);
        Collections.shuffle(shuffledList);

        System.out.println("\nRandom Vehicles:");
        int limit = Math.min(count, shuffledList.size());

        for (int i = 0; i < limit; i++) {
            System.out.println(shuffledList.get(i).toString());
            System.out.println("----------------------------------");
        }
    }
    public static void saveVehiclesToFile(List<Vehicle> vehicles, String filePath) {
        System.out.print("Saving Vehicles... ");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Vehicle vehicle : vehicles) {
                writer.println(vehicle.toFileString());
            }
            System.out.println("Done!");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}


