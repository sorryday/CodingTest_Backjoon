package brute_force;

import java.io.*;
import java.util.*;

public class RePaintChess {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int t_result = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int W = 0; // W부터 시작할 때 칠해야하는 개수
                int B = 0; // B부터 시작할 때 칠해야하는 개수

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {

                        // 현재 열 + 행이 짝수일 때
                        if ((k + l) % 2 == 0) {
                            // 짝 수 행일 때는 그 위치의 값에 맞는 문자에 +1을 해주고
                            // 홀 수 행일 때는 그 위치의 값에 반대되는 문자에 + 1을 한다.
                            if (map[k][l] == 'W') {
                                W++;
                            } else {
                                B++;
                            }
                        } else { // 현재 열 + 행이 홀수일 때
                            if (map[k][l] == 'B') {
                                W++;
                            } else {
                                B++;
                            }
                        }
                    }
                }
                t_result = Math.min(W, B);
                result = Math.min(result, t_result);
            }
        }

        bw.write(Integer.toString(result) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}