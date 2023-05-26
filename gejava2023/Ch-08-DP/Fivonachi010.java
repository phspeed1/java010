public class Fivonachi010 {
    public static void main(String args[]) {
        int in = 7;
        System.out.println("input : "+in);
        int out;
        out = solution(in);
        System.out.println("output : "+out);
    }

    static int solution(int n){
        if(n == 0 )
            return 0;
        if(n == 1)
            return 1;
        System.out.println("return( solution("+(n-1)+") + solution("+(n-2)+") )");
        return(solution(n-1)+solution(n-2));
    }
}
