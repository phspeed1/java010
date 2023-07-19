import java.util.*;
import java.io.*;

public class Inf082NumArrayGradeOrder{

    public static void main(String[] args){
        int N = 6;
        String str = "76 87 89 92 100 76 100";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf082NumArrayGradeOrder().solution(N, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        int[] answer = new int[strArr.length];
        for(int i=0; i<strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }

        for(int i=0; i<arr.length; i++){
            int grd=1;
            for(int j=0; j<arr.length;j++){
                if(arr[i] < arr[j])
                    grd++;
            }
            answer[i] = grd;
        }
        for(int grd : answer)
            buff.append(" "+grd);

        return buff.toString().trim();
    }

}