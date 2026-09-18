public class Bike extends Vehicle {

    int engineCC;

    Bike(int vehicleId, String brand, String model,
         double rentPerDay, int engineCC) {

        super(vehicleId, brand, model, rentPerDay);
        this.engineCC = engineCC;
    }

    @Override
    void displayVehicle() {

        super.displayVehicle();

        System.out.println("Engine: " + engineCC + " CC");
    }
}