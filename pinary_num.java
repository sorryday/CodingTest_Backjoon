import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class pinary_num {
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        long[] dp = new long[91]; // n자리 수 일 때 이친수의 개수 저장 배열

        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= cnt; i++) {
            dp[i] = dp[i - 1] + dp[i -2]; 
        }

        System.out.println(dp[cnt]);
    }
}
