package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class router_install {
    static int[] line;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        line = new int[N];
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(line);

        int mid = 0;
        int start = 1;
        int end = line[N - 1] - line[0] + 1;

        while (start < end) {
            mid = (start + end) / 2;

            if (install(mid) < C) {
                end = mid;
            }
            else {
                start = mid + 1;
            }

        }

        bw.write(Integer.toString(start - 1));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int install(int dist) {

        int cnt = 1; // 첫 번째 집에는 무조건 설치
        int endLocated = line[0];

        for (int i = 1; i < line.length; i++) {
            int lo = line[i];

            if (lo - endLocated >= dist) {
                cnt += 1;
                endLocated = lo;
            }
        }
        return cnt;
    }
}
