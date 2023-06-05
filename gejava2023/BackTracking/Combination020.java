import java.util.*;

public class Combination020{

    public static void main(String[] args){
        String str = "ABC";
        int N = 2;
        System.out.println("input : "+str);
    
        new Combination020().solution(str, N);
    //    System.out.println("output : "+str);
    }

    void solution(String str, int N){

        List<String> list = new ArrayList<String>();
        String buff = new String();
        combination(str, N, buff, 0, list);
        System.out.println(list);
    }

    void combination(String str, int N, String buff, int lev, List<String> list){
        if(buff.length() == N){
            list.add(buff.toString());
            return;
        }

        for(int i=lev; i<str.length(); i++){
            buff += str.charAt(i);
            combination(str, N, buff, i+1, list);
            buff = buff.substring(0, buff.length()-1);
        }

    }
    

}