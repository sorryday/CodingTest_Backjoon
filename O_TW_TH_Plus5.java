import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class O_TW_TH_Plus5 {
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];
        long result = 0;

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int k = 4; k <= 100000; k++) {
            dp[k][1] = (dp[k - 1][2] + dp[k - 1][3]) % 1000000009;        
            dp[k][2] = (dp[k - 2][1] + dp[k - 2][3]) % 1000000009;        
            dp[k][3] = (dp[k - 3][1] + dp[k - 3][2]) % 1000000009;
        }
        
        for(int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            result = (dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009;
            
            System.out.println(result);
        }
    }
}
