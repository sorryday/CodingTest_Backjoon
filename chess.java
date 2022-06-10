import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class chess {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[6];

        for (int i = 0; i < 6; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    bw.write(Integer.toString(1 - num[i]) + " ");
                    break;

                case 1:
                    bw.write(Integer.toString(1 - num[i]) + " ");
                    break;

                case 2:
                    bw.write(Integer.toString(2 - num[i]) + " ");
                    break;

                case 3:
                    bw.write(Integer.toString(2 - num[i]) + " ");
                    break;

                case 4:
                    bw.write(Integer.toString(2 - num[i]) + " ");
                    break;

                case 5:
                    bw.write(Integer.toString(8 - num[i]) + " ");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}