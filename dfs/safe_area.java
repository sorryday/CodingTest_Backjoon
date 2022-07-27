package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class safe_area {
    static int N;
    static int[][] map;
    static int[][] bin_map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = 0;
    static int tempResult = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k <= 100; k++) {
            bin_map = new int[N][N];
            visited = new boolean[N][N];
            tempResult = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= k) {
                        bin_map[i][j] = 0;
                    }
                    else {
                        bin_map[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (bin_map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        tempResult += 1;
                    }
                }
            }
            max = Math.max(max, tempResult);
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        if (!visited[x][y]) {
            visited[x][y] = true;
        }

        for (int i = 0; i < 4; i++) {
            int xF = x + dx[i];
            int yF = y + dy[i];

            if (xF >= 0 && yF >= 0 && xF < N && yF < N && !visited[xF][yF] && bin_map[xF][yF] == 1) {
                dfs(xF, yF);
            }
        }
    }
}