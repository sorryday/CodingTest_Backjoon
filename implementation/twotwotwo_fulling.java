package implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class twotwotwo_fulling {

    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(Integer.toString(recur(0, 0, N)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int recur(int i, int j, int size) {
        if(size == 2) {
            int arr[] = new int[4];
            int idx = 0;
            for(int r = i; r < i + 2; r++) {
                for(int c = j; c < j + 2; c++) {
                    arr[idx++] = map[r][c];
                }
            }

            Arrays.sort(arr);
            return arr[2];
        }
        else {
            int arr[] = new int[4];
            size = size/2;

            arr[0] = recur(i,j,size);
            arr[1] = recur(i,j+size,size);
            arr[2] = recur(i+size,j,size);
            arr[3] = recur(i+size,j+size,size);

            Arrays.sort(arr);
            return arr[2];
        }
    }
}