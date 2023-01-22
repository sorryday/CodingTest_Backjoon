package brute_force;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumOfNumArrPart {
    static int T;
    static int[] arr;
    static boolean visited[];
    static int maxNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        arr = new int[T];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxNum += arr[i];
        }

        visited = new boolean[maxNum + 1];
        for (int i = 0; i < arr.length; i++) {
            visited[arr[i]] = true;
        }

        dfs(0, 0);

        boolean flag = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                bw.write(Integer.toString(i));
                flag = false;
                break;
            }
        }

        if (flag) {
            bw.write(Integer.toString(maxNum + 1));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int depth, int sum) {
        if (depth == T) {
            visited[sum] = true;
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
