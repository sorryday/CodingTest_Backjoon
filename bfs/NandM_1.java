package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class NandM_1 {
    static boolean[] visited;
    static int N, M;
    static int[] map;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        map = new int[M + 1];

        if (M == 1) {
            for (int i = 1; i <= N; i++) {
                bw.write(Integer.toString(i) + "\n");
            }
        } else {
            NandM_BackTracking(1);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void NandM_BackTracking(int idx) throws Exception{
        if (idx > M) {
            for (int i = 1; i < map.length; i++) {
                bw.write(map[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            map[idx] = i;

            NandM_BackTracking(idx + 1);
            visited[i] = false;
        }
    }
}
