package Optional.model;

public class Engine {
    private VelocityMonitor monitor;

    public Engine(VelocityMonitor monitor) {
        this.monitor = monitor;
    }

    public VelocityMonitor getMonitor() {
        return monitor;
    }

    public void setMonitor(VelocityMonitor monitor) {
        this.monitor = monitor;
    }
}
