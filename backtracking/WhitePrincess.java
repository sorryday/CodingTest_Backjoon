package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WhitePrincess {
    static int[] arr;
    static boolean[] visited;
    static int allSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            allSum += arr[i];
        }

        visited = new boolean[9];
        selected100(0, 0, 0);
    }

    private static void selected100(int cnt, int sum, int trueCnt) {
        if (cnt == 9) {
            if (sum == 100 && trueCnt == 7) {
                for (int i = 0; i < 9; i++) {
                    if (visited[i]) {
                        System.out.println(arr[i]);
                    }
                }
            }
            return;
        }

        visited[cnt] = true;
        selected100(cnt + 1, sum + arr[cnt], trueCnt + 1);

        visited[cnt] = false;
        selected100(cnt + 1, sum, trueCnt);
    }
}
