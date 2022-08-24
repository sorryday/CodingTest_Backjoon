package bfs;

import java.io.*;
import java.util.*;

public class baby_shark_two {
    static class Point {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N;
    static int M;
    static int[] dx = {0, 0, 1, -1 ,1 ,1 ,- 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    static int result = 0;

    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    continue;
                }

                int tempResult = bfs_shark2(i, j);
                result = Math.max(tempResult, result);
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs_shark2(int row, int col) {
        visited = new boolean[N][M];
        visited[row][col] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col, 0));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];
                int newDist = poll.dist + 1;

                if (xf < 0 || yf < 0 || xf >= N || yf >= M || visited[xf][yf]) {
                    continue;
                }

                if (map[xf][yf] == 1) {
                    return newDist;
                }

                queue.offer(new Point(xf, yf, newDist));
                visited[xf][yf] = true;
            }
        }
        return 0;
    }
}
