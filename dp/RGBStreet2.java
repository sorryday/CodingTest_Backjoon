package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class RGBStreet2 {
    static int[][] rgb;
    static int[][] dp;
    static int N;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        rgb = new int[N][3];
        dp = new int[N][3];
        result = 1000 * 1000;

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < 3; k++) {  // 색 하나를 고정한 다음에 나머지에는 1000 * 1000을 넣어주어 무조건 고른 색을 선택하게끔 한다...
            for (int i = 0; i < 3; i++) {
                if(i == k) {
                    dp[0][i] = rgb[0][i];
                }
                else {
                    dp[0][i] = 1000 * 1000;
                }
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }

            for(int i = 0 ; i < 3; i++) {
                if(i != k)
                    result = Math.min(result, dp[N - 1][i]);
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
