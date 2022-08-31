package binary_search;

import java.io.*;
import java.util.*;

public class jewel_box {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];

        int left = 1;
        int right = 0;
        int mid = 0;
        int sum = 0;
        int result = 0;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0;
            for (int i = 0; i < M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    sum += 1;
                }
            }

            if (sum > N) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                result = mid;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}