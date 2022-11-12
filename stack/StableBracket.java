package stack;

import java.io.*;
import java.util.Stack;

public class StableBracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        int order = 1;

        while (true) {
            int result = 0;
            String input = br.readLine();

            if (input.contains("-")) {
                break;
            }

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case '{':
                        stack.add(c);
                        break;

                    case '}':
                        if (stack.isEmpty()) {
                            result += 1;
                            stack.add('{');
                        } else if (stack.peek() == '{') {
                            stack.pop();
                        }
                        break;
                }
            }

            char oldBracket = ' ';
            while (!stack.isEmpty()) {
                char c = stack.pop();
                switch (c) {
                    case '{':
                        if (oldBracket == '{') {
                            result += 1;
                            oldBracket = ' ';
                        } else {
                            oldBracket = '{';
                        }
                        break;
                }
            }

            bw.write(Integer.toString(order) + ". " + Integer.toString(result) + "\n");
            order++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}