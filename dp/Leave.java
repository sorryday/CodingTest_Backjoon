package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Leave {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int days = Integer.parseInt(br.readLine());
        dp = new int[days + 1];

        List<Integer> T = new ArrayList<>();
        List<Integer> P = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T.add(Integer.parseInt(st.nextToken()));
            P.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < days; i++) {
            if((T.get(i) + i) <= days) {
                dp[i + T.get(i)] = Math.max(dp[i + T.get(i)], dp[i] + P.get(i));
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        bw.write(Integer.toString(dp[days]));
        bw.flush();
        bw.close();
        br.close();
    }
}