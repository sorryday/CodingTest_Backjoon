import java.io.*;
import java.util.*;

public class num_array_hap4 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N]; // 1부터 자기 자신 인덱스까지의 합을 저장한 배열
		dp[0] = num[0];
		for(int i = 1; i < N; i++) {
			dp[i] = dp[i - 1] + num[i];
		}

		for(int i = 0; i < M; i++) {
			long result = 0;
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			result = dp[end - 1] - dp[start - 1] + num[start - 1];
			bw.write(Long.toString(result) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}