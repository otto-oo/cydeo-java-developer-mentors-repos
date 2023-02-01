package tasks;

public enum Enums {
    ONE("One"), TWO("Two"), THREE("Three"), FOUR, FIVE("Five", 5);

    String s;
    Integer n = -1;

    Enums() {
    }

    Enums(String s) {
        this.s = s;
    }

    Enums(String s, Integer n) {
        this.s = s;
        this.n = n;
    }

    void method() {
        System.out.println(s);
    }
}

class MainClass {
    public static void main(String[] args) {
        Enums.ONE.method();

        Enums.TWO.method();

        Enums.THREE.method();

        System.out.println(Enums.FOUR.s);

        System.out.println(Enums.ONE.n);
        System.out.println(Enums.FIVE.n);

    }
}