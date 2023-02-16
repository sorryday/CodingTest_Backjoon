package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SpinArr4 {
    static int N, M, K;
    static int[][] numArr;
    static int[][] cals;
    static int min;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] numsTmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numArr = new int[N][M];
        cals = new int[K][3];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            cals[i][0] = Integer.parseInt(st.nextToken());
            cals[i][1] = Integer.parseInt(st.nextToken());
            cals[i][2] = Integer.parseInt(st.nextToken());
        }

        permu(new int[K][3], new boolean[K], 0);

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permu(int[][] res, boolean[] visited, int depth) {
        if(depth == K) {
            min = Math.min(min, spinArr(res));
            return;
        }

        for(int i = 0; i < K; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res[depth] = cals[i];
                permu(res, visited, depth+1);
                visited[i] = false;
            }
        }
    }

    public static int spinArr(int[][] res) {
        numsTmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                numsTmp[i][j] = numArr[i][j];
            }
        }

        for(int[] now: res) {
            int r = now[0];
            int c = now[1];
            int s = now[2];
            int[] point1 = {r - s - 1, c - s - 1};
            int[] point2 = {r + s - 1, c + s - 1};
            int turnNum = Math.min(point2[0] - point1[0] + 1, point2[1] - point1[1] + 1) / 2;

            for (int i = 0; i < turnNum; i++) {
                int x = point1[0] + i;
                int y = point1[1] + i;
                int startX = x;
                int startY = y;
                int tmp = numsTmp[x][y];
                int dir = 0;

                while (dir < 4) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx < point1[0] + i || ny < point1[1] + i || nx > point2[0] - i || ny > point2[1] - i) {
                        dir++;
                        continue;
                    }

                    numsTmp[x][y] = numsTmp[nx][ny];
                    x = nx;
                    y = ny;
                }

                numsTmp[startX][startY+1] = tmp;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int minTmp = 0;
            for(int j = 0; j < M; j++) {
                minTmp += numsTmp[i][j];
            }
            minSum = Math.min(minSum, minTmp);
        }
        return minSum;
    }
}