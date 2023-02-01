package tasks.task2;

public class EvenPredicate implements UnaryPredicate<Integer> {
    @Override
    public boolean test(Integer obj) {
        if (obj % 2 == 0) {
            return true;
        }
        return false;
    }
}
