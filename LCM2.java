import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class LCM2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());

		for(int i = 0; i < cnt; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			int t1 = 0;
			int t2 = 0;

			t1 = Integer.parseInt(st.nextToken());
			t2 = Integer.parseInt(st.nextToken());

			int gcd = gcd(t1, t2);
			bw.write(t1 * t2 / gcd + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static int gcd(int t1, int t2) {
		if(t2 == 0) {
			return t1;
		}
		else {
			return gcd(t2, t1 % t2);
		}
	}
}