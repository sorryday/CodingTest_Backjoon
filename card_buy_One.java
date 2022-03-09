import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class card_buy_One {
    static int[] dp; // 최대 금액
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int cnt = Integer.parseInt(br.readLine());  // 구매할 카드 개수
        int[] cost = new int[cnt + 1];              // 코스트 배열

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 1; i <= cnt; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[cnt + 1];
        dp[0] = 0;
        dp[1] = cost[1];

        for(int i = 2; i <= cnt; i++) {
            dp[i] = cost[1] + dp[i - 1];

            for(int k = 2; k <= i; k++) {
                dp[i] = Math.max(dp[i], cost[k] + dp[i -k]);
            }
        }

        System.out.println(dp[cnt]);
        br.close();
    }
}
