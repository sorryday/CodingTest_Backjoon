import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer; 

public class treasure {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine()); // 배열 크기
        String A = br.readLine();
        String B = br.readLine();

        int[] A_arr = new int[cnt];
        int[] B_arr = new int[cnt];

        int result = 0;

        StringTokenizer st = new StringTokenizer(A);
        for(int i = 0; i < cnt; i++) {
            A_arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(B);
        for(int i = 0; i < cnt; i++) {
            B_arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A_arr);
        Arrays.sort(B_arr);

        for(int i = 0; i < cnt; i++) {
            result += A_arr[i] * B_arr[cnt - 1- i];
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}