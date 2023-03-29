package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Game {
    static boolean[][] visited;
    static char[][] map;

    static int N, M;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] dp;
    static int result = Integer.MIN_VALUE;
    static boolean isLoop = false; // 무한 루프 플래그

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // map 초기화
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        // visited, dp 배열 초기화
        visited = new boolean[N][M];
        dp = new int[N][M];

        // DFS : x, y, depth
        visited[0][0] = true;
        gameDFS(0, 0, 1);

        // isLoop 플래그가 true라면 -1 출력
        if (isLoop) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(result));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // dfs 함수
    private static void gameDFS(int x, int y, int depth) {
        dp[x][y] = depth;
        result = Integer.max(depth, result);

        // 내 위치의 값 확인
        int val = map[x][y] - '0';

        // 상하좌우로 이동시켜 주기
        for (int i = 0; i < 4; i++) {
            int xf = x + (dx[i] * val);
            int yf = y + (dy[i] * val);

            if (isAvailable(xf, yf) && map[xf][yf] != 'H') {

                // 만약 방문을 햇다면 사이클이 발생했으므로
                if (visited[xf][yf]) {
                    isLoop = true;
                    return;
                }

                // 다음에 탐색하려는 위치의 DP 값이 지금 Depth보다 크면 재귀를 탈 이유가 없다.
                if (depth >= dp[xf][yf]) {
                    // 방문 처리
                    visited[xf][yf] = true;

                    gameDFS(xf, yf, depth + 1);

                    // 다시 돌아와서는 visited 초기화
                    visited[xf][yf] = false;
                }
            }
        }
    }

    // 범위를 넘는지 판단하는 함수
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}