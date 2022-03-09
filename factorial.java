import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class factorial {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int result = Factorial(input);

		if (result == 0) {
			result = 1;
		}

		System.out.print(result);
		br.close();
	}
	
	public static int Factorial(int input) {
		if(input <= 1) {
			return input;
		}
		else {
			return Factorial(input - 1) * input;
		}
	}
}