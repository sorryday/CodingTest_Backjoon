package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GoDown {

    static class MaxMinObject {
        int max;
        int min;

        public MaxMinObject(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        MaxMinObject[][] dp = new MaxMinObject[N][3];
        dp[0][0] = new MaxMinObject(map[0][0], map[0][0]);
        dp[0][1] = new MaxMinObject(map[0][1], map[0][1]);
        dp[0][2] = new MaxMinObject(map[0][2], map[0][2]);

        for (int i = 1; i < N; i++) {
            dp[i][0] = new MaxMinObject(map[i][0] + Math.max(dp[i - 1][0].max, dp[i - 1][1].max),
                    map[i][0] + Math.min(dp[i - 1][0].min, dp[i - 1][1].min));
            dp[i][1] = new MaxMinObject(map[i][1] + Math.max(Math.max(dp[i - 1][0].max, dp[i - 1][1].max), dp[i - 1][2].max),
                    map[i][1] + Math.min(Math.min(dp[i - 1][0].min, dp[i - 1][1].min), dp[i - 1][2].min));
            dp[i][2] = new MaxMinObject(map[i][2] + Math.max(dp[i - 1][1].max, dp[i - 1][2].max),
                    map[i][2] + Math.min(dp[i - 1][1].min, dp[i - 1][2].min));
        }

        bw.write(Math.max(dp[N - 1][0].max, Math.max(dp[N - 1][1].max, dp[N - 1][2].max)) + " " + Math.min(dp[N - 1][0].min, Math.min(dp[N - 1][1].min, dp[N - 1][2].min)));
        bw.flush();
        bw.close();
        br.close();
    }
}
