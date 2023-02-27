package week_06_TwoPointer_StringBuilderBuffer_Regex_UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {
    public static void main(String[] args) {
//        howToRemoveUnwantedChars();
//        matchersTest();
        decimalOrFloatNumber();
//        setOfCharacters();
    }

    static void howToRemoveUnwantedChars() {
        String str = "(A+B)- ((CD)/ [F(B/2)])a, _{G-F}";
        // how to clean others and just keep parenthesis :
        System.out.println("keep only (){} : " + str.replaceAll("[^(){}]", ""));    // ()(()[()]){}
        System.out.println("keep all parenthesis : " + str.replaceAll("[^(){}\\[\\]]", ""));    // ()(()[()]){}
        System.out.println("keep only alphanumerics : " + str.replaceAll("[^a-z0-9A-Z]", ""));    // ABCDFB2a
        System.out.println("replace only first match: " + str.replaceFirst("[^a-z0-9A-Z]", "")); // A+B)- ((CD)/ [F(B/2)])a, _{}
        System.out.println("str.replace example : " + str.replace("[^a-z0-9A-Z]", "")); // (A+B)- ((CD)/ [F(B/2)])a, _{}
    }

    static void matchersTest() {
        System.out.println("hello ? hello : " + "hello".matches("hello"));  // true
        System.out.println("grey ? gray|grey : " + "grey".matches("gray|grey"));  // true
        System.out.println("gray ? gray|grey : " + "gray".matches("gray|grey"));  // true
        System.out.println("gray ? gray|grey : " + "gray".matches("gr(a|e)y"));  // true
        System.out.println("gray ? gray|grey : " + "gray".matches("gr[ae]y"));  // true

        System.out.println(runTest(".", "foo"));  // 3
        System.out.println(runTest("[abc]", "cab"));  // 3
        System.out.println(runTest("[A-Z]", "Two Uppercase alphabets 34 overall"));  // 2   (34 characters)
        System.out.println(Arrays.toString("Two Uppercase alphabets 34 overall".split("[A-Z]")));  // 3 elements
        System.out.println(Arrays.toString("Two Uppercase alphabets".split(" ")));  // 3 elements
        System.out.println(Arrays.toString(" Two Uppercase alphabets".split(" ")));  // 4 elements
    }

    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    static void setOfCharacters() {
        System.out.println("Two Uppercase alphabets 34 overall".length());  // 34
        System.out.println(runTest("[1-5]", "Two Uppercase alphabets 34 overall"));   // 2
        System.out.println(runTest("[a-zA-Z]", "Two Uppercase alphabets 34 overall"));  // 28 all lower and uppercase letters but not spaces and digits
        System.out.println(runTest("3[0-5]", "Two Uppercase alphabets 34 overall"));   // 1
        System.out.println(runTest("[1-3[7-9]]", "123456789"));   // 6     Union Class
        System.out.println(runTest("[1-6&&[3-9]]", "123456789"));   // 4   Intersection Class: the intersection of the two sets has only 4 elements
        System.out.println(runTest("[0-9&&[^2468]]", "123456789"));   // 5   Subtraction Class: Only 1,3,5,7,9 will be matched.

        System.out.println("string matches ex a: " + "a".matches("[a-zA-Z]"));      // true
        System.out.println("string matches ex bat: " + "bat".matches("[bcr]at"));      // true
        System.out.println("string matches ex pet: " + "pet".matches("[^bcr]et"));      // true
        System.out.println("string matches ex foo: " + "foo".matches("..."));    // true
        System.out.println("string matches ex abc ? [abc]: " + "abc".matches("[abc]"));    // false
        System.out.println("string matches ex abc ? : [abc]bc" + "abc".matches("[abc]bc"));    // true
        System.out.println("string matches ex abcaabcccc ? : [abc]+" + "abcaabcccc".matches("[abc]+"));    // true
        System.out.println("string matches ex cab ? [abc]+: " + "cab".matches("[abc]+"));    // true
        System.out.println("string matches ex abc4 ? : [abc]+" + "abc4".matches("[abc]+"));    // false
        System.out.println("string matches ex abc ? [a-c]: " + "abc".matches("(?=[a-c])"));    // true
        System.out.println("string matches ex cab: " + "cab".matches("[abc] + [abc] + [abc]"));    // false
        System.out.println("string matches ex b: " + "b".matches("[abc]"));      // true
        System.out.println("string matches ex bat cat rat: " + "bat cat rat".matches("[bcr]at"));      // false
    }

    static void predefiendCharacterClasses() {
        // Predefined Character Classes:

        //Matching digits, equivalent to [0-9]:
        System.out.println(runTest("\\d", "123"));   // 3
        //Matching non-digits, equivalent to [^0-9]:
        System.out.println(runTest("\\D", "a6c"));   // 2  a c
        //Matching white space:
        System.out.println(runTest("\\s", "a c"));   // 1  finds space
        //Matching non-white space:
        System.out.println(runTest("\\S", "a c"));   // 2  a c
        //Matching a word character, equivalent to [a-zA-Z_0-9]:
        System.out.println(runTest("\\w", "hi! abc3***"));   // 6  hiabc3
        //Matching a non-word character:
        System.out.println(runTest("\\W", "hi!*+-3"));   // 4  !*+-
    }

    static void quantifiers() {
        //Quantifiers
        //To match a text zero or one time, we use the ? quantifier:
        System.out.println(runTest("\\a?", "hihi"));   // 5  includes zero match
        //Alternatively, we can use the brace syntax:
        System.out.println(runTest("\\a{0,1}", "hihi"));   // 5  includes zero match
        /*
This example introduces the concept of zero-length matches. It so happens that if a quantifier's threshold for matching is zero,
it always matches everything in the text including an empty String at the end of every input.
This means that even if the input is empty, it will return one zero-length match.
This explains why we get 3 matches in the above example despite having a String of length two.
The third match is zero-length empty String.
         */

        //To match a text zero or limitless times, we us * quantifier, it is just similar to ?:
        System.out.println(runTest("\\a*", "hi"));   // 3  includes zero match
        //Supported alternative:
        System.out.println(runTest("\\a{0,}", "hi"));   // 3  includes zero match

        //The quantifier with a difference is +, it has a matching threshold of 1.
        // If the required String does not occur at all, there will be no match, not even a zero-length String:
        System.out.println(runTest("\\a+", "hi"));   // 0
        //Supported alternative:
        System.out.println(runTest("\\a{1,}", "hi"));   // 0
        //the brace syntax can be used to match a given text a number of times:
        System.out.println(runTest("a{3}", "aaaaaa"));   // 2
        System.out.println(runTest("a{3}", "aa"));   // 0
        System.out.println(runTest("abc", "abcabc"));   // 2
        // When we use a range in the brace, the match will be greedy, matching from the higher end of the range:
        System.out.println(runTest("a{2,3}", "aaaa"));   // 1
        System.out.println(runTest("a{2,3}", "aaaaa"));   // 2
        /*
        We've specified at least two occurrences but not exceeding three, so we get a single match instead
        where the matcher sees a single aaa and a lone a which can't be matched.
         */
        //However, the API allows us to specify a lazy or reluctant approach such that the matcher can start from
        // the lower end of the range in which case matching two occurrences as aa and aa:
        System.out.println(runTest("a{2,3}?", "aaaa"));   // 2
    }

    static void capturingGroups() {
        //Capturing Groups
        //Let's use a capturing group that matches only when an input text contains two digits next to each other:
        System.out.println(runTest("(\\d\\d)", "12"));   // 1
        System.out.println(runTest("(\\d\\d)", "1212"));   // 2
        System.out.println(runTest("(\\d\\d)\\1", "1212"));   // 1
        System.out.println(runTest("(\\d\\d)(\\d\\d)", "1212"));   // 1
        System.out.println(runTest("(\\d\\d)\\1\\1\\1", "12121212"));   // 1
        System.out.println(runTest("(\\d\\d)\\1", "1213"));   // 0        must repeat same digits
    }

    static void boundaryMatchers() {
        //Boundary Matchers
        // If we care about where exactly in the input text the match should occur, then this is what we are looking for.
        // With the previous examples, all we cared about was whether a match was found or not.

        //To match only when the required regex is true at the beginning of the text, we use the caret ^.
        System.out.println(runTest("^dog", "dogs are friendly"));   // 1        text must start with dogs
        System.out.println(runTest("^dog", "are dogs friendly"));   // 0        text doesn't start with dogs
        //To match only when the required regex is true at the end of the text, we use the dollar character $.
        // A match will be found in the following case:
        System.out.println(runTest("dog$", "Man's best friend is a dog"));   // 1    text ends with dogs
        System.out.println(runTest("dog$", "is a dog man's best friend?"));   // 0    text doesn't end with dogs
        // If we want a match only when the required text is found at a word boundary, we use \\b regex at the beginning and end of the regex:
        //Space is a word boundary:
        System.out.println(runTest("\\bdog\\b", "dog is man's best friend"));   // 1    text contains the word: dog
        System.out.println(runTest("\\bdog\\b", "snoop dogg is a rapper"));   // 0    text doesn't contain the word: dog
        // changing the end of the regex to look for a non-word boundary:
        System.out.println(runTest("\\bdog\\B", "snoop dogg is a rapper"));   // 1    text contains this string: dog
        // enable matching regardless of case   Pattern.CASE_INSENSITIVE
        System.out.println(runTest("(?i)dog", "This is a Dog"));   // 1    text contains this string: dog
    }

    static void decimalOrFloatNumber(){
        //regular expression for validating decimal/float numbers
        System.out.println(runTest( "^[+-]?\\d+(\\.\\d+)?$", "+1.02")); // 1
        System.out.println(runTest( "^[+-]?\\d+(\\.\\d+)?$", "+1.")); // 0
        System.out.println(runTest( "^[+-]?\\d+(\\.\\d+)?$", "1.")); // 0
        System.out.println(runTest( "^([+-]?[0-9]+([.][0-9]+)?)$", "1.")); // 0
        System.out.println(runTest( "^([+-]?[0-9]+([.][0-9]+)?)$", "-1.0")); // 1
        System.out.println(runTest( "\\A([+-]?[0-9]+([.][0-9]+)?)\\z", "-1.0")); // 1

        System.out.println(runTest("^([0-9]*[1-9][0-9]*(\\.[0-9]+)?|[0]*\\.[0-9]*[1-9][0-9]*)$", "1.2"));

        // https://stackoverflow.com/questions/10256061/regular-expression-for-finding-decimal-float-numbers :
        // a decimal with no leading zero (.14 instead of 0.14) or without a trailing fractional part (3. instead of 3.0) :
        System.out.println(runTest( "^((\\+|-)?(0|([1-9][0-9]*))(\\.[0-9]+)?)$", "-1.0")); // 1

        //https://www.regular-expressions.info/floatingpoint.html
    }


    static void formattedOrLimitedNumbers(){
        // start & end with (), no spaces, should be two numbers seperated by , each one can be a decimal or float number:
        System.out.println(runTest("([+-]?[0-9]+([.][0-9]+)?)", "(+1,5.0)"));   // 1
        // limited to between -90 and +90 both inclusive

        // decimal/float numbers with up to four decimal places and a range of 0 to 59 for the integer part:
//        ([0-9]|[0-5][0-9])\.[0-9]{1,4}


        // decimals with or without leading zeros
        System.out.println(runTest("^-?0*((90(\\.0*)?)|([1-8]?\\d(\\.\\d*)?))$", "90.0"));


        // https://stackoverflow.com/questions/22130429/using-regular-expressions-to-validate-a-numeric-range
    }

    static void emailCheck() {
        //   \b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}\b

        //    System.out.println("email check: " + email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$"));

        String email = "example@gmail.com";

        // Simplest regex to validate email
        System.out.println("email check: " + email.matches("^(.+)@(.+)$"));

        //  Java email validation permitted by RFC 5322
        System.out.println("email check: " + email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@(?!-)[a-zA-Z0-9.-]+$"));

        // https://howtodoinjava.com/java/regex/java-regex-validate-email-address/

        List<String> emails = new ArrayList<>();
        emails.add("user@domain.com");
        emails.add("user@domain.co.in");
        emails.add("user.name@domain.com");
        emails.add("user'name@domain.co.in");

//Invalid emails
        emails.add(".username@yahoo.com");
        emails.add("username@yahoo.com.");
        emails.add("username@yahoo..com");

        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

        Pattern pattern = Pattern.compile(regex);

        for (String email1 : emails) {
            Matcher matcher = pattern.matcher(email1);
            System.out.println(email1 + " : " + matcher.matches());
        }

    }

    static void passwordValidation() {
        String password = "aBaqau115_2";
        System.out.println(password);

        String PASSWORD_SPECIAL_CHARS = "@#$%^`<>&+=\"!ºª·#~%&'¿¡€,:;*/+-.=_{}\\[\\]\\(\\)\\|\\_\\?\\\\";
        int PASSWORD_MIN_SIZE = 8;
        String PASSWORD_REGEXP = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[" + PASSWORD_SPECIAL_CHARS + "])(?=\\S+$).{" + PASSWORD_MIN_SIZE + ",}$";

        String PATTERN = "\\A(?=\\S*?[0-9])(?=\\S*?[a-z])(?=\\S*?[A-Z])(?=\\S*?[@#$%^&+=*/\\-!?_<>\\[\\]()|\\\\.,:;'ºª·~¿¡€])\\S{8,}\\z";
        /*

    (?=\\S*[0-9]) a digit must occur at least once without space
    (?=\\S*[a-z]) a lower case letter must occur at least once without space
    (?=\\S*[A-Z]) an upper case letter must occur at least once without space
    (?=\\S*[@#$%^&+=]) a special character must occur at least once without space
    \\S*{8,} at least 8 characters. if you want to add max number of characters limit, for example 20 change it as \\S*{8,20}
        */

        System.out.println(password.matches(PASSWORD_REGEXP));
        System.out.println(password.matches(PATTERN));
        System.out.println(validatePasswordWithRegex(password));

    }

    // https://stackoverflow.com/questions/3802192/regexp-java-for-password-validation
    static boolean validatePasswordWithRegex(String pwd) {
        if (pwd == null || pwd.length() < 6) return false;
        if (!pwd.matches("(\\S*[0-9].*)")) return false;    //a digit must occur at least once without space
        if (!pwd.matches("(\\S*[a-z].*)")) return false;    //a lower case letter must occur at least once without space
        if (!pwd.matches("(\\S*[A-Z].*)"))
            return false;    //an upper case letter must occur at least once without space
        return pwd.matches("(\\S*[@#$%^&+=*/\\-!?_<>\\[\\]()|\\\\.,:;'ºª·~¿¡€].*)");    // checking special characters
    }


//    /**
//     * Ensure that we have at least three out of four password criteria met.
//     * This would far more complicated to achieve using standard regular expressions.
//     */
//    public boolean passwordValidates(String pass) {
//        int count = 0;
//
//        if (8 <= pass.length() && pass.length() <= 32) {
//            if (pass.matches(".*\\d.*"))
//                count++;
//            if (pass.matches(".*[a-z].*"))
//                count++;
//            if (pass.matches(".*[A-Z].*"))
//                count++;
//            if (pass.matches(".*[*.!@#$%^&(){}[]:\";'<>,.?/~`_+-=|\\].*"))
//                count++;
//        }
//
//        return count >= 3;
//    }

}
