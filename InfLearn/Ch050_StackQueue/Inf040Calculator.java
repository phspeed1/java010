import java.util.*;
import java.util.regex.Pattern;

public class Inf040Calculator{

    public static void main(String[] args){
        String str = "3 * ( 5 +2)-9";
        // 3 5 2 + * 9 -
        System.out.println("input : "+str);
    
        new Inf040Calculator().solution(str);
    }
    
    void solution(String str){
        Queue<String> postExpress = getPostExpressOperation(str);
        int answer = calculatePostExpress(postExpress);
        System.out.println("output : "+answer);
    }

    int calculatePostExpress(Queue<String> queue){
        Stack<Integer> stack = new Stack<Integer>();

        for(String s : queue){

            if(Pattern.matches("[0-9]+", s)){
                stack.push(Integer.parseInt(s));
            }else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(s.equals("+")) stack.push(lt+rt);
                if(s.equals("-")) stack.push(lt-rt);
                if(s.equals("*")) stack.push(lt*rt);
                if(s.equals("/")) stack.push(lt/rt);
            }
        }
        return stack.pop();
    }

    Queue<String> getPostExpressOperation(String str){

        StringTokenizer st = new StringTokenizer(str, "+-*/%()", true);
        Queue<String> queue = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();
        while(st.hasMoreTokens()){
            String token = st.nextToken().trim();
            // 시작괄호 '(' 는 push
            // 종료괄호 ')' 는 시작괄호가 나올때 까지 pop
            // 연산자는 stack 에서 연산자 우선순위 높거나 같은게 나올때 까지 pop 후 자신은 push
            // 나머지는 offer
            if(token.equals("")){
                // continue;
            }else if(token.equals("(")) {
                stack.push(token);
            }else if(token.equals(")")){
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    queue.offer(stack.pop());
                }
                stack.pop();
            }else if( ("+-*/%").indexOf(token) != -1){
                while(!stack.isEmpty() && operationPrioty(stack.peek()) >=  operationPrioty(token)){
                    queue.offer(stack.pop());
                }
                stack.push(token);
            }else{
                queue.offer(token);
            }
        }
        while(!stack.isEmpty()) queue.offer(stack.pop());

        System.out.println(queue);
        return queue;
        
    }

    int operationPrioty(String op){
        if(op.equals("+")||op.equals("-")) return 2;
        if(op.equals("(")) return 1;
        return 3;
    }

}