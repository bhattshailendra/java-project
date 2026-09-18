# Vehicle Rental System

## Project Description
The Vehicle Rental System is a Java-based console application that manages vehicles, customers, rentals, returns, billing, and rental history. It uses Object-Oriented Programming, ArrayList, methods, inheritance, polymorphism, and file handling.

## Features
- Add, display, search, and remove vehicles
- Support for Cars, Bikes, and other vehicles
- Add and search customers
- Rent and return vehicles
- Calculate rental bills
- Maintain rental history
- Save and load data using text files
- Menu-driven interaction
- Basic input validation

## Technologies and Concepts
- Java
- Classes and Objects
- Constructors
- Methods
- Inheritance
- Method Overriding
- Polymorphism
- Object Composition
- ArrayList / Collections
- File Handling (`FileWriter`, `FileReader`, `BufferedReader`)
- Exception Handling (`IOException`)

## Project Structure
```text
Vehicle Rental System
├── Main.java
├── Vehicle.java
├── Car.java
├── Bike.java
├── Customer.java
├── Rental.java
├── vehicles.txt
├── customers.txt
└── rentals.txt
```

## Main Classes
### Vehicle
Stores vehicle ID, brand, model, rent per day, and availability.

### Car
Extends `Vehicle` and adds the number of seats.

### Bike
Extends `Vehicle` and adds engine capacity in CC.

### Customer
Stores customer ID, name, and phone number.

### Rental
Connects a customer with a vehicle, stores rental duration, and calculates the total bill.

### Main
Contains the application flow, ArrayLists, menu, rental operations, searching, removal, and file handling.

## File Handling
The application stores data in:
- `vehicles.txt`
- `customers.txt`
- `rentals.txt`

Data is loaded when the application starts and can be saved through the application.

## Menu
```text
1. Display Vehicles
2. Add Vehicle
3. Search Vehicle
4. Remove Vehicle
5. Add Customer
6. Search Customer
7. Rent Vehicle
8. Return Vehicle
9. Rental History
10. Save Data
11. Exit
```

## How to Run
1. Open the project in IntelliJ IDEA.
2. Make sure all Java classes are in the same source package/folder.
3. Run `Main.java`.
4. Use the numbered menu options.
5. Use **Save Data** before closing if changes need to be stored.

## OOP Concepts Demonstrated
- **Encapsulation:** Data and related operations are grouped inside classes.
- **Inheritance:** `Car` and `Bike` extend `Vehicle`.
- **Polymorphism:** A `Vehicle` reference can refer to a `Car` or `Bike`, with overridden `displayVehicle()` methods being invoked at runtime.
- **Composition:** `Rental` contains references to `Customer` and `Vehicle`.

## Author
**Ankit Nag**

B.Tech CSE (AI & ML)  
VIT Bhopal
