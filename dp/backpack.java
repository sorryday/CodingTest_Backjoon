package dp;

import java.io.*;
import java.util.*;

class backpack {
    static int[] dp;
    static int N;
    static int K;

    static int[] W;
    static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N + 1];
        V = new int[N + 1];

        dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = K; j - W[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }

        bw.write(Integer.toString(dp[K]));
        bw.flush();
        bw.close();
        br.close();
    }
}
