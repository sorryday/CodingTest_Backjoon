package dp;

import java.io.*;
import java.util.StringTokenizer;

public class GreedyPanda {
    static int[][] map;
    static int N;
    static int[][] dp;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력을 변수 및 배열에 초기화
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열 초기화
        dp = new int[N][N];

        // DFS 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, pandaDFS(i, j));
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int pandaDFS(int x, int y) {
        // 지금 탐색하는 좌표를 거쳐간 경로의 최대 값(dp[x][y])이 0보다 크다는건 이미 이 지점을 지나갔을 때 최댓값을 갱신했다는 의미이므로
        // dp[x][y] 값을 리턴한다.
        if (dp[x][y] > 0) {
            return dp[x][y];
        }

        // 좌표에 도착했다는건 한번 이동했다는 의미이므로 1을 넣는다.
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (isAvailable(xf, yf) && map[x][y] < map[xf][yf]) {
                // 현재까지 DP 값과 다음 좌표로의 return + 1과 비교하여 dp 위치 값을 갱신한다.
                dp[x][y] = Math.max(dp[x][y], pandaDFS(xf, yf) + 1);
            }
        }
        return dp[x][y];
    }

    // 범위를 넘는지 판단하는 함수
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
