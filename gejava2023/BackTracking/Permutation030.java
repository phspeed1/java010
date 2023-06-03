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
        StringBuilder buff = new StringBuilder();
        HashSet<String> set = new HashSet<String>();
        List<String> resList = new ArrayList<String>();

        permutation(str, N, buff, 0, set, resList);
        System.out.println("순열 resList("+resList.size()+") : "+resList);
        
    }

    void permutation(String str, int N, StringBuilder buff, int lev, HashSet<String> set, List<String> resList){
        if(lev == N){
            resList.add(new String(buff));
            return;
        }

        for(int i=0; i<str.length(); i++){
            String c = str.substring(i, i+1);

        //    if(set.contains(c)) continue;

            set.add(c);
            buff.append(c);
            permutation(str, N, buff, lev+1, set, resList);
            buff.deleteCharAt(buff.length()-1);
            set.remove(c);
        }
    }


}