package Intw_DSA_Qs;

public class Q9_Reshape {

    /*static String reshape(int n, String str)

input example : 3 for 'n' and "abc de fghij" for str
and output should be:
abc
def
ghi
j
like
"abc\ndef\nghi\nj"
    */
    static String reshape(int n, String str) {
        StringBuilder sb = new StringBuilder();
        str=str.replace(" ","");
        for (int i = 0; i < str.length(); i++) {
            String add = "";
            if ((i+1)%n == 0) add = "\n";
            sb.append(str.charAt(i)).append(add);
        }
        return sb.toString();
    }



    static String reshape1(int n, String str) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (char ch : str.toCharArray()) {
            if (ch == ' ') continue;
            sb.append(ch).append(i++ % n == 0 ? "\n" : "");
        }
        return sb.toString();
    }
}
