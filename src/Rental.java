public class Rental {

    int rentalId;
    Customer customer;
    Vehicle vehicle;
    int days;

    Rental(int rentalId, Customer customer, Vehicle vehicle, int days) {

        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    double calculateBill() {

        return vehicle.rentPerDay * days;
    }

    void displayRental() {

        System.out.println("Rental ID: " + rentalId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Vehicle: " + vehicle.brand + " " + vehicle.model);
        System.out.println("Days: " + days);
        System.out.println("Total Bill: " + calculateBill());
    }
}