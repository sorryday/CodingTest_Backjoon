package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    static int[] dp;
    static int[] NumArr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        NumArr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            NumArr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = NumArr[1];
        for (int i = 2; i <= N; i++) {    // 여기서부터 생각못함
            dp[i] = NumArr[i];          // 부분 수열의 증가합은 일단 dp 배열에 해당 배열의 수를 집어넣고 시작

            for (int j = 1; j < i; j++) {   // 자기보다 작은 인덱스의 수를 돌면서 파악
                if(NumArr[i] > NumArr[j]) {  // 만약 자신이 파악하는 수보다 크다면
                    dp[i] = Math.max(NumArr[i] + dp[j], dp[i]);  // dp[i]에는 자신과(NumArr[i]) j까지 증가 수열의 합, 현재 dp[i] 중 큰 값을 갱신
                }
            } //
        }

        Arrays.sort(dp);  // 가장 큰 값을 반환해야하므로 오름차순으로 정렬

        bw.write(Integer.toString(dp[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
