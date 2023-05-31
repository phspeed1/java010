import java.util.*;

public class Combination030{

    public static void main(String[] args){
        String str = "ABC";
        int N = 2;
        System.out.println("input : "+str);
    
        new Combination030().solution(str, N);
        System.out.println("output : "+str);
    }
    
    private void solution(String str, int N){
        List<String> resList = new ArrayList<String>();
        StringBuilder buff = new StringBuilder();
        combination(str, N, buff, 0, resList);
        System.out.println("조합 resList("+resList.size()+") : "+resList);
        
    }

    void combination(String str, int N, StringBuilder buff, int lev, List<String> resList){
        if(buff.length() == N){
            if(buff.length() > 0) resList.add(buff.toString());
            return;
        }

        for(int i=lev; i<str.length(); i++){
            char c = str.charAt(i);
            
            buff.append(c);
            combination(str, N, buff, i+1, resList); // 중복조합은 lev 이 i+1 이 아닌 i
            buff.deleteCharAt(buff.length()-1);

        }

    }

}