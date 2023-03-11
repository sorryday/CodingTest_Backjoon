package dfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cheese {
    static int N,M; // N : row, M : col
    static int[][] map; // 치즈 맵
    static int cheeseCnt = 0; // 치즈 수
    static boolean[][] visited;

    static int result = 0; // 치즈 수가 0이 될 때까지 걸린 시간

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

    static Queue<Point> pointQueue; // 치즈를 녹일 좌표가 들어있는 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 입력 셋팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        // 반복문 시작
        while (true) {
            if (cheeseCnt == 0) break;

            // visited 배열 초기화 및 큐 초기화
            visited = new boolean[N][M];
            pointQueue = new ArrayDeque<>();

            // 외부 공기를 찾는 DFS
            // 외부 : true, 내부 : false
            cheeseDFS(0, 0);

            //4방 탐색으로 치즈가 외부 공기와 얼마나 접촉하는지 카운트
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && cheeseCntMethod(i, j)) {
                        // 참이면 치즈가 녹는다는 얘기이므로

                        pointQueue.add(new Point(i, j));
                    }
                }
            }

            // 리스트에 들어있는 만큼 치즈를 녹여준다.
            while (!pointQueue.isEmpty()) {
                Point poll = pointQueue.poll();
                map[poll.x][poll.y] = 0;
                cheeseCnt--;
            }

            // 다 끝났다면 1시간이 지남
            result += 1;
        }

        // 결과 출력
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 외부 공기 찾는 DFS
    private static void cheeseDFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (isAvailable(xf, yf) && !visited[xf][yf] && map[xf][yf] == 0) {
                cheeseDFS(xf, yf);
            }
        }
    }

    // 배열의 범위를 넘는지 판단하는 함수
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    // 4방 탐색으로 치즈가 외부 공기와 얼마나 접촉하는지 카운트하는 함수
    private static boolean cheeseCntMethod(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            // 외부 공기와 접촉한다면
            if (map[xf][yf] == 0 && visited[xf][yf]) {
                cnt++;
            }
        }

        return cnt >= 2;
    }
}
