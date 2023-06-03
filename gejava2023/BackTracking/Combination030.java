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
        combination(str, N, new StringBuilder(), 0, resList);

        System.out.println("조합 resList("+resList.size()+") : "+resList);
        
    }

    void combination(String str, int N, StringBuilder buff, int lev, List<String> resList){


        if(buff.length() == N){
            if(!buff.isEmpty())
                resList.add(new String(buff));
            return;
        }

        for(int i=lev; i<str.length(); i++){
            String c = str.substring(i, i+1);
            buff.append(c);
            combination(str, N, buff, i+1, resList);
            buff.deleteCharAt(buff.length()-1);
        }

    }



}