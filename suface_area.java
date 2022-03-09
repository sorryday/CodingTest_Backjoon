import java.io.*;
import java.util.StringTokenizer;

public class suface_area {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 0, M = 0;
        int result = 0;
        int temp = 0;

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());  // 행
        M = Integer.parseInt(st.nextToken());  // 열
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 일단 한 칸에서 보일 수 있는 겉넓이 다 더하기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                result += 2 + arr[i][j] * 4;
            }
        }

        // 행일 때 겹치는 거
        for(int i = 0; i < N ; i++) {
            for(int j = 0; j < M - 1; j++) {
                if(arr[i][j] == arr[i][j + 1]) {
                    temp = arr[i][j];
                }
                else {
                    temp = Math.min(arr[i][j], arr[i][j + 1]);
                }
                
                result -= temp * 2;
                temp = 0;
            }
        }

        // 열일 때 겹치는거 
        for(int i = 0; i < M ; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(arr[j][i] == arr[j + 1][i]) {
                    temp = arr[j][i];
                }
                else {
                    temp = Math.min(arr[j][i], arr[j + 1][i]);
                }
                
                result -= temp * 2;
                temp = 0;
            }
        }
        System.out.println(result);
    }
}