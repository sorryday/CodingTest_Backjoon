import java.io.*;
import java.util.Arrays;

public class rope {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.MIN_VALUE;
        
        int N = Integer.parseInt(br.readLine());
        int[] lop = new int[N];
        for(int i = 0; i < N; i++) {
            lop[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lop);

        int lopMax = lop[lop.length - 1];  // 최대값
        int flag = N - 1;

        for(int i = N - 1; i >= 0; i--) {
            int temp = 0 , cnt = 0;
            
            for(int j = N - 1; j >= flag; j--) {
                temp = Math.min(lopMax, lop[j]);
                cnt += 1;
            }
            temp = temp * cnt;
            max = Math.max(temp, max);
            flag -= 1;
        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}