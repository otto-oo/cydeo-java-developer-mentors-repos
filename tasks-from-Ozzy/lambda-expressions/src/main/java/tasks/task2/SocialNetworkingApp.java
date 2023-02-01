package tasks.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocialNetworkingApp {

    public static void main(String[] args) {

        Member member1 = new Member("Michael JORDAN", "jordan@gmail.com", 22, Gender.MALE);
        Member member2 = new Member("Larry BIRD", "birdn@gmail.com", 52, Gender.MALE);
        Member member3 = new Member("Marry GRAY", "mary@hotmail.com", 19, Gender.FEMALE);
        Member member4 = new Member("Sharon LEE", "jordan@gmail.com", 30, Gender.FEMALE);

        List<Member> members = new ArrayList<>(Arrays.asList(member1, member2, member3, member4));

        sendMessage(members, member -> member.getGender().equals(Gender.MALE) && (member.getAge() >= 18 && member.getAge() <= 25));


    }

    public static void sendMessage(List<Member> members, MemberPredicate memberPredicate) {

        for (Member member : members) {
            if (memberPredicate.test(member)) {
                System.out.println("The message is sent by the SOCIAL NETWORKING APP to " + member.getFullName() + " who is " + Gender.MALE + " and " + member.getAge() + " years old.");
            }
        }
    }
}
