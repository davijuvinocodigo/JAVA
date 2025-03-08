package Optional.model;

public class Spaceship {
    private Engine engine;
    private String pilot;

    public Spaceship() {
    }

    public Spaceship(Engine engine, String pilot) {
        this.engine = engine;
        this.pilot = pilot;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }
}
