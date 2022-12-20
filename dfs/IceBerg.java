package dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IceBerg {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;
        int waterCnt;

        public Point(int x, int y, int waterCnt) {
            this.x = x;
            this.y = y;
            this.waterCnt = waterCnt;
        }
    }

    static ArrayList<Point> points = new ArrayList<>();

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

        int years = 0;
        while (true) {
            years++;

            // 얼음 구역의 개수 체크
            int firstCnt = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        IceCnt(i, j);
                        firstCnt += 1;
                    }
                }
            }

            if (firstCnt == 0 || firstCnt >= 2) {
                years = 0;
                break;
            } else {
                // 얼음이 녹을 수 있는 점을 체크하는 로직
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] != 0) {
                            IceMalt(i, j);
                        }
                    }
                }

                // 얼음이 실제 녹는 로직
                for (int i = 0; i < points.size(); i++) {
                    if (map[points.get(i).x][points.get(i).y] - points.get(i).waterCnt < 0) {
                        map[points.get(i).x][points.get(i).y] = 0;
                    } else {
                        map[points.get(i).x][points.get(i).y] -= points.get(i).waterCnt;
                    }
                }
                points.clear();

                // 얼음 구역의 개수 체크
                visited = new boolean[N][M];
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] != 0 && !visited[i][j]) {
                            IceCnt(i, j);
                            cnt += 1;
                        }
                    }
                }

                // 열음 구역의 개수가 2가 넘거나 전부 녹을 때까지 두 덩어리 이상으로 분리되지 않는다면
                if (cnt >= 2) {
                    break;
                }
            }
        }

        bw.write(Integer.toString(years));
        bw.flush();
        bw.close();
        br.close();
    }

    static void IceCnt(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (xf >= 0 && xf < N && yf >= 0 && yf < M && !visited[xf][yf] && map[xf][yf] != 0) {
                IceCnt(xf, yf);
            }
        }
    }

    static void IceMalt(int x, int y) {
        int waterCntMethod = 0;
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (map[xf][yf] == 0) {
                waterCntMethod += 1;
            }
        }

        if (waterCntMethod > 0) {
            points.add(new Point(x, y, waterCntMethod));
        }
    }
}
