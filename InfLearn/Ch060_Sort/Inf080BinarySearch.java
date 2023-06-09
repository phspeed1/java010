import java.util.*;
import java.io.*;

public class Inf080BinarySearch{

    public static void main(String[] args){
        int N = 8;
        int M = 32;
        String str = "23 87 65 12 57 32 99 81";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str.split(" ")[0]);
            M = Integer.parseInt(str.split(" ")[1]);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf080BinarySearch().solution(str, N, M);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N, int M){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);
        Arrays.sort(arr);
        int res = binarySearch(arr, M, 0, N-1);
        buff.append(res+1);
        return buff.toString();
    }

    int binarySearch(int[] arr, int M, int lt, int rt){
        if(lt > rt) return -1;
        int mid = (lt + rt) / 2;
        if(arr[mid] == M) return mid;
        else if(arr[mid] > M) return binarySearch(arr, M, lt, mid-1);
        else return binarySearch(arr, M, mid+1, rt);
    }

}