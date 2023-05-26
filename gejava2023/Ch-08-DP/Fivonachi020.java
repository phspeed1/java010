public class Fivonachi020 {
    public static void main(String args[]) {
        int in = 8;
        System.out.println("input : "+in);
        long out;
        for(int i=0; i<=in; i++){
            out = solution(i);
            System.out.print("["+i+":"+out+"]");
        }
    }

    static long solution(int n){
        long out = 0;
        long m1=0, m2=0, cu=0;
        
        for(int i=0; i <= n; i++){
            if(i<2){
                cu = i;
                continue;
            }
            m2 = m1;
            m1 = cu;
            cu = m1 + m2;
        }
        out = cu;

        return out;
    }
}
