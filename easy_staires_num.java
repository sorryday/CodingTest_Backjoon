import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class easy_staires_num {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        long[][] dp = new long[cnt + 1][10];

		for(int i = 1; i < 10; i++) {  // 첫 번째 자리수 
			dp[1][i] = 1; 
		}

        // 두 번째 자릿수부터 N까지 탐색 
		for(int i = 2; i <= cnt; i++) {

			// i번째 자릿수의 자릿값들을 탐색 (0~9) 
			for(int j = 0; j < 10; j++) {
				
				// j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능 
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % 1000000000;
				}
				// j=9라면 이전 자릿수는 8만 가능
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % 1000000000;
				}
				// 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}

        long result = 0;

		for(int i = 0; i < 10; i++) {
			result += dp[cnt][i];
		}
		
		System.out.println(result % 1000000000);
    }
}
