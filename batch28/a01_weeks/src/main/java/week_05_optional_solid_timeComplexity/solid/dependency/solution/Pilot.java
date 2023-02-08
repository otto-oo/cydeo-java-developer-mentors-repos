package week_05_optional_solid_timeComplexity.solid.dependency.solution;

public class Pilot {

    private final Vehicle vehicle;

    public Pilot(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void increaseSpeed(){
        vehicle.accelerate();
    }
}
