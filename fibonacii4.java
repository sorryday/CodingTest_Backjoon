import java.io.*;
import java.math.BigInteger;

public class fibonacii4 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[cnt + 1]; // 피보나치 DP
     
        if(cnt == 0) {
            bw.write("0" + "\n");
            
        }

        else if(cnt == 1 || cnt == 2) {
            bw.write("1" + "\n");
        }

        else {
            dp[0] = BigInteger.ZERO;
            dp[1] = BigInteger.ONE;

            for(int i = 2; i <= cnt; i++) {
                dp[i] = dp[i - 2].add(dp[i - 1]);
            }

            bw.write(dp[cnt] + "\n"); 
        }

        bw.flush();
        bw.close();
        br.close();
    }
}