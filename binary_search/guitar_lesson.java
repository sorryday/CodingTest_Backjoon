package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class guitar_lesson {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 강의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 수

        long left = 0;
        long right = 0;

        st = new StringTokenizer(br.readLine());
        int[] lesson = new int[N];
        for (int i = 0; i < N; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lesson[i]);
            right += lesson[i];
        }

        long mid = 0;

        while (left <= right) {
            long tempSum = 0;
            int cnt = 0;

            mid = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                tempSum += lesson[i];

                if (tempSum > mid) {
                    tempSum = lesson[i];
                    cnt += 1;
                }
            }
            if (tempSum > 0) {
                cnt += 1;
            }
            if (cnt <= M) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        bw.write(Long.toString(left));
        bw.flush();
        bw.close();
        br.close();
    }
}
