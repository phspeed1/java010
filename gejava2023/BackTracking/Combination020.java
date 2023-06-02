import java.util.*;

public class Combination020{

    public static void main(String[] args){
        String str = "ABC";
        int N = 2;
        System.out.println("input : "+str);
    
        new Combination020().solution(str, N);
        System.out.println("output : "+str);
        System.out.println("-75 >> 1 : "+(-75 >> 2));
    }
    
    void solution(String str, int N){
        String buff = new String();
        List<String> resList = new ArrayList<String>();
        combination(str, N, buff, 0, resList, new boolean[str.length()]);
        System.out.println("resList("+resList.size()+") : "+resList);

    }

    void combination(String arr, int N, String buff, int lev, List<String> result, boolean[] seen){
        if(buff.length() == N){
            result.add(new String(buff));
            return;
        }

        for(int i=lev; i<arr.length(); i++){
        //    if(seen[i]) continue;

            String c = arr.substring(i, i+1);
            seen[i] = true;
            buff += c;
            combination(arr, N, buff, i, result, seen);
            seen[i] = false;
            buff = buff.substring(0, buff.length() -1);
        }
    }

}