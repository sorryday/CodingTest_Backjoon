package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class zoo {
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long result;
        dp = new long[N + 1][3];

        // dp[n][0] = 사자를 안넣는 경우, ""[1] = 사자를 왼쪽에 넣는 경우  "" [2] = 사자를 오른쪽에 넣는 경우
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][0]) % 9901;
        }
        result = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}