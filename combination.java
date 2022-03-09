import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.IOException;

public class combination {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		long n1 = Long.parseLong(st.nextToken());
		long n2 = Long.parseLong(st.nextToken());
		
		long cnt_five = Factorial_five(n1) - Factorial_five(n1 - n2) - Factorial_five(n2);
		long cnt_two = Factorial_two(n1) - Factorial_two(n1 - n2) - Factorial_two(n2);
		System.out.println(Math.min(cnt_five, cnt_two));

		br.close();
	}

	public static long Factorial_five(long n1) {
		long result = 0;

		while(n1 >= 5) {
			result += n1 / 5;
			n1 = n1 / 5;
		}

		return result;
	}

	public static long Factorial_two(long n1) {
		long result = 0;

		while(n1 >= 2) {
			result += n1 / 2;
			n1 = n1 / 2;
		}

		return result;
	}
}
