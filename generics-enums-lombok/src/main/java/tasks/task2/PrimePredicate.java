package tasks.task2;

public class PrimePredicate implements UnaryPredicate<Integer> {
    @Override
    public boolean test(Integer obj) {


        if (obj == 0 || obj == 1) {
            return false;
        }

        for (int i = 2; i < obj; i++) {
            if (obj % i == 0) {
                return true;
            }
        }
        return false;
    }
}
