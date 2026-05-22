package Practice3.delivery.model;

public class Engine {
    private String type;
    private int horsepower;

    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    public String getEngineInfo() {
        return "Engine: " + type + " (" + horsepower + " HP)";
    }
}