package bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cheese2636 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Point> pointList = new ArrayDeque<>();
    static int day = 0;
    static int cnt = 0;
    static int size = 0;

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

        while (true) {
            cnt = 0;

            // visited를 위한 BFS를 돌린다.
            visited = new boolean[N][M];
            visitedBFS();

            // 외부 공기와 맵의 크기가 같다면 break;
            if (cnt == N * M - 1) break;

            // 녹을 치즈를 고르는 함수
            size = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        searchCheese(i ,j);
                    }
                }
            }

            // 치즈를 녹인다.
            while(!pointList.isEmpty()) {
                Point poll = pointList.poll();
                map[poll.x][poll.y] = 0;
                size++;
            }

            day++;
        }

        bw.write(day + "\n" + size);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void visitedBFS() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

                if (isAvailable(xf, yf) && !visited[xf][yf] && map[xf][yf] != 1) {
                    q.add(new Point(xf, yf));
                    visited[xf][yf] = true;
                    cnt++;
                }
            }
        }
    }

    private static void searchCheese(int x, int y) {
        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (isAvailable(xf, yf) && visited[xf][yf]) {
                flag = true;
            }
        }

        if (flag) {
            pointList.add(new Point(x, y));
        }
    }

    // 범위에 넘는지 확인
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}