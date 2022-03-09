import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class two_X_N_Tiling {
	static int[] dp;
    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		dp = new int[cnt + 1];

		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i <= cnt; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];   // 점화식 (피보나치)
			dp[i] %= 10007;
		}
		System.out.println(dp[cnt]);
    }
}
