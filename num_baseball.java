import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class num_baseball {
	static int values[], strikes[], balls[];
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		values = new int[n];
		strikes = new int[n];
		balls = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());

			values[i] = value;
			strikes[i] = strike;
			balls[i] = ball;
		}

		int ans = 0;

		for (int i = 123; i <= 987; i++) {
			if (strikeAndBall(i)) {
				ans++;
			}
		}

		bw.write(Integer.toString(ans));
        bw.flush();
        bw.close(); 
        br.close();
	}

	static boolean strikeAndBall(int i) {
		int hi = i / 100;
		int ti = (i % 100) / 10;
		int oi = (i % 100) % 10;

		if(hi == 0 || ti == 0 || oi == 0) return false;
		if(hi == ti || hi == oi || ti == oi) return false;
		for (int idx = 0; idx < n; idx++) {
			int v = values[idx];
			int strike = 0, ball = 0;
			int hv = v / 100;
			int tv = (v % 100) / 10;
			int ov = (v % 100) % 10;

			if (hi == hv)
				strike++;
			if (ti == tv)
				strike++;
			if (oi == ov)
				strike++;
			if (hi == tv || hi == ov)
				ball++;
			if (ti == hv || ti == ov)
				ball++;
			if (oi == hv || oi == tv)
				ball++;

			if (strike != strikes[idx] || ball != balls[idx])
				return false;

		}
		return true;
	}
}