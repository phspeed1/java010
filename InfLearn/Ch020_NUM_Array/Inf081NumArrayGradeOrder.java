import java.util.*;
import java.io.*;

public class Inf081NumArrayGradeOrder{

    public static void main(String[] args){
        int N = 5;
        String str = "100 76 87 89 92 100 76";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf081NumArrayGradeOrder().solution(N, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        List<Student> list = new ArrayList<Student>();
        for(int i=0; i<strArr.length; i++){
            int score = Integer.parseInt(strArr[i]);
            list.add(new Student(i, score));
        }
    //    System.out.println("list : "+list);
        Collections.sort(list);
    //    System.out.println("list : "+list);

        int prevScore = -10001;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).score != prevScore){
                for(int j=0; j<list.size(); j++){
                    list.get(j).setGrade(list.get(i).score, i+1);
                }
            }
            prevScore = list.get(i).score;
        }
    //    System.out.println("list : "+list);

        int[] gradeArr = new int[list.size()];
        for(Student stu : list){
            gradeArr[stu.no] = stu.grade;
        }
        for(int grade : gradeArr){
            buff.append(" "+grade);
        }
        
        return buff.toString().trim();
    }

    class Student implements Comparable<Student>{
        int no;
        int score;
        int grade;
        Student(int no, int score){
            this.no = no;
            this.score = score;
        }
        void setGrade(int score, int grade){
            if(this.score == score)
                this.grade = grade;
        }
        public int compareTo(Student o){
            if(this.score > o.score)
                return -1;
            else
                return 1;
        }
        public String toString(){
            return "{No:"+this.no+",Score:"+this.score+",Grade:"+this.grade+"}";
        }
    }

}