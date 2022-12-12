package week_34;



import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOFWordsWithRegex {

    public static void main(String[] args) {
        String given = "This is an example paragraph in which words appear multiple times.          However, it is important that we consider all possibilities in our count of words.  Please feel free to ask questions based on the requirements as this is an interactive interview!";
        String given2 = "This is an example of example";
        String given3 = "This” is an example!    of example…";
        System.out.println(getFreqOFWords(given));
        System.out.println(getFreqOFWords(given3));
        System.out.println(getFreqOFWords2(given3));
    }

    public static Map<String, Integer> getFreqOFWords(String str) {
        str = str.toLowerCase(Locale.ROOT);
        str = str.replaceAll("\\p{P}", "");// replace all punctuations
       

        Map<String, Integer> mapOfWords = new HashMap<>();

        for (String s : str.split("\\W+")) {
            s = s.trim();
            if (mapOfWords.containsKey(s)) {
                mapOfWords.put(s, mapOfWords.get(s) + 1);
            } else {
                mapOfWords.put(s, 1);
            }
        }
        return mapOfWords;
    }

    public static Map<String, Long> getFreqOFWords2(String str) {
         return Arrays
                .stream(str.toLowerCase(Locale.ROOT).trim()
                        .split("\\W+"))
                .collect(Collectors
                        .groupingBy(String::valueOf, Collectors.counting()));


    }
    @Test
    public void testGetFreqOFWords() {

        String given = "This is an example paragraph in which words appear multiple times.  However, it is important that we consider all possibilities in our count of words.  Please feel free to ask questions based on the requirements as this is an interactive interview!";

        int isCount = getFreqOFWords(given).get("is");
        Assert.assertEquals("", 3, isCount);
    }
    @Test

    public void test2() {

        String given = "This is an example paragraph in which words appear multiple times.  However, it is important that we consider all possibilities in our count of words.  Please feel free to ask questions based on the requirements as this is an interactive interview!";

//        System.out.println("Task2.getFreqOFWords2(given) = " +

        getFreqOFWords2(given).entrySet().stream().forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
        long isCount = getFreqOFWords2(given).get("is");
        Assert.assertEquals("", 3, isCount);
    }

}


/*
 * Using the sentence below create an application to count the number of times each word appears in the sentence.
 *   The application should output the number of times each word occurs.

"This is an example paragraph in which words appear multiple times.
*   However, it is important that we consider all possibilities in our count of words.
*   Please feel free to ask questions based on the requirements as this is an interactive interview!"
 */