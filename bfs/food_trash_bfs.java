package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class food_trash_bfs {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, K;
    static int result = Integer.MIN_VALUE;
    static int tempResult = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int xPoint = Integer.parseInt(st.nextToken()) - 1;
            int yPoint = Integer.parseInt(st.nextToken()) - 1;

            map[xPoint][yPoint] = -1;
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (!visited[i][j] && map[i][j] == -1) {
                    tempResult += 1;
                    bfs_trash(i, j);

                    result = Math.max(tempResult, result);
                    tempResult = 0;
                }
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs_trash(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

                if (xf >= 0 && yf >= 0 && xf < N && yf < M && !visited[xf][yf]) {
                    if (map[xf][yf] == -1) {
                        queue.add(new Point(xf, yf));
                        visited[xf][yf] = true;
                        tempResult += 1;
                    }
                }
            }
        }
    }
}