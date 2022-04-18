package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class sticker {
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            dp = new int[2][n + 1];
            arr = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + arr[1][j];
            }

            bw.write(Integer.toString(Math.max(dp[0][n], dp[1][n])) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}