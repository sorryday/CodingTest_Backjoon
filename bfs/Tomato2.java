package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato2 {
    static int M, N, H;
    static int[][][] map;
    static boolean[][][] visited;

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class tomaotPoint {
        int z;
        int x;
        int y;
        int date;

        public tomaotPoint(int z, int x, int y, int date) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.date = date;
        }
    }
    static int result = 0;
    static Queue<tomaotPoint> tomaotPointQueue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());

                    if (map[i][j][k] == 1) {
                        tomaotPointQueue.add(new tomaotPoint(i, j, k, 0));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        // 받은 토마토가 모두 1이거나 토마토가 없는칸 (-1)인경우
        boolean flag = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        flag = false;
                    }
                }
            }
        }

        if (flag) {
            result = 0;
        } else {
            // 3차원 토마토 bfs 실행
            result = tomatoThirdBFS();

            // 하나라도 0이 있다면
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (map[i][j][k] == 0) {
                            result = -1;
                        }
                    }
                }
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int tomatoThirdBFS() {
        int dayTime = 0;
        while (!tomaotPointQueue.isEmpty()) {
            tomaotPoint poll = tomaotPointQueue.poll();

            if (dayTime < poll.date) {
                dayTime = poll.date;
            }

            for (int i = 0; i < 6; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];
                int zf = poll.z + dz[i];

                if (xf >= 0 && xf < N && yf >= 0 && yf < M && zf >= 0 && zf < H && !visited[zf][xf][yf] && map[zf][xf][yf] != -1) {
                    visited[zf][xf][yf] = true;
                    map[zf][xf][yf] = 1;
                    tomaotPointQueue.add(new tomaotPoint(zf, xf, yf, poll.date + 1));
                }
            }
        }
        return dayTime;
    }
}