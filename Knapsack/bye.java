package Knapsack;

import java.io.*;
import java.util.StringTokenizer;

public class bye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] health_arr = new int[N];
        int[] happy_arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            health_arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            happy_arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100];
        for (int i = 0; i < N; i++) {
            for (int j = 99; j >= health_arr[i]; j--) {
                dp[j] = Math.max(dp[j - health_arr[i]] + happy_arr[i], dp[j]);
            }
        }

        bw.write(dp[99] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}