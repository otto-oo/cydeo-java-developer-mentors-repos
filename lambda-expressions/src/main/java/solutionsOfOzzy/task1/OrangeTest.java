package solutionsOfOzzy.task1;


import java.util.ArrayList;
import java.util.List;

public class OrangeTest {

    public static void main(String[] args) {

        List<Orange> inventory = new ArrayList<>();

        inventory.add(new Orange(300, Color.YELLOW));
        inventory.add(new Orange(100, Color.RED));
        inventory.add(new Orange(200, Color.YELLOW));
        inventory.add(new Orange(50, Color.ORANGE));


        OrangeFormatter orangeFormatter = orange -> "An orange of " + orange.getWeight() + "g";
        prettyPrintOrange(inventory, orangeFormatter);

        //prettyPrintOrange(inventory, orange -> "An orange of " + orange.getWeight() + "g");

        System.out.println("***************************************************************");
        OrangeFormatter fancyFormatter = orange -> {
            String weightLimit = orange.getWeight()>200 ? "Heavy":"Light";
            return  "A " + weightLimit + " " + orange.getColor() + " orange";
        };
        prettyPrintOrange(inventory, fancyFormatter);

    }

    public static void prettyPrintOrange(List<Orange> inventory, OrangeFormatter orangeFormatter) {
        for (Orange orange : inventory) {
            String output = orangeFormatter.accept(orange);
            System.out.println(output);
        }
    }
}
