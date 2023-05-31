import java.util.*;

public class Combination020{

    public static void main(String[] args){
        String str = "ABCD";
        int N = 3;
        System.out.println("input : "+str);
    
        new Combination020().solution(str, N);
        System.out.println("output : "+str);
    }
    
    void solution(String str, int N){
        StringBuilder buff = new StringBuilder();
        List<String> resList = new ArrayList<String>();
        combination(str, N, buff, 0, 0, resList);
        System.out.println("resList("+resList.size()+") : "+resList);
    }

    void combination(String str, int N, StringBuilder buff, int lev, int bw, List<String> resList){
        if(lev == N){
            resList.add(buff.toString());
            return;
        }

        for(int i=bw; i<str.length(); i++){
            char c = str.charAt(i);
            buff.append(c);
            combination(str, N, buff, lev+1, i+1, resList);
            buff.deleteCharAt(buff.length()-1);
        }

    }

}