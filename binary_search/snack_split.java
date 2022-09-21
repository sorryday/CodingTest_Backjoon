package binary_search;

import java.io.*;
import java.util.*;

public class snack_split {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 조카 수
        int N = Integer.parseInt(st.nextToken()); // 과자 수

        int[] snackArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snackArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snackArr);

        int first = 1;
        int last = snackArr[snackArr.length - 1];
        int mid = 0;
        int result = 0;

        while (first <= last) {
            mid = (first + last) / 2;

            int cnt = 0;
            for (int i = 0; i < snackArr.length; i++) {
                cnt += snackArr[i] / mid;
            }

            if (cnt >= M) {
                result = mid;
                first = mid + 1;
            }

            else {
                last = mid - 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}