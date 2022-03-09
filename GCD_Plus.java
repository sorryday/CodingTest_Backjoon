import java.util.Scanner;
import java.io.IOException;

public class GCD_Plus {  
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();

		for(int i = 0; i < cnt; i++) {
			int input = sc.nextInt();
			int[] num_A = new int[input];

			for(int j = 0; j < num_A.length; j++) {
				num_A[j] = sc.nextInt();
			}

			long result = 0;

			for(int j = 0; j < input - 1; j++) {
				for(int k = j + 1; k < input; k++) {
					result += gcd(num_A[j], num_A[k]);
				}
			}

			System.out.println(result);
		}
	}

	public static long gcd(int n1, int n2) {
		if(n2 == 0) {
			return n1;
		}

		else {
			return gcd(n2, n1 % n2);
		}
	}
}