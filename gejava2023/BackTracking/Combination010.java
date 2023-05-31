import java.util.*;

public class Combination010{

    public static void main(String[] args){
        char[] arr = {'A', 'B', 'C', 'D'};
        int mx = 3;
        System.out.println("input : "+arr);
    
        new Combination010().solution(arr, mx);
        System.out.println("output : "+arr);
    }
    
    void solution(char[] arr, int mx){
        char[] list = new char[mx];
        List<char[]> result = new ArrayList<char[]>();
        combination(arr, mx, 0, 0, list, result);

        for(int i=0; i<result.size(); i++)
            System.out.println("result : ("+i+")"+Arrays.toString(result.get(i)));
        
    }

    void combination(char[] arr, int mx, int lev, int beginWith, char[] list, List<char[]> result){
        if(lev == mx){
            result.add(Arrays.copyOf(list, list.length));
            return;
        }

        for(int i=beginWith; i<arr.length; i++){
            char c = arr[i];
     //       if(list.contains(c)) continue;
            list[lev] = c;
            combination(arr, mx, lev+1, i+1, list, result);
     //       list.remove(list.size()-1);
        }

    }

}