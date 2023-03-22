package dp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];	// 최소 횟수
        int[] path = new int[n + 1];	// 경로

        //초기화
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // 3으로 나누어 떨어질 때
            if (i % 3 == 0) {
                // 현재 횟수 vs 3 나눴을 때 횟수 + 1
                if(dp[i / 3] + 1 < dp[i]) {
                    dp[i] = dp[i / 3] + 1;
                    path[i] = i /3;
                }
            }
            // 2로 나누어 떨어질 때
            if (i % 2 == 0) {
                // 현재 횟수 vs 2 나눴을 때 횟수 + 1
                if(dp[i / 2] + 1 < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                    path[i] = i / 2;
                }
            }
            // 1을 뺄 때
            if (dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                path[i] = i - 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        // 최소 횟수 출력
        sb.append(dp[n] + "\n");

        // 경로 숫자 다 담기
        while (n > 0) {
            sb.append(n + " ");
            n = path[n];
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

