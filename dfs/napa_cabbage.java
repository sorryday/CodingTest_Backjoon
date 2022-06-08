package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class napa_cabbage {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int M;
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int result = 0;
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int TestCnt = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < TestCnt; j++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        result += 1;
                    }
                }
            }

            bw.write(Integer.toString(result) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (xf >= 0 && xf < M && yf >= 0 && yf < N && map[xf][yf] == 1 && !visited[xf][yf]) {
                dfs(xf, yf);
            }
        }
    }
}