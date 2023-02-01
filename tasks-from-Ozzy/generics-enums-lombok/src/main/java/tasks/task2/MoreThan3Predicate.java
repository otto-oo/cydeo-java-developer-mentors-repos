package tasks.task2;

public class MoreThan3Predicate implements UnaryPredicate<String> {

    @Override
    public boolean test(String obj) {
        return obj.length()>3;
    }
}
