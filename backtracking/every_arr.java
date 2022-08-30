package backtracking;

import java.io.*;
import java.util.*;

public class every_arr {
    static boolean[] visited;
    static int N;

    static int[] input;
    static int[] output;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        input = new int[N];
        output = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }

        printNum(0);
        br.close();
    }

    private static void printNum(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(output[i] + " ");
            }

            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                printNum(depth + 1);
                visited[i] = false;
            }
        }
    }
}