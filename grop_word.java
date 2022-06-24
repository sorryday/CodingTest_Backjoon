import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class grop_word {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            boolean flag = true;

            char first = input.charAt(0);
            stack.push(first);

            for (int j = 1; j < input.length(); j++) {
                if ((input.charAt(j) != input.charAt(j - 1)) && (stack.contains(input.charAt(j)))) {
                    flag = false;
                    break;
                }
                else {
                    stack.push(input.charAt(j));
                }
            }
            if(flag) result += 1;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}