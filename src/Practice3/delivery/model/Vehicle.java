package Practice3.delivery.model;

public abstract class Vehicle {
    protected String model;
    protected double baseCost;
    protected Engine engine;

    public Vehicle(String model, double baseCost, Engine engine) {
        this.model = model;
        this.baseCost = baseCost;
        this.engine = engine;
    }

    public double calculateDeliveryCost() {
        return baseCost;
    }

    public void getVehicleInfo() {
        System.out.println("Model: " + model + ", Base Cost: " + baseCost);
        System.out.println(engine.getEngineInfo());
    }
}