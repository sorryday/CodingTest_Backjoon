import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class continus_hap {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr = Integer.parseInt(br.readLine()); // 원소 개수
        int[] arr_n = new int[arr];
        int[] dp = new int[arr];

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < arr_n.length; i++) {
            arr_n[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr_n[0];

        for(int i = 1; i < dp.length; i++) {
            int temp = dp[i - 1] + arr_n[i];    // 이전까지 연속된 값들의 합
            dp[i] = Math.max(temp, arr_n[i]);   // 그 값과 자기 자신 중 큰 값을 dp에 대입
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);
    }
}