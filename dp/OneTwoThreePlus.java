package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class OneTwoThreePlus {

    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 1; i <= cnt; i++) {
            int temp = Integer.parseInt(br.readLine());
            switch (temp) {
                case 1:
                    bw.write(Integer.toString(1 % 1000000009) + "\n");
                    break;
                case 2:
                    bw.write(Integer.toString(2 % 1000000009) + "\n");
                    break;
                case 3:
                    bw.write(Integer.toString(4 % 1000000009) + "\n");
                    break;
                default:
                    for (int j = 4; j <= temp; j++) {
                        dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
                    }
                    bw.write(Long.toString(dp[temp]) + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}