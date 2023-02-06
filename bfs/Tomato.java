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
        int day;

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static List<Point> oneList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoBox = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());

                if (tomatoBox[i][j] == 1) {
                    oneList.add(new Point(i, j, 0));
                }
            }
        }

        //  0인지 탐색
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == -1 || tomatoBox[i][j] == 1) {
                    cnt += 1;
                }
            }
        }

        int result = 0;
        if (cnt == N * M) {
            result = 0;
        } else {
            visited = new boolean[N][M];
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
        int dayMax = 0;

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < oneList.size(); i++) {
            Point one = oneList.get(i);
            visited[one.x][one.y] = true;
            q.add(one);
        }

        while (!q.isEmpty()) {
            Point poll = q.poll();
            dayMax = Math.max(dayMax, poll.day);

            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

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