package tasks.task5;

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
public abstract class Shape {

    public abstract double getArea();

    public abstract double getPerimeter();**
}
