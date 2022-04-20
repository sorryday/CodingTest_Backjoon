package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Wine {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1]; // 포도주 n개가 주어졌을때 가장 많이 마실 수 있는 양
        int[] num = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = num[1];
        if(n > 1) {
            dp[2] = num[1] + num[2];
        }

        for (int i = 3; i <= n; i++) { // 연속해서 안 마시는 경우, 1번 연속하는 경우, 2번 연속하는 경우 , 3개 중에서 최대 값이 답.
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + num[i], dp[i - 3] + num[i - 1] + num[i]));
        }

        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
