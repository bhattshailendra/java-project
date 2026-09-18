public class Customer {

    int customerId;
    String name;
    String phone;

    Customer(int customerId, String name, String phone) {

        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    void displayCustomer() {

        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
    }
}