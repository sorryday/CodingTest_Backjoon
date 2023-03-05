package backtracking;

import java.io.*;
import java.util.*;
import java.lang.*;

public class NandM_3 {
    static int N, M;
    static int[] printArr;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        printArr = new int[M + 1];
        visited = new boolean[N + 1];

        NandM(1, 1);

        bw.flush();
        bw.close();
        br.close();
    }

    private static void NandM(int cnt, int depth) throws IOException {
        if (cnt > M) {
            for (int i = 1; i < printArr.length; i++) {
                bw.write(printArr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            printArr[cnt] = i;
            NandM(cnt + 1, i + 1);
        }
    }
}