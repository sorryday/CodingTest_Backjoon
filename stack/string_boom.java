package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class string_boom {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String boom = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if(stack.size() >= boom.length()) {
                boolean flag = false;

                for (int j = 0; j < boom.length(); j++) {
                    if (stack.get(stack.size() - boom.length() + j) != boom.charAt(j)) {
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        if(sb.toString().equals("")) {
            bw.write("FRULA");
        }
        else {
            bw.write(sb.reverse().toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}