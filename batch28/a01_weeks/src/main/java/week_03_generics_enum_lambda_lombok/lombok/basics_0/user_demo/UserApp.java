package week_03_generics_enum_lambda_lombok.lombok.basics_0.user_demo;

public class UserApp {

    public static void main(String[] args) {
        User_NoLombok user1 = new User_NoLombok.UserBuilder("Mike", "Smith")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();
        System.out.println(user1);

        User_Lombok user2 = User_Lombok.builder()
                .firstName("John")
                .lastName("Doe")
                .age(40)
                .phone("5655")
                //no address
                .build();
        System.out.println(user2);

        User_Lombok user3 = User_Lombok.builder()
                .firstName("Super")
                .lastName("Man")
                //No age
                //No phone
                //no address
                .build();
        System.out.println(user3);

        user2.setAge(42);

    }
}
