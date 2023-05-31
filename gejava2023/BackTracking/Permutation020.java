import java.util.*;

public class Permutation020{

    public static void main(String[] args){
        String str = "ABC";
        System.out.println("input : "+str);
    
        new Permutation020().solution(str);
        System.out.println("output : "+str);
    }
    
    void solution(String str){
        List<String> res = new ArrayList<String>();
        StringBuilder buff = new StringBuilder();
        permutation(str, 0, buff, res);
        System.out.println("res : "+res);
        
    }

    void permutation(String str, int lev, StringBuilder buff, List<String> res){
        if(lev == str.length()){
            res.add(buff.toString());
            return;
        }

        for(int i=0; i<str.length(); i++){
            String s = str.substring(i, i+1);
            if(buff.indexOf(s) == -1){
                buff.append(s);
                permutation(str, lev+1, buff, res);
                buff.deleteCharAt(buff.length() -1);
            }
        }

    }

}