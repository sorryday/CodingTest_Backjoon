package bfs;

import java.io.*;
import java.util.*;

public class treasure {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];

                if (map[i][j] == 'L') {
                    int result = bfs_treasure(i, j);
                    total = Math.max(result, total);
                }
            }
        }

        bw.write(Integer.toString(total));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs_treasure(int i, int j) {
        Queue<Po> queue = new LinkedList<>();
        int val = 0;

        visited[i][j] = true;
        queue.add(new Po(i, j, 0));

        while(!queue.isEmpty()) {
            Po p = queue.poll();
            for(int d = 0; d < 4; d++) {
                int xf = p.x + dx[d];
                int yf = p.y + dy[d];
                if(0 <= xf && xf < N && 0 <= yf && yf < M && !visited[xf][yf] && map[xf][yf] == 'L') {
                    visited[xf][yf] = true;
                    queue.add(new Po(xf, yf, p.cnt + 1));
                    val = Math.max(val, p.cnt + 1);
                }
            }
        }
        return val;
    }

    public static class Po{
        int x;
        int y;
        int cnt;
        public Po(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}