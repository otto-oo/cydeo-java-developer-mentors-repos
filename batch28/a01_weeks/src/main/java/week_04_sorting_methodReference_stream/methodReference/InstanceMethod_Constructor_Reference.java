package week_04_sorting_methodReference_stream.methodReference;

interface Printable {
    void printMessage();
}

class Message {

    public Message() {
    }

    public Message(String message) {
        System.out.println(message);
    }

    public void getMessage() {
        System.out.println("Hello!");
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("anonymous class example: ");
        Printable printable1 = new Printable() {
            @Override
            public void printMessage() {
                new Message().getMessage();
            }
        };
        printable1.printMessage();

        System.out.println("lambda example: ");
        Printable printableLambda = () -> new Message().getMessage();
        printableLambda.printMessage();

        System.out.println("instance method reference example: ");
        Message msg = new Message();
        Printable printable2 = msg::getMessage;                         // same
        printable2.printMessage();

        System.out.println("instance method reference example2: ");
        Printable printable3 = new Message()::getMessage;               // same
        printable3.printMessage();

        System.out.println("constructor reference example: ");
        PrintableConstructor printable4 = Message::new;
        printable4.printMessage("Hello Constructor");
    }
}

interface PrintableConstructor {
    void printMessage(String message);
}