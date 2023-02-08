package week_05_optional_solid_timeComplexity.solid.liskov_substitution.violation;


public class Car extends Vehicle {

    @Override
    public void changeGear(Gear gear) {
        if(Gear.R.equals(gear) && getGear().equals(Gear.D)){
            throw new RuntimeException("Can't change to REVERSE gear when " + getGear().toString() + " gear is engaged!");
        }
    }
}
