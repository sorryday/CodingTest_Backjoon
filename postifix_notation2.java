import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class postifix_notation2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String ms = br.readLine();
		Stack<Character> stack = new Stack<Character>();

		for(int i = 0; i < ms.length(); i++) {
			char c = ms.charAt(i);

			switch (c) {
				case '+':
				case '-':
				case '*':
				case '/':
				
					while (!stack.isEmpty() && operate(stack.peek()) >= operate(c)) {
						bw.write(stack.pop());
					}
					stack.push(c);
				break;

				case '(':
					stack.add(c);
				break;

                case ')':
						while(!stack.isEmpty() && stack.peek() != '('){
							bw.write(stack.pop());
						}
						stack.pop();
                    break;

				default:
					bw.write(c);
			}
		}
		while(!stack.isEmpty()) {
			bw.write(stack.pop());
		}
	
		bw.flush();
		bw.close();
		br.close();
	}

	static int operate(char c) {
		if (c == '*' || c == '/') {
			return 2;
		}

		else if (c == '+' || c == '-'){
			return 1;
		}

		else if (c == '(' || c == ')'){
			return 0;
		}
		return -1;
	}
}