package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class wood_cutting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        long min = 0;
        long mid = 0;
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long temp = Long.parseLong(st.nextToken());
            if(max < temp) {
                max = temp;
            }
            arr[i] = temp;
        }

        max += 1;               // !! upper bound 일때 !!! +1을 하자!!!

        while (min < max) {
            long hap = 0;
            mid = (min + max) / 2;

            for (int i = 0; i < N; i++) {
                if(arr[i] - mid > 0) {
                    hap += arr[i] - mid;
                }
            }
            if (hap < M) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        bw.write(Long.toString(min - 1));
        bw.flush();
        bw.close();
        br.close();
    }
}