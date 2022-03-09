import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class goldbach2 {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(br.readLine());
		int result = 0;

		for(int i = 0; i < cnt; i++) {
			int input = Integer.parseInt(br.readLine());
			result = decimal(input);
			System.out.println(result);
		}

		br.close();
	}

	public static int decimal(int input) {
		boolean[] prime = new boolean[input + 1];

		prime[0] = true;
		prime[1] = true;
		int re_cnt = 0;

		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) {
				continue;
			}
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

		for(int i = 1; i <= input /2; i++) {
            int a = i;
            int b = input - i;

            if(a == 1) {
				continue;
			}

			if(prime[a] == false && prime[b] == false) {
				re_cnt += 1;
			}
        }

		return re_cnt;
	}
}