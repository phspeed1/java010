import java.util.*;

public class Permutation020{

    public static void main(String[] args){
        String str = "ABC";
        int N = 2;
        System.out.println("input : "+str);
    
        new Permutation020().solution(str, N);
    //    System.out.println("output : "+str);
    }
    
    void solution(String str, int N){
        String buff = new String();
        int lev = 0;
        List<String> list = new ArrayList<String>();
        HashSet<Character> hash = new HashSet<Character>();
        permutation(str, N, buff, lev, list, hash);
        System.out.println(list);
    }

    void permutation(String str, int N, String buff, int lev, List<String>list, HashSet<Character> hash){
        if(buff.length() == N){
            list.add(buff.toString());
            return;
        }

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(hash.contains(c)) continue;

            buff += c;
            hash.add(c);
            
            permutation(str, N, buff, lev+1, list, hash);
            
            buff = buff.substring(0, buff.length()-1);
            hash.remove(c);

        }
    }

}