import java.io.*;
import java.util.StringTokenizer;

public class num_Array {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] num_A = new int[num];
        int result_F = 1;
        int result_S = 1;
        int max = 1;

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < num; i++) {
            num_A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < num - 1; i++) {
            if(num_A[i] <= num_A[i + 1]) {
                result_F += 1;
            }
            else {
                max = Math.max(max, result_F);
                result_F = 1;
            }
        }

        for(int i = 0; i < num - 1; i++) {
            if(num_A[i] >= num_A[i + 1]) {
                result_S += 1;
            }
            else {
                max = Math.max(max, result_S);
                result_S = 1;
            }
        }

        max = Math.max(max, result_F);
        max = Math.max(max, result_S);

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
