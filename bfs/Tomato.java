package bfs;

import java.io.*;
import java.util.*;

public class Tomato {
    static int M, N;
    static int[][] tomatoBox;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    static class Point {
        int x;
        int y;
        int day; // 좌표의 토마토가 익을때까지 걸린 day

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    // bfs를 탐색할 큐
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoBox = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());

                // 이미 익은 토마토일 경우
                if (tomatoBox[i][j] == 1) {
                    q.add(new Point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        //  0인지 탐색 : 이미 익을 수 있는 토마토가 다 익은 경우
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == -1 || tomatoBox[i][j] == 1) {
                    cnt += 1;
                }
            }
        }

        int result = 0;

        //  0인지 탐색 : 이미 익을 수 있는 토마토가 다 익은 경우 0을 입력
        if (cnt == N * M) {
            result = 0;
        } else {
            result = tomatoBFS();
            // 하나라도 익지 못한 토마토가 있을 경우
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomatoBox[i][j] == 0) {
                        result = -1;
                    }
                }
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int tomatoBFS() {
        // 토마토가 익는 day의 최대 값
        int dayMax = 0;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            // 지금까지 갱신한 날짜와 큐에서 꺼낸 날짜의 차이가 있는 경우만 갱신
            if (dayMax < poll.day) {
                dayMax = poll.day;
            }

            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

                // 방문을 하지 않았고 다음 탐색하려는 곳이 토마토가 없는 경우가 아닌 경우
                if (xf >= 0 && xf < N && yf >= 0 && yf < M && !visited[xf][yf] && tomatoBox[xf][yf] != -1) {
                    visited[xf][yf] = true;
                    tomatoBox[xf][yf] = 1;
                    q.add(new Point(xf, yf, poll.day + 1));
                }
            }
        }
        return dayMax;
    }
}