import java.io.*;
import java.util.StringTokenizer;

public class array_restore {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int H = 0, W = 0, X = 0, Y = 0;

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int[][] B = new int[H + X][W + Y];
        int[][] A = new int[H][W];

        for(int i = 0; i < H + X; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);

            for(int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색
        for(int i = 0; i < H + X; i++) {
            for(int j = 0; j < W + Y; j++) {
                if(i < X && j < W) {
                    A[i][j] = B[i][j]; 
                }

                else if(j < Y && i < H) {
                    A[i][j] = B[i][j]; 
                }
                
                else if(i >= X && i < H && j >= Y && j < W) {
                    A[i][j] = B[i][j] - A[i - X][j - Y];
                }
            }  
        }

        for(int i = 0; i < H ; i++) {
            for(int k = 0; k < W ; k++) {
                System.out.print(A[i][k] + " ");
            }
            System.out.println();
        }
    }
}