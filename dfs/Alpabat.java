package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Alpabat {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C;
    static char[][] map;
    static int result = Integer.MIN_VALUE;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        Alpa_DFS(0, 0, 0);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void Alpa_DFS(int x, int y, int cnt) {
        if (visited[map[x][y] - 'A']) {
            result = Math.max(result, cnt);
            return;
        } else {
            visited[map[x][y] - 'A'] = true;
            for (int i = 0; i < 4; i++) {
                int xf = x + dx[i];
                int yf = y + dy[i];

                if (xf >= 0 && xf < R && yf >= 0 && yf < C) {
                    Alpa_DFS(xf, yf, cnt + 1);
                }
            }
            visited[map[x][y] - 'A'] = false;
        }
    }
}
