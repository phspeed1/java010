import java.util.*;

public class Permutation030{

    public static void main(String[] args){
        String str = "ABC";
        int N = 2;
        System.out.println("input : "+str);
    
        new Permutation030().solution(str, N);
        System.out.println("output : "+str);
    }
    
    void solution(String str, int N){
        List<String> resList = new ArrayList<String>();
        StringBuilder buff = new StringBuilder();
        permutation(str, N, buff, 0, resList);
        System.out.println("순열 resList("+resList.size()+") : "+resList);
        
    }

    void permutation(String str, int N, StringBuilder buff, int lev, List<String> resList){
        if(lev == N){
            if(buff.length() >0) resList.add(buff.toString());
            return;
        }

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            
            if(buff.indexOf( Character.toString(c) ) != -1) continue; // 중복순열은 이부분만 제거

            buff.append(c);
            permutation(str, N, buff, lev+1, resList);
            buff.deleteCharAt(buff.length()-1);

        }

    }

}