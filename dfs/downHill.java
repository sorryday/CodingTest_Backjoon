package dfs;

import java.io.*;
import java.util.*;

public class downHill {

    static int M, N;
    static int[][] map;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(Integer.toString(dfs_downhill(0, 0)));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs_downhill(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        else {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int xf = x + dx[i];
                int yf = y + dy[i];

                if (xf >= 0 && yf >= 0 && xf < M && yf < N) {

                    if (map[xf][yf] < map[x][y]) {
                        dp[x][y] += dfs_downhill(xf, yf);
                    }
                }
            }
        }

        return dp[x][y];
    }
}