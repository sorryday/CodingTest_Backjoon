import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class dish {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<Character>(); 
        String input = br.readLine();
        int result = 0;

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(stack.isEmpty()) {
                stack.push(c);
                result += 10;
                continue;
            }

            if(c == '(') {
                if(stack.peek() == '(') {
                    stack.push(c);
                    result += 5;
                }

                else {
                    stack.push(c);
                    result += 10;
                }
            }

            else if(c == ')') {
                if(stack.peek() == '(') {
                    stack.push(c);
                    result += 10;
                }

                else {
                    stack.push(c);
                    result += 5;
                }
            }
        }

        System.out.println(result);
    }
}