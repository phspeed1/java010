import java.util.*;
import java.io.*;

public class Inf060PrimNumString{

    public static void main(String[] args){
        int N = 0;
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf060PrimNumString().solution(N, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str){
        StringBuilder buff = new StringBuilder();

        // 문자를 뒤집어서 숫자로만들어서 배열에 넣고, 최대수 구하기
        String[] nums1 = str.split(" ");
        int[] nums = new int[nums1.length];
        int maxNum = 0;
        for(int i=0; i<nums1.length; i++){
// 방법 1. 내가 한 방법
//            int num = Integer.parseInt(new StringBuilder(nums1[i]).reverse().toString());

            // 방법2 캐릭터로
            // char[] ch = nums1[i].toCharArray();
            // int num = 0;
            // for(int j=ch.length-1; j>=0; j--){
            //     num = ((num * 10) + (ch[j] - '0'));
            // }

            // 방법 3 숫자만 가지고
            int tmp = Integer.parseInt(nums1[i]);
            int num = 0;
            while(tmp >0){
                num = num * 10 + tmp % 10;
                tmp = tmp / 10;
            }

            nums[i] = num;
            if(maxNum < num) maxNum = num;
        }

        // 검사해야 할 수 중 최대값만큼 배열 생성해서 소수인지 기록
        int[] primeArr = new int[maxNum+1];
        primeArr[0] = 2;
        primeArr[1] = 2;
        for(int i=2; i<primeArr.length; i++){
            if(primeArr[i] != 0) continue;

            primeArr[i] = 1;
            for(int j=i+i; j < primeArr.length; j +=i){
                primeArr[j] = 2;
            }
        }

        // 검사해서 소수이면 출력
        for(int i=0;i<nums.length; i++){
            if(primeArr[nums[i]] == 1)
                buff.append(" "+nums[i]);
        }

        return buff.toString().trim();
    }

}