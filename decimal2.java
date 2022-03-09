import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class decimal2 {  // 에라토스테네스의 체
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		boolean[] prime = new boolean[n2 + 1];

		prime[0] = true;
		prime[1] = true;


		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) {
				continue;
			}
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

		for(int i = n1; i <= n2; i++) {
			if(!prime[i]) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}