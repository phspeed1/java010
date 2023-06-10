import java.util.*;
import java.io.*;

public class Inf091MusicVideo{

    public static void main(String[] args){
        int N = 9;
        int M = 3;
        String str = "1 2 3 4 5 6 7 8 9";

        // N=5; M=4;
        // str = "1 1 1 1 1";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str.split(" ")[0]);
        //     M = Integer.parseInt(str.split(" ")[1]);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf091MusicVideo().solution(str, N, M);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N, int M){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();

        int lt=max;
        int rt=sum;

        int answer = 0;

        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(needDvdCnt(arr, mid) <= M){
                answer = mid;
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }

        buff.append(answer);
        return buff.toString();
    }

    private int needDvdCnt(int[] arr, int capacity){
        int cnt = 1;
        int sum = 0;
        for(int x : arr){
            if(sum + x > capacity){
                cnt++;
                sum = x;
            }else{
                sum += x;
            }
        }
        return cnt;
    }

}