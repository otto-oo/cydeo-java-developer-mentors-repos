package week_05_optional_solid_timeComplexity.solid.dependency.solution;

public class VehicleTest {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar(100);

        Pilot pilot = new Pilot(racingCar);
        System.out.println("racingCar.getRemainingFuel() = " + racingCar.getRemainingFuel());
        System.out.println("racingCar.getPower() = " + racingCar.getPower());

        pilot.increaseSpeed();
        System.out.println("racingCar.getRemainingFuel() = " + racingCar.getRemainingFuel());
        System.out.println("racingCar.getPower() = " + racingCar.getPower());
    }
}
