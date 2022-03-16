import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class numArr_Jump {
    static int[] dx = {-1, 1 ,0 ,0};
    static int[] dy = {0, 0 ,-1 ,1};
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] arr = new String[5][5];
        StringTokenizer st;

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(arr, i, j, 0, arr[i][j]);
            }
        }
        System.out.println(list.size());
    }

    public static void dfs(String[][] arr, int x, int y, int cnt, String temp) {
        if(cnt == 5) {
            if(!list.contains(temp)) {
                list.add(temp);
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if((0 <= nowX && nowX < 5) && (0 <= nowY && nowY < 5)) {
                dfs(arr, nowX, nowY, cnt + 1, temp + arr[nowX][nowY]);
            }
        }
    }
}
