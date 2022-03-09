import java.util.Scanner;
import java.util.Stack;

public class word_reverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<Character>();

		String input = sc.nextLine();
		boolean check = false;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '<') {
				print(st); 
				check = true;
				System.out.print(input.charAt(i));
			} 
         
         else if (input.charAt(i) == '>') {
				check = false;
				System.out.print(input.charAt(i));
			} 
         
         else if (check) {
				System.out.print(input.charAt(i));
			}

			else {
				if (input.charAt(i) == ' ') {
					print(st);
					System.out.print(input.charAt(i));
				}

				else {
					st.push(input.charAt(i));
				}
			}
		}

		print(st);
	}

   static void print(Stack st) {
		while (!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}
}