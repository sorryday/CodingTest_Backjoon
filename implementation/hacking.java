package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hacking {
    static int N, M;
    static int[] computerCnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1]; // A -> B로의 경우를 저장할 ArrayList 배열
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            list[first].add(second);
        }

        computerCnt = new int[N + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            dfs_computer(i, visited, list);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, computerCnt[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (computerCnt[i] == max) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs_computer(int i, boolean[] visited, ArrayList<Integer>[] list) {
        visited[i] = true;

        for (int temp : list[i]) {
            if (!visited[temp]) {
                computerCnt[temp] += 1;
                dfs_computer(temp, visited, list);
            }
        }
    }
}