package Intw_DSA_Qs;

public class Q6_AlterCase {

    /*Alter Case
    Programming challenge description:
    Write a program that, given an input sentence, alternates the case of every alphabetic character, starting with uppercase. Spaces and non-alphabetical characters should be added to the final output as is, i.e. they should not be taken into account when alternating between upper/lowercase.
            Input:
    Your program should read lines from standard input. Each line contains a sentence. Assume all characters are ASCII.
            Output:
    For each sentence from standard input, print to standard output the sentence such that the first character is uppercase, the next character is lowercase and so on.
            Test 1
    Test Input
    We are the world
    Expected Output
    We ArE tHe WoRlD

    Test 2
            this is some code
    Expected Output
    ThIs Is SoMe CoDe*/

    public static String camelCase(String line){

        String[] ar = line.split("");
        StringBuilder sb = new StringBuilder();
        int numAlphabetic = 0;
        for (String str : ar) {
            if (Character.isAlphabetic(str.charAt(0))) {
                if (numAlphabetic % 2 == 0) {
                    sb.append(str.toUpperCase());
                } else {
                    sb.append(str.toLowerCase());
                }
                numAlphabetic++;
            } else {
                sb.append(str);
            }
        }
        return sb.toString();

    }
}
