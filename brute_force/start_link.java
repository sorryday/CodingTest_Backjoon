package brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class start_link {
    static int N;
    static boolean[] visited;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean flag = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combine(0, 0);

        if(!flag) {
            bw.write("0");
        }
        else {
            bw.write(Integer.toString(min));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combine(int index, int cnt) {
        if(cnt == N / 2) {
            business();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combine(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void business() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += map[i][j];
                    startTeam += map[j][i];
                }

                else if (!visited[i] && !visited[j]) {
                    linkTeam += map[i][j];
                    linkTeam += map[j][i];
                }
            }
        }
        int tempVal = Math.abs(startTeam - linkTeam);

        if(startTeam == linkTeam) {
            flag = false;
            return;
        }
        min = Math.min(tempVal, min);
    }
}