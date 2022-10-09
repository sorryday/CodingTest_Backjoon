package implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        double[] arr = new double[N];

        double result = 0.0;
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = K; i < N - K; i++) {
            result += arr[i];
        }
        bw.write(String.format("%.2f", result / (N - (K * 2)) + 1e-8) + "\n");

        for (int i = 0; i < K; i++) {
            result += arr[K];
            result += arr[N - K - 1];
        }
        bw.write(String.format("%.2f", result / N + 1e-8) );
        bw.flush();
        bw.close();
        br.close();
    }
}