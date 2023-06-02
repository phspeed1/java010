import java.util.*;

public class Permutation010{

    public static void main(String[] args){
        String str = "ABC";
        int N = 2;
        System.out.println("input : "+str+" N : "+N);
    
        new Permutation010().solution(str, N);
    }
    
    void solution(String arr, int N){
        List<String> result = new ArrayList<String>();
        String buff = new String();
        permutation(arr, N, buff, 0, result);
        System.out.println("result("+result.size()+") : "+result);
    }

    void permutation(String arr, int N, String buff, int lev, List<String> result){
        if(lev == N){
            result.add(new String(buff));
            return;
        }

        for(int i=0; i<arr.length(); i++){
            String str = arr.substring(i, i+1);
       //     if(buff.contains(str)) continue;

            buff += str;
            permutation(arr, N, buff, lev+1, result);
            buff = buff.substring(0, buff.length() -1);
        }

    }



}