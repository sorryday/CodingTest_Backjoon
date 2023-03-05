import java.io.*;
import java.util.*;
import java.lang.*;

public class ArraySpin1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int rotateIdx = Math.min(N, M) / 2;

        // 회전수만큼 반복
        for (int i = 0; i < R; i++) {
            // 한번 회전할 때 돌려야하는 횟수
            for (int j = 0; j < rotateIdx; j++) {
                // 맨 처음 인덱스를 보관
                int first = map[j][j];

                // 반시계로 하나씩 땡긴다.
                for (int k = j + 1; k < M - j; k++) {
                    map[j][k - 1] = map[j][k];
                }

                for (int k = j + 1; k < N - j; k++) {
                    map[k - 1][M - j - 1] = map[k][M - j - 1];
                }

                for (int k = M - 2 - j; k >= j; k--) {
                    map[N - j - 1][k + 1] = map[N - j - 1][k];
                }

                for (int k = N - 2 - j; k >= j; k--) {
                    map[k + 1][j] = map[k][j];
                }

                map[j + 1][j] = first;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}