import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class area_hap {
    static int[][] arr;
    static int[] CntRow = {-1, 0, 1, 0}; // 상우하좌
    static int[] CntCol = {0, 1, 0, -1}; // 상우하좌
    static ArrayList<Integer> list;      // 영역 저장
    static int count = 0;               // 영역을 카운트할 변수

    static int M = 0, N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int cnt = Integer.parseInt(st.nextToken());

        for(int k = 0; k < cnt; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        list = new ArrayList<Integer>();  // 각 영역 넓이 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        bw.write(Integer.toString(list.size()) + "\n");
        for (Integer i : list) {
            bw.write(Integer.toString(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int r, int c) {
        arr[r][c] = 1;
        count++;

        for(int i = 0; i < 4; i++) {
            int W_r = r + CntRow[i];
            int W_c = c + CntCol[i];

            if(W_r >= 0 && W_c >= 0 && W_r < N && W_c < M) {  // 방문해야 하는 곳에 방문을 안했고 범위를 넘지 않는다면
                if(arr[W_r][W_c] == 0) {
                    dfs(W_r, W_c);
                }
            }
        }
    }
}
