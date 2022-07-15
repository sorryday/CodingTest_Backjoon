package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class red_green_weakness {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        String input;
        int result1 = 0;
        int result2 = 0;

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs_no(i, j);
                    result1 += 1;
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs_yes(i, j);
                    result2 += 1;
                }
            }
        }

        bw.write(Integer.toString(result1) + " " + Integer.toString(result2));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs_yes(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (xf >= 0 && yf >= 0 && xf < N && yf < N && !visited[xf][yf] && (map[x][y] == map[xf][yf])) {
                dfs_yes(xf, yf);
            }
            else if(xf >= 0 && yf >= 0 && xf < N && yf < N && !visited[xf][yf]) {
                if ((map[x][y] == 'R' && map[xf][yf] == 'G') || (map[x][y] == 'G' && map[xf][yf] == 'R')) {
                    dfs_yes(xf, yf);
                }
            }
        }
    }

    private static void dfs_no(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (xf >= 0 && yf >= 0 && xf < N && yf < N && !visited[xf][yf] && (map[x][y] == map[xf][yf])) {
                dfs_no(xf, yf);
            }
        }
    }
}
