package week_05_optional_solid_timeComplexity.solid.liskov_substitution.violation;


public class Vehicle {

    private Gear gear;

    public Gear getGear() {
        return gear;
    }

    public void changeGear(final Gear gear) {
        this.gear = gear;
    }

}