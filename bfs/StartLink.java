package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartLink {
    static int F, S, G, U, D;
    static int result = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[1000001];

        int flagInt = startLinkBFS();
        if (flagInt == 1) {
            bw.write(Integer.toString(result));
        } else {
            bw.write("use the stairs");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int startLinkBFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        boolean flag = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int location = 0;

            for (int i = 0; i < size; i++) {
                location = queue.poll();

                if (location == G) {
                    flag = true;
                    break;
                }

                int loU = location + U;
                int loD = location - D;

                if (loU <= F && !visited[loU]) {
                    visited[loU] = true;
                    queue.add(loU);
                }
                if (loD > 0 && !visited[loD]) {
                    visited[loD] = true;
                    queue.add(loD);
                }
            }

            if (flag) {
                return 1;
            }
            result++;
        }

        return -1;
    }
}