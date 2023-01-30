package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NandM_2 {
    static int[] arr;
    static boolean[] visited;
    static int N;
    static int M;

    static List<String> stringList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];
        stringList = new ArrayList<>();

        if (M == 1) {
            for (int i = 0; i < N; i++) {
                System.out.println(i + 1);
            }
        } else if (M == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(i + 1 + " ");
            }
        } else {
            backTracking_N_M(0);
        }
    }

    private static void backTracking_N_M(int depth) {
        if (depth == M) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] >= arr[i + 1]) {
                    return;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backTracking_N_M(depth + 1);
                visited[i] = false;
            }
        }
    }
}