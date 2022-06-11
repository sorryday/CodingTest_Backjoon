package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class coin {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());     // 테스트케이스 수
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());  // 동전의 종류 수
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] coinList = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                coinList[j] = Integer.parseInt(st.nextToken());  // 동전의 종류
            }

            int M = Integer.parseInt(br.readLine()); // 만들어야하는 금액
            int[] dp = new int[M + 1];

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    if(k - coinList[j] > 0) {
                        dp[k] = dp[k] + dp[k - coinList[j]];
                    }
                    else if(k - coinList[j] == 0) {
                        dp[k] = dp[k] + 1;
                    }
                }
            }

            bw.write(Integer.toString(dp[M]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}