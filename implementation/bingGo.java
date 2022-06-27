package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class bingGo {
    static int[][] map;
    static int[][] input;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[5][5];
        input = new int[5][5];
        visited = new boolean[5][5];
        int result = 0;
        boolean flag = false;

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingGo(input[i][j]);
                result += 1;

                if(EndBingGo()) {
                    bw.write(Integer.toString(result));
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bingGo(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(map[i][j] == n) {
                    visited[i][j] = true;
                }
            }
        }
    }

    public static boolean EndBingGo() {
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            int row = 0;
            for (int j = 0; j < 5; j++) {
                if(visited[i][j]) {
                    row += 1;
                    continue;
                }
                else {
                    break;
                }
            }
            if(row == 5) {
                cnt += 1;
            }
        }

        for (int i = 0; i < 5; i++) {
            int col = 0;
            for (int j = 0; j < 5; j++) {
                if(visited[j][i]) {
                    col += 1;
                    continue;
                }
                else {
                    break;
                }
            }
            if(col == 5) {
                cnt += 1;
            }
        }

        if(visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) {
            cnt += 1;
        }

        if(visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0]) {
            cnt += 1;
        }

        if(cnt >= 3) return true;
        else return false;
    }
}
