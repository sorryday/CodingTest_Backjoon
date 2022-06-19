package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class lanLine_cutting {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];

        long flagMaxInt = 0;
        long flagMinInt = 0;
        long mid = 0;

        for (int i = 0; i < K; i++) {
            long tempNum = Integer.parseInt(br.readLine());
            if (flagMaxInt < tempNum) {
                flagMaxInt = tempNum;
            }
            arr[i] = tempNum;
        }
        flagMaxInt += 1;

        while(flagMinInt < flagMaxInt) {
            long cnt = 0;
            mid = (flagMaxInt + flagMinInt) / 2;

            for (int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt < N) {
                flagMaxInt = mid;
            }
            else {
                flagMinInt = mid + 1;
            }
        }
        bw.write(Long.toString(flagMinInt - 1));
        bw.flush();
        bw.close();
        br.close();
    }
}