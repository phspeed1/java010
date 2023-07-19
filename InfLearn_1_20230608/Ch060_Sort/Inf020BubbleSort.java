import java.util.*;
import java.io.*;

public class Inf020BubbleSort{

    public static void main(String[] args){
        int N = 9;
        String str = "3 7 1 5 4 2 9 8 6";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf020BubbleSort().solution(str, N);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        // 초기화 완료
        ///////////////////////////////////
        
        for(int i=N-1; i>0; i--){
            for(int j=N-1; j>N-1-i; j--){
                if(arr[j-1] > arr[j])
                    swap(arr, j-1, j);
            }
        }

        for(int i:arr) buff.append(" "+i);
        
        return buff.toString().trim();
    }
    void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

}