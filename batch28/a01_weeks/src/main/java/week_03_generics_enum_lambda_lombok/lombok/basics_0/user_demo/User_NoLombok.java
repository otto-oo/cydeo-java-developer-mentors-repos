package week_03_generics_enum_lambda_lombok.lombok.basics_0.user_demo;

public class User_NoLombok {

    private final String firstName; // required
    private final String lastName;  // required
    private int age;          // optional
    private String phone;     // optional
    private String address;   // optional

    private User_NoLombok(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //All getter, and NO setter to provide immutability
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: " + this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.phone + ", " + this.address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        //Return the finally constructed User object
        public User_NoLombok build() {
            User_NoLombok user = new User_NoLombok(this);
            validateUserObject(user);
            return user;
        }

        private void validateUserObject(User_NoLombok user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
