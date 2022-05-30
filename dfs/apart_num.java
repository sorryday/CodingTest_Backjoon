package dfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class apart_num {
    static boolean[][] visited;
    static int map[][];
    static int N;
    static int apartNum = 0;
    static int[] apart = new int[25 * 25];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        String temp;

        for (int i = 1; i <= N; i++) {
            temp = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = temp.charAt(j - 1) - '0';
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    apartNum += 1;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(apart);
        bw.write(Integer.toString(apartNum) + "\n");
        for (int i = 0; i < apart.length; i++) {
            if (apart[i] != 0) {
                bw.write(apart[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int startX, int startY) {
        visited[startX][startY] = true;
        apart[apartNum] += 1;

        for (int i = 0; i < 4; i++) {
            int xF = startX + dx[i];
            int yF = startY + dy[i];

            if (xF >= 0 && xF <= N && yF >= 0 && yF <= N) {
                if(map[xF][yF] == 1 && !visited[xF][yF]) {
                    dfs(xF, yF);
                }
            }
        }
    }
}