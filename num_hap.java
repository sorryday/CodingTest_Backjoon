import java.io.*;

public class num_hap {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long S = Long.parseLong(br.readLine());
        long t_hap = 0, cnt = 0;
        long t_int = 1;

        while(t_hap <= S) { // S를 넘으면 넘기 전 마지막 숫자까지를 이용하여 S를 만들 수 있음
            t_hap += t_int;
            cnt += 1;
            t_int += 1;
        }

        bw.write(Long.toString(cnt - 1));
        bw.flush();
        bw.close();
        br.close();
    }
}