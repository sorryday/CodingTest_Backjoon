package divide_conquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QuadTree {
    static char[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        quadTree(0, 0, N); // 처음 출발하는 좌표 , 자르려는 배열의 사이즈

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void quadTree(int x, int y, int size) {
        if (size == 1) {
            sb.append(map[x][y]);
            return;
        }

        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] == '0')
                    zeroCnt++;
                else
                    oneCnt++;
            }
        }

        if (zeroCnt == size * size) sb.append(0);
        else if (oneCnt == size * size) sb.append(1);
        else {
            int half = size / 2;
            // 1사분면
            sb.append("(");
            quadTree(x, y, half);
            // 2사분면
            quadTree(x, y + half, half);
            // 3사분면
            quadTree(x + half, y, half);
            // 4사분면
            quadTree(x + half, y + half, half);
            sb.append(")");
        }
    }
}