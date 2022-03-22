import java.io.*;
import java.util.StringTokenizer;

public class day_count {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int E_s = 0, S_s = 0, M_s = 0;
        int cnt = 1;
        boolean flag = true;

        while (flag == true) {
            E_s += 1;
            S_s += 1;
            M_s += 1;

            if(E_s > 15) E_s = 1;
            if(S_s > 28) S_s = 1;
            if(M_s > 19) M_s = 1;

            if((E_s == E) && (S_s == S) && (M_s == M))  {
                flag = false;
                break;
            }
            else {
                cnt += 1;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}