import java.util.*;

public class Permutation010{

    public static void main(String[] args){
        char[] arr = {'A', 'B', 'C'};
        String str = "str";
        System.out.println("input : "+str);
    
        new Permutation010().solution(arr);
        System.out.println("output : "+str);
    }
    
    void solution(char[] arr){
        ArrayList<Character> list = new ArrayList<Character>();
        List<List<Character>> result = new ArrayList<>();
        permutation(arr, 0, list, result);
        System.out.println("result : "+result);
        
    }

    void permutation(char[] arr, int lev, ArrayList<Character> list, List<List<Character>> result){
        if(lev == arr.length){
            result.add((List<Character>)list.clone());
            return;
        }

        for(char c : arr){
            if(list.contains(c)) continue;
            list.add(c);
            permutation(arr, lev+1, list, result);
            list.remove(list.size()-1);
        }
    }

}