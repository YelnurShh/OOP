package Practice3.delivery.app;

import Practice3.delivery.model.*;
import Practice3.delivery.service.DeliveryService;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Engine petrolEngine = new Engine("V6 Petrol", 300);
        Engine dieselEngine = new Engine("V8 Diesel", 450);

        Car car = new Car("Toyota Camry", 5000, petrolEngine, 5);
        Truck truck = new Truck("Volvo FH", 15000, dieselEngine, 20000);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);

        DeliveryService service = new DeliveryService();

        System.out.println("--- Vehicle Information ---");
        service.printAllVehicles(vehicles);

        System.out.println("\n--- Delivery Costs ---");
        service.calculateAllDeliveries(vehicles);
        service.calculateTotalCost(vehicles);

        System.out.println("\n--- Overloaded Method Tests ---");
        System.out.println("Car with extra weight: " + car.calculateDeliveryCost(100));
        System.out.println("Truck with distance/fuel: " + truck.calculateDeliveryCost(500, 2.5));
    }
}