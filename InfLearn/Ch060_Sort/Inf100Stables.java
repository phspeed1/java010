import java.util.*;
import java.io.*;

public class Inf100Stables{

    public static void main(String[] args){
        int N = 5;
        int C = 3;
        String str = "1 2 8 4 9";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str.split(" ")[0]);
            C = Integer.parseInt(str.split(" ")[1]);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf100Stables().solution(str, N, C);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N, int C){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);
        int answer = 0;

        //////////////////////////
        // 최소거리의 최대값을 찾는 것은 어려우니까,
        // 이분탐색으로 가능한 최소거리가 되는지 판단해서, 최대값으로 말을 넣었을 때 들어가는지로 판단하자.
        // 그런데 만약 마구간들의 거리가 있는 배열을 이용한다면 좋지 않을까.
        //////////////////////////
        Arrays.sort(arr);
        int[] distance = new int[N-1];
        for(int i=0; i<N-1; i++){
            distance[i] = arr[i+1] - arr[i];
        }
        int max = arr[N-1] - arr[0];
        int min = Arrays.stream(distance).min().getAsInt();
        int lt = min;
        int rt = max;

        while(lt <= rt){
            int mid = (lt+rt)/2;

            if(cntHorse(arr, N, mid) >= C){
                lt = mid +1;
                answer = mid;
            }else{
                rt = mid -1;
            }

        }

        buff.append(answer);
        return buff.toString();

    }

    int cntHorse(int[] arr, int N, int minDistance){
        int horseCnt = 1;
        int cp = 0;
        for(int i=1; i<N; i++){
            if(arr[i] - arr[cp] >= minDistance){
                horseCnt++;
                cp=i;
            }
        }
        return horseCnt;
    }


}