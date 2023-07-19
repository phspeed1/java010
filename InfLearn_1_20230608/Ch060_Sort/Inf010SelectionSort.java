import java.util.*;
import java.io.*;

public class Inf010SelectionSort{

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
    
        String rtn = new Inf010SelectionSort().solution(str, N);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        // 초기화 완료
        ///////////////////////////////////
        
        for(int i=0; i<N; i++){
            int min=i;
            for(int j=i+1; j<N; j++){
                if(arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
            System.out.println(Arrays.toString(arr));
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