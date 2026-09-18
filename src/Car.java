public class Car extends Vehicle {

    int seats;

    Car(int vehicleId, String brand, String model,
        double rentPerDay, int seats) {

        super(vehicleId, brand, model, rentPerDay);
        this.seats = seats;
    }

    @Override
    void displayVehicle() {

        super.displayVehicle();

        System.out.println("Number of seats: " + seats);
    }
}