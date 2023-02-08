package week_05_optional_solid_timeComplexity.solid.dependency.solution;

import lombok.Getter;

@Getter
public class RacingCar implements Vehicle{

    private final int maxFuel;
    private int remainingFuel;
    private int power;

    public RacingCar(int maxFuel) {
        this.maxFuel = maxFuel;
        this.remainingFuel = maxFuel;
    }

    @Override
    public void accelerate(){
        power++;
        remainingFuel--;
    }

    private void refuel(int fuel){
        int tempFuel = fuel + remainingFuel;
        remainingFuel = Math.min(tempFuel, maxFuel);
    }
}
