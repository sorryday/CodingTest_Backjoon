package bfs;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class maze_search {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String t = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = t.charAt(j) - '0';
            }
        }

        bfs();
        bw.write(Integer.toString(map[N - 1][M - 1]));
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue_x = new LinkedList<Integer>();
        Queue<Integer> queue_y = new LinkedList<Integer>();

        queue_x.offer(0);
        queue_y.offer(0);

        visited[0][0] = true;

        while(!queue_x.isEmpty()){
            int x = queue_x.poll();
            int y = queue_y.poll();

            for(int i = 0; i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >=0 && ny >=0 && nx< N && ny < M){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                        queue_x.offer(nx);
                        queue_y.offer(ny);

                        visited[nx][ny] = true;

                        map[nx][ny] = map[x][y] + 1;
                    }
                }
            }
        }
    }
}