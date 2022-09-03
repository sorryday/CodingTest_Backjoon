package backtracking;

import java.io.*;
import java.util.*;

public class Loma_num {
    static int list[] = {1, 5, 10, 50};
    static int N;
    static boolean[] visited;
    static  int result = 0;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[1001];

        loma(N, 0, 0);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void loma(int n, int index, int sum) {
        if (n == 0) {
            if (!visited[sum]) { // 중복으로 들어가는 값 판별
                result += 1;
                visited[sum] = true;
            }
            return;
        }

        for (int i = index; i < 4; i++) {
            loma(n - 1, i, sum + list[i]);
        }
    }
}