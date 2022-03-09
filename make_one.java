import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class make_one {
    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] dp = new int[num];		// 테이블 설정

		dp[0] = 0;		// 초기값 설정

		for(int i = 1; i < num; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}

			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		System.out.println(dp[num - 1]);
    }
}