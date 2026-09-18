import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Create vehicles
        Vehicle v1 = new Vehicle(101, "Toyota", "Innova", 2500);
        Vehicle v2 = new Vehicle(102, "Honda", "City", 1800);
        Vehicle v3 = new Vehicle(103, "Hyundai", "Creta", 2200);

        Vehicle car1 = new Car(201, "Toyota", "Fortuner", 3500, 7);

        Vehicle bike1 = new Bike(
                301,
                "Royal Enfield",
                "Classic 350",
                1000,
                350
        );


        // 2. Create ArrayList
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        ArrayList<Customer> customers = new ArrayList<>();
        loadCustomers(customers);

        ArrayList<Rental> rentals = new ArrayList<>();


        loadVehicles(vehicles);
        loadCustomers(customers);
        loadRentals(rentals, customers, vehicles);


        //menu

        while (true) {


            System.out.println("\n========== VEHICLE RENTAL SYSTEM ==========");
            System.out.println("1. Display Vehicles");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Remove Vehicle");
            System.out.println("5. Add Customer");
            System.out.println("6. Search Customer");
            System.out.println("7. Rent Vehicle");
            System.out.println("8. Return Vehicle");
            System.out.println("9. Rental History");
            System.out.println("10. Save Data");
            System.out.println("11. Exit");
            System.out.println("=====================");


            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayVehicles(vehicles);
                    break;

                case 2:
                    addVehicle(vehicles, sc);
                    break;

                case 3:
                    searchVehicle(vehicles, sc);
                    break;

                case 4:
                    removeVehicle(vehicles, sc);
                    break;

                case 5:
                    addCustomer(customers, sc);
                    break;

                case 6:
                    searchCustomer(customers, sc);
                    break;

                case 7:
                    rentVehicle(vehicles, customers, rentals, sc);
                    break;

                case 8:
                    returnVehicle(vehicles, rentals, sc);
                    break;

                case 9:
                    displayRentalHistory(rentals);
                    break;

                case 10:
                    saveVehicles(vehicles);
                    saveCustomers(customers);
                    saveRentals(rentals);
                    break;

                case 11:
                    System.out.println("Thank you for using Vehicle Rental System!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
            saveVehicles(vehicles);
            saveCustomers(customers);
            saveRentals(rentals);

            sc.close();
        }


    }
    static void addVehicle(ArrayList<Vehicle> vehicles, Scanner sc) {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        for (Vehicle v : vehicles) {

            if (v.vehicleId == id) {
                System.out.println("Vehicle ID already exists!");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Rent per day: ");
        double rent = sc.nextDouble();

        if (rent <= 0) {
            System.out.println("Rent must be greater than 0!");
            return;
        }

        System.out.println("Select Vehicle Type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Other");

        System.out.print("Enter choice: ");
        int type = sc.nextInt();

        Vehicle vehicle;

        if (type == 1) {

            System.out.print("Enter number of seats: ");
            int seats = sc.nextInt();

            if (seats <= 0) {
                System.out.println("Number of seats must be greater than 0!");
                return;
            }

            vehicle = new Car(id, brand, model, rent, seats);

        } else if (type == 2) {

            System.out.print("Enter engine CC: ");
            int engineCC = sc.nextInt();

            if (engineCC <= 0) {
                System.out.println("Engine CC must be greater than 0!");
                return;
            }

            vehicle = new Bike(id, brand, model, rent, engineCC);

        } else if (type == 3) {

            vehicle = new Vehicle(id, brand, model, rent);

        } else {

            System.out.println("Invalid vehicle type!");
            return;
        }

        vehicles.add(vehicle);

        System.out.println("Vehicle added successfully!");
    }
    static void displayVehicles(ArrayList<Vehicle> vehicles) {

        for (Vehicle v : vehicles) {
            v.displayVehicle();
            System.out.println();
        }
    }
    static void searchVehicle(ArrayList<Vehicle> vehicles, Scanner sc) {

        System.out.print("Enter Vehicle ID to search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Vehicle v : vehicles) {

            if (v.vehicleId == id) {

                v.displayVehicle();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Vehicle not found!");
        }
    }
    static void removeVehicle(ArrayList<Vehicle> vehicles, Scanner sc) {

        System.out.print("Enter Vehicle ID to remove: ");
        int id = sc.nextInt();

        boolean removed = false;

        for (int i = 0; i < vehicles.size(); i++) {

            if (vehicles.get(i).vehicleId == id) {

                if (!vehicles.get(i).available) {
                    System.out.println("Cannot remove a rented vehicle!");
                    return;
                }

                vehicles.remove(i);
                removed = true;

                System.out.println("Vehicle removed successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Vehicle not found!");
        }
    }
    static void addCustomer(ArrayList<Customer> customers, Scanner sc) {

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        for (Customer c : customers) {

            if (c.customerId == id) {
                System.out.println("Customer ID already exists!");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(id, name, phone);

        customers.add(customer);

        System.out.println("Customer added successfully!");
    }
    static void searchCustomer(ArrayList<Customer> customers, Scanner sc) {

        System.out.print("Enter Customer ID to search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Customer c : customers) {

            if (c.customerId == id) {

                c.displayCustomer();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Customer not found!");
        }
    }
    static void rentVehicle(ArrayList<Vehicle> vehicles,
                            ArrayList<Customer> customers,
                            ArrayList<Rental> rentals,
                            Scanner sc) {

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        Customer selectedCustomer = null;

        for (Customer c : customers) {

            if (c.customerId == customerId) {
                selectedCustomer = c;
                break;
            }
        }

        if (selectedCustomer == null) {
            System.out.println("Customer not found!");
            return;
        }


        System.out.print("Enter Vehicle ID: ");
        int vehicleId = sc.nextInt();

        Vehicle selectedVehicle = null;

        for (Vehicle v : vehicles) {

            if (v.vehicleId == vehicleId) {
                selectedVehicle = v;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }


        if (!selectedVehicle.available) {
            System.out.println("Vehicle is already rented!");
            return;
        }


        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        if (days <= 0) {
            System.out.println("Number of days must be greater than 0!");
            return;
        }
        int rentalId = rentals.size() + 1;

        Rental rental = new Rental(
                rentalId,
                selectedCustomer,
                selectedVehicle,
                days
        );

        rentals.add(rental);

        selectedVehicle.available = false;

        System.out.println("Vehicle rented successfully!");
        System.out.println("Rental ID: " + rentalId);
        System.out.println("Total Bill: " + rental.calculateBill());

    }
    static void returnVehicle(ArrayList<Vehicle> vehicles,
                              ArrayList<Rental> rentals,
                              Scanner sc) {

        System.out.print("Enter Vehicle ID to return: ");
        int vehicleId = sc.nextInt();

        Vehicle selectedVehicle = null;

        for (Vehicle v : vehicles) {

            if (v.vehicleId == vehicleId) {
                selectedVehicle = v;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        if (selectedVehicle.available) {
            System.out.println("This vehicle is not currently rented!");
            return;
        }

        selectedVehicle.available = true;

        System.out.println("Vehicle returned successfully!");
    }
    static void displayRentalHistory(ArrayList<Rental> rentals) {

        if (rentals.isEmpty()) {
            System.out.println("No rental records found!");
            return;
        }

        System.out.println("========== RENTAL HISTORY ==========");

        for (Rental r : rentals) {

            r.displayRental();

            System.out.println("------------------------------------");
        }
    }
    static void saveVehicles(ArrayList<Vehicle> vehicles) {

        try {

            FileWriter writer = new FileWriter("vehicles.txt");

            for (Vehicle v : vehicles) {

                writer.write(
                        v.vehicleId + "," +
                                v.brand + "," +
                                v.model + "," +
                                v.rentPerDay + "," +
                                v.available + "\n"
                );
            }

            writer.close();

            System.out.println("Vehicles saved successfully!");

        } catch (IOException e) {

            System.out.println("Error while saving vehicles.");
        }
    }
    static void loadVehicles(ArrayList<Vehicle> vehicles) {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("vehicles.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String brand = data[1];
                String model = data[2];
                double rent = Double.parseDouble(data[3]);
                boolean available = Boolean.parseBoolean(data[4]);

                Vehicle vehicle = new Vehicle(id, brand, model, rent);

                vehicle.available = available;

                vehicles.add(vehicle);
            }

            reader.close();

            System.out.println("Vehicles loaded successfully!");

        } catch (IOException e) {

            System.out.println("No vehicle data found.");
        }
    }
    static void saveCustomers(ArrayList<Customer> customers) {

        try {

            FileWriter writer = new FileWriter("customers.txt");

            for (Customer c : customers) {

                writer.write(
                        c.customerId + "," +
                                c.name + "," +
                                c.phone + "\n"
                );
            }

            writer.close();

            System.out.println("Customers saved successfully!");

        } catch (IOException e) {

            System.out.println("Error while saving customers.");
        }
    }
    static void loadCustomers(ArrayList<Customer> customers) {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("customers.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String phone = data[2];

                Customer customer = new Customer(id, name, phone);

                customers.add(customer);
            }

            reader.close();

            System.out.println("Customers loaded successfully!");

        } catch (IOException e) {

            System.out.println("No customer data found.");
        }
    }
    static void saveRentals(ArrayList<Rental> rentals) {

        try {

            FileWriter writer = new FileWriter("rentals.txt");

            for (Rental r : rentals) {

                writer.write(
                        r.rentalId + "," +
                                r.customer.customerId + "," +
                                r.vehicle.vehicleId + "," +
                                r.days + "\n"
                );
            }

            writer.close();

            System.out.println("Rental records saved successfully!");

        } catch (IOException e) {

            System.out.println("Error while saving rental records.");
        }
    }
    static void loadRentals(ArrayList<Rental> rentals,
                            ArrayList<Customer> customers,
                            ArrayList<Vehicle> vehicles) {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("rentals.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int rentalId = Integer.parseInt(data[0]);
                int customerId = Integer.parseInt(data[1]);
                int vehicleId = Integer.parseInt(data[2]);
                int days = Integer.parseInt(data[3]);

                Customer selectedCustomer = null;

                for (Customer c : customers) {
                    if (c.customerId == customerId) {
                        selectedCustomer = c;
                        break;
                    }
                }

                Vehicle selectedVehicle = null;

                for (Vehicle v : vehicles) {
                    if (v.vehicleId == vehicleId) {
                        selectedVehicle = v;
                        break;
                    }
                }

                if (selectedCustomer != null && selectedVehicle != null) {

                    Rental rental = new Rental(
                            rentalId,
                            selectedCustomer,
                            selectedVehicle,
                            days
                    );

                    rentals.add(rental);

                    selectedVehicle.available = false;
                }
            }

            reader.close();

            System.out.println("Rental records loaded successfully!");

        } catch (IOException e) {

            System.out.println("No rental data found.");
        }
    }
    static void displayCustomers(ArrayList<Customer> customers) {

        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }

        System.out.println("========== CUSTOMER LIST ==========");

        for (Customer c : customers) {
            c.displayCustomer();
            System.out.println("-----------------------------------");
        }
    }
}