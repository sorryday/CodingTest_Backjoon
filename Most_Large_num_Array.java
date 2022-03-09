import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Most_Large_num_Array {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        int[] num_A = new int[cnt];
        int[] dp = new int[cnt];

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < cnt; i++) {
            num_A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < cnt; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(num_A[j] < num_A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);
    }
}
