import java.util.*;
import java.io.*;

public class Inf020ArrayDupElements{

    public static void main(String[] args){
        int N = 5;
        int M = 5;
        String str1 = "1 3 9 5 2";
        String str2 = "3 2 5 7 8";
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str1 = br.readLine();
            str = br.readLine();
            M = Integer.parseInt(str);
            str2 = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf020ArrayDupElements().solution(N, str1, M, str2);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str1, int M, String str2){
        StringBuilder buff = new StringBuilder();
        String[] strArr1 = str1.split(" ");
        String[] strArr2 = str2.split(" ");
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(strArr1[i]);
        }
        for(int i=0; i<M; i++){
            arr2[i] = Integer.parseInt(strArr2[i]);
        }
        // 초기화 End
        ///////////////////////////////////
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<Integer>();
        int p1=0;
        int p2=0;
        while(p1<N && p2<M){
            if(arr1[p1] == arr2[p2]){
                list.add(arr1[p1]);
                p1++; p2++;
            }else if(arr1[p1] < arr2[p2]){
                p1++;
            }else{
                p2++;
            }
        }
        for(int i : list){
            buff.append(" "+i);
        }
        return buff.toString().trim();
    }

}