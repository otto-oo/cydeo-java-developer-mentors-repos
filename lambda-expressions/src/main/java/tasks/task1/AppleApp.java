package tasks.task1;



import java.util.Arrays;
import java.util.List;

public class AppleApp {

    public static void main(String[] args) {

        Apple apple1 = new Apple(250, Color.GREEN);
        Apple apple2 = new Apple(300, Color.RED);
        Apple apple3 = new Apple(150, Color.GREEN);
        Apple apple4 = new Apple(120, Color.RED);
        Apple apple5 = new Apple(400, Color.RED);

        List<Apple> inventory = Arrays.asList(apple1, apple2, apple3, apple4, apple5);
        prettyPrintApple(inventory, apple -> apple.getWeight() > 200 ? "A Heavy " + apple.getColor() + " apple" : "A Light " + apple.getColor() + " apple");
        prettyPrintApple(inventory, apple -> "An apple of " + apple.getWeight() + "g");
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            System.out.println(appleFormatter.accept(apple));
        }
    }
}
