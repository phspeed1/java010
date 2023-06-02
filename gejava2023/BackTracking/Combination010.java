import java.util.*;

public class Combination010{

    public static void main(String[] args){
        String arr = "ABC";
        int N = 2;
        System.out.println("input : "+arr);
    
        new Combination010().solution(arr, N);
    }
    
    void solution(String arr, int N){
        List<String> result = new ArrayList<String>();
        String buff = new String();
        combination(arr, N, buff, 0, result);
        System.out.println("result("+result.size()+") : "+result);
        
    }

    void combination(String arr, int N, String buff, int lev, List<String> result){
        if(buff.length() == N){
            result.add(new String(buff));
            return;
        }

        for(int i=lev; i<arr.length(); i++){
            String str = arr.substring(i, i+1);
            buff += str;
            combination(arr, N, buff, i , result);
            buff = buff.substring(0, buff.length()-1);
        }

    }



}