import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Good_lang {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<Character>();
        int cnt = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 0; i < cnt; i++) {
            String input = br.readLine();
            for(int k = 0; k < input.length(); k++) {
                if(stack.isEmpty()) {
                    stack.push(input.charAt(k));
                }

                else if(input.charAt(k) == 'A') {
                    if(stack.peek() == 'A') {
                        stack.pop();
                    }
            
                    else{
                        stack.push(input.charAt(k));
                    }
                }

                else {
                    if(stack.peek() == 'B') {
                        stack.pop();
                    }
            
                    else{
                        stack.push(input.charAt(k));
                    }
                }
            }

            if(stack.isEmpty()) {
               result += 1;
            }

            stack.clear();
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}