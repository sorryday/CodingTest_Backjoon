package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Ascent {
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        dp = new int[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= 9; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }

        bw.write(Integer.toString(sum % 10007));
        bw.flush();
        bw.close();
        br.close();
    }
}