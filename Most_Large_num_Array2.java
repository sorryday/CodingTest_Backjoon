import java.io.*; 
import java.util.*;

public class Most_Large_num_Array2 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] num_A = new int[cnt];
        int[] dp = new int[cnt];
        int result = 1; // 최장거리 수열의 원소 수

        Stack<Integer> stack = new Stack<Integer>();  // 역 추적하여 수열을 출력할 스택

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
            result = Math.max(result, dp[i]);
        }

        int val = result;
        System.out.println(result);

        for(int i = cnt - 1; i >= 0; i--) {
            if(val == dp[i]) {
                stack.push(num_A[i]);
                val -= 1;
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
