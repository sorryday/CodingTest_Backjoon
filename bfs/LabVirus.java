package bfs;

import java.io.*;
import java.util.*;

public class LabVirus {
    static int N, M;
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
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
        virusDFS(3);

        bw.write(Integer.toString(result) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void virusDFS(int wallCnt) {
        if (wallCnt == 0) {
            virusBFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    virusDFS(wallCnt - 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void virusBFS() {
        int[][] mapClone = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mapClone[i][j] = map[i][j];
            }
        }
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapClone[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point poll = q.remove();

            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

                if (xf >= 0 && xf < N && yf >= 0 && yf < M) {
                    if (mapClone[xf][yf] == 0) {
                        mapClone[xf][yf] = 2;
                        q.add(new Point(xf, yf));
                    }
                }
            }
        }
        safeCount(mapClone);
    }

    static void safeCount(int[][] mapClone_2) {
        int sum = 0;
        for (int l = 0; l < N; l++) {
            for (int m = 0; m < M; m++) {
                if (mapClone_2[l][m] == 0) {
                    sum += 1;
                }
            }
        }
        result = Math.max(sum, result);
    }
}