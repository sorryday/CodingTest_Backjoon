package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Sheep {
    static char[][] map;
    static int R, C;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;

    static int sheepCnt = 0;
    static int wolfCnt = 0;

    public static void main(String[] args) throws IOException {
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
        visited = new boolean[R][C];

        int sheepCntResult = 0;
        int wolfCntResult = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    dfs_sheep_wolf(i, j);

                    if (sheepCnt > wolfCnt) {
                        wolfCnt = 0;
                    } else {
                        sheepCnt = 0;
                    }

                    sheepCntResult += sheepCnt;
                    wolfCntResult += wolfCnt;

                    sheepCnt = 0;
                    wolfCnt = 0;
                }
            }
        }

        bw.write(Integer.toString(sheepCntResult) + " " + Integer.toString(wolfCntResult));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs_sheep_wolf(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'o') {
            sheepCnt += 1;
        } else if (map[x][y] == 'v') {
            wolfCnt += 1;
        }

        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (xf >= 0 && xf < R && yf >= 0 && yf < C && !visited[xf][yf] && map[xf][yf] != '#') {
                dfs_sheep_wolf(xf, yf);
            }
        }
    }
}