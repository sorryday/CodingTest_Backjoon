package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MovePipe1 {
    static int result = 0;
    static int N;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pipeDFS(0, 1, 1); // dir : 1=가로, 2= 세로, 3=대각선

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void pipeDFS(int x, int y, int dir) {
        // 끝에 도달할 수 있다면
        if (x == N - 1 && y == N - 1 && map[x][y] == 0) {
            result += 1;
            return;
        }

        switch (dir)  {
            case 1:
                // 가로는 (1)가로, (2)대각선으로 움직임
                // (1) 가로
                width(x, y);

                // (2) 대각선
                diagonal(x, y);
                break;
            case 2:
                // 세로는 (1)세로, (2)대각선으로 움직임
                // (1)세로
                height(x, y);

                // (2)대각선
                diagonal(x, y);
                break;
            case 3:
                // 대각선은 (1)가로, (2)세로, (3)대각선으로 움직임
                // (1) 가로
                width(x, y);

                // (2)세로
                height(x, y);

                // (3) 대각선
                diagonal(x, y);
                break;
        }
    }

    // 범위를 벗어나는지 확인
    private static boolean isSafe(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }
        return false;
    }

    // 가로 움직임
    private static void width(int x, int y) {
        if (isSafe(x, y + 1) && map[x][y + 1] == 0) {
            pipeDFS(x, y + 1, 1);
        }
    }

    // 세로 움직임
    private static void height(int x, int y) {
        if (isSafe(x + 1, y) && map[x + 1][y] == 0) {
            pipeDFS(x + 1, y, 2);
        }
    }

    // 대각선 움직임
    private static void diagonal(int x, int y) {
        if (isSafe(x + 1, y + 1) && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            pipeDFS(x + 1, y + 1, 3);
        }
    }
}
