import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class fibonacci_method {
    static int zeroCnt = 0;
    static int oneCnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            zeroCnt = 0;
            oneCnt = 0;

            if (N == 0) {
                zeroCnt = 1;
            } else if (N == 1) {
                oneCnt = 1;
            } else {
                fibonacci(N);
            }

            bw.write(Integer.toString(zeroCnt) + " " + Integer.toString(oneCnt) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void fibonacci(int N) {
        // zeroTemp와 oneTemp의 초기값은 N이 1일 때의 0과 1의 개수이다.
        int zeroTemp = 0;
        int oneTemp = 1;

        for (int i = 2; i <= N; i++) {
            zeroCnt = Math.max(zeroTemp, oneTemp);
            oneCnt = zeroCnt + zeroTemp;

            zeroTemp = zeroCnt;
            oneTemp = oneCnt;
        }
    }
}