package tasks.task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the following classes:
 *
 * class Shape {  ...  }
 *
 class Circle extends Shape {...}
 *
 class Rectangle extends Shape {...}

 class Node<T> {...}
 *Will the following code compile?If not,why?
 *
 *Node<Circle> nc=new Node<>();
 *Node<Shape> ns=nc;
 */
public class Main {
    public static void main(String[] args) {
        Node<Shape> shapeNode = new Node<>();
        Node<Circle> circleNode = new Node<>();

        //Type is fixed. If we pass type as Circle we can not assign that object to the Node<Shape>
        //do not confuse inheritance relationship in generics.

        //We are going to get error in the following code fragments.
        //List<Object> list = new ArrayList<String>();
        //Node<Shape>  nodes = new Node<Circle>();
        Node<Circle> nc = new Node<>();
        //Node<Shape> ns = nc;

    }
}
