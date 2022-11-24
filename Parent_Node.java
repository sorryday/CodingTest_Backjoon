import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Parent_Node {
    static ArrayList<Integer>[] list;
    static int[] p; // 부모노드 배열
    static boolean[] visited;  // 방문처리 배열
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        p = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }

        for (int i = 2; i <= N; i++) {
            bw.write(Integer.toString(p[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x) {
        if(visited[x]) {
            return;
        }
        visited[x] = true;

        for (int i : list[x]) {
            if(!visited[i]) {
                p[i] = x; // 부모노드 입력
                dfs(i);
            }
        }
    }
}