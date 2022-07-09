import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class uphill_road {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stair = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stair[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int sum = 0;

        for (int i = 0; i < N - 1; i++) {
            if (stair[i] < stair[i + 1]) {
                sum += stair[i + 1] - stair[i];
            }

            else {
                sum = 0;
            }
            result = Math.max(result, sum);
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}