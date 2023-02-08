package week_05_optional_solid_timeComplexity.solid.open_closed.violation;


public class Vehicle {

    private int power;
    private int suspensionHeight;

    public int getPower() {
        return power;
    }

    public int getSuspensionHeight() {
        return suspensionHeight;
    }

    public void setPower(final int power) {
        this.power = power;
    }

    public void setSuspensionHeight(final int suspensionHeight) {
        this.suspensionHeight = suspensionHeight;
    }

}