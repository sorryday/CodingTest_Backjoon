import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class fibonacci_method {
    static int one_cnt = 0, zero_cnt = 0, next_hap = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int cnt = Integer.parseInt(br.readLine()); // 반복횟수
        for(int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            fibo(num);
            sb.append(zero_cnt + " " + one_cnt + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void fibo(int num) {
        zero_cnt = 1;
		one_cnt = 0;
        next_hap = 1;
        for(int i = 0; i < num; i++) {
            zero_cnt = one_cnt;
            one_cnt = next_hap;
            next_hap = zero_cnt + one_cnt;
        }
    }
}