package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Num_Tri {
    static int[][] dp;
    static int[][] NumArr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        NumArr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                NumArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.arraycopy(NumArr[n - 1], 0, dp[n - 1], 0, n);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[i - 1][j] += Math.max(dp[i][j], dp[i][j + 1]) + NumArr[i - 1][j];
            }
        }

        bw.write(Integer.toString(dp[0][0]));
        bw.flush();
        bw.close();
        br.close();
    }
}