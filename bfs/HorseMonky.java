package bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class HorseMonky {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 말의 움직임을 좌표 값으로 나타낸것
    static int[] horseDx = {-2, -1, 1, 2, 2, 1, -2, -1};
    static int[] horseDy = {1, 2, 2, 1, -1, -2, -1, -2};

    static int[][] map;
    static int K, W, H;

    // BFS을 위한 방문 처리 배열-> [2][H][W] : 말로 움직여서 좌표에 왔는지, 인접한 방법으로 왓는지 구분하기 위해
    static boolean[][][] visited;

    static int result = Integer.MAX_VALUE;

    static class Point {
        int x;
        int y;
        int kCnt;
        int move;

        public Point(int x, int y, int kCnt, int move) {
            this.x = x;
            this.y = y;
            this.kCnt = kCnt;
            this.move = move;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[K + 1][H][W];
        monkeyBFS();

        // 결과 출력
        if (result == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(result));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void monkeyBFS() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, K, 0));

        visited[K][0][0] = true;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            if (poll.x == H - 1 && poll.y == W - 1) {
                result = Math.min(result, poll.move);
            }

            // 말로 움직일 수 있는 부분이 남아 있다면
            if (poll.kCnt > 0) {
                for (int i = 0; i < 8; i++) {
                    int xh = poll.x + horseDx[i];
                    int yh = poll.y + horseDy[i];

                    // 말은 벽을 넘을 수 있다.
                    if (isAvailable(xh, yh) && !visited[poll.kCnt - 1][xh][yh]
                            && map[xh][yh] == 0) {
                        visited[poll.kCnt - 1][xh][yh] = true;
                        q.add(new Point(xh, yh, poll.kCnt - 1, poll.move + 1));
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

                // 인접한 이동은 벽을 넘을 수 없다.
                if (isAvailable(xf, yf) && !visited[poll.kCnt][xf][yf] && map[xf][yf] == 0) {
                    visited[poll.kCnt][xf][yf] = true;
                    q.add(new Point(xf, yf, poll.kCnt, poll.move + 1));
                }
            }
        }
    }

    // 범위를 넘는지 판단하는 함수
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}