package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Array_Most_Long {
    static int[] dp;
    static int[] NumArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        NumArr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            NumArr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if(NumArr[i] < NumArr[j] && dp[i] <= dp[j]) { // dp[i] <= dp[j] 이 조건을 생각 못함
                    dp[i] = dp[j] + 1;
                }

                else if(NumArr[i] == NumArr[j]) {
                    dp[i] = dp[j];
                }
            } //
        }

        Arrays.sort(dp); // 가장 길게 연결된 수열을 찾아야 하므로 오름차순 정렬

        bw.write(Integer.toString(dp[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
