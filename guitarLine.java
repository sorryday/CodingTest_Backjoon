import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class guitarLine {
    static int N, M, result;
    static int[] pacage, one;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pacage = new int[M];
        one = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pacage[i] = Integer.parseInt(st.nextToken());
            one[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pacage);
        Arrays.sort(one);
        store();

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void store() {
        while (N != 0) {
            if (N >= 6 && pacage[0] <= one[0] * 6) {
                result += pacage[0];
                N -= 6;
            }
            else if (N >= 6 && pacage[0] > one[0] * 6) {
                result += one[0] * 6;
                N -= 6;
            }
            else {
                if (pacage[0] <= one[0] * N) {
                    result += pacage[0];
                    N = 0;
                }
                else {
                    result += N * one[0];
                    N = 0;
                }
            }
        }
    }
}