package basics_1.singular;

public class MainSingular {
    public static void main(String[] args) {


        Student_Singular build = Student_Singular.builder()
                .name("John")
                .surname("Singular")
                .email("emial@email.com")
                .course("Spring")
                .course("Java")    //singular method enables adding a single item to the collection.
                .build();

        System.out.println(build);
    }
}
