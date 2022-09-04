package implementation;

import java.io.*;
import java.util.*;

public class weather_caster {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] sky = new char[H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                sky[i][j] = input.charAt(j);
            }
        }

        int[][] result = new int[H][W];

        int count = 0;
        boolean first_c_flag = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (j == 0 && sky[i][j] != 'c') {
                    first_c_flag = false;
                }

                if (sky[i][j] == 'c') {
                    count = 0;
                    result[i][j] = 0;
                    first_c_flag = true;
                }

                if (!first_c_flag) {
                    result[i][j] = -1;
                    continue;
                }

                if (sky[i][j] == '.') {
                    result[i][j] = count;
                }

                count += 1;
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}