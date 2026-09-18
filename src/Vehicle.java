public class Vehicle {

    int vehicleId;
    String brand;
    String model;
    double rentPerDay;
    boolean available;

    Vehicle(int vehicleId, String brand, String model, double rentPerDay) {

        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = true;
    }

    void displayVehicle() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rent per day: " + rentPerDay);
        System.out.println("Available: " + available);
    }
}