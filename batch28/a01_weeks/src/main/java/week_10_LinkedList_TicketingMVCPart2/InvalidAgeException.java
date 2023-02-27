package week_10_LinkedList_TicketingMVCPart2;

public class InvalidAgeException extends Exception {

//    public InvalidAgeException(String message) {
//        super(message);
//    }

//    public InvalidAgeException() {
//    }

}

class AppTest {
    public static void main(String[] args) throws InvalidAgeException {
        System.out.println("isValid : " + isValid(15));
//        try {
//            System.out.println("isValid : " + isValid(15));
//        } catch (InvalidAgeException e) {
//            System.err.println(e.getMessage());
////            e.printStackTrace();
//        }
        System.out.println("end");
    }

    static boolean isValid(int age) throws InvalidAgeException {
        if (age < 18) {
//            throw new InvalidAgeException("You are not eligible to vote");
            throw new InvalidAgeException();
        } else if (age > 110) {
//            throw new InvalidAgeException("Please write a valid age");
            throw new InvalidAgeException();
        }
        return true;
    }
}
