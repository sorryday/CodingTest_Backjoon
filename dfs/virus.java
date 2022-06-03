package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class virus {
    static int[][] map;
    static boolean[] visited;
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            map[first][second] = 1;
            map[second][first] = 1;
        }

        dfs(1);
        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if(!visited[i] && map[start][i] == 1) {
                cnt += 1;
                dfs(i);
            }
        }
    }
}