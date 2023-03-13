package Intw_DSA_Qs;

public class Q2_RemoveWholeSquares {

    public static String deleteWholeSqrt(String inputData){
        int count =0;
        int last = 0;
        String [] arr = inputData.split("\r?\n|\r");
        inputData = "";

        for(String each: arr){
            int current = Integer.parseInt(each);
            double sqrt = Math.sqrt(current);
            if(sqrt == Math.floor(sqrt)){
                last = current;
            }else{
                count++;
            }
        }
        inputData= last==0 ? ""+count:count+"\n"+last;
        return inputData;
    }
}

