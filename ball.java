import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ball {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] num = new boolean[4];
        num[1] = true;
        num[2] = false;
        num[3] = false;

        String change;
        StringTokenizer st;

        int first = 0;
        int second = 0;

        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++) {
            change = br.readLine();
            st = new StringTokenizer(change);

            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            if(num[first] == true) {
                num[second] = true;
                num[first] = false;
            }

            else if(num[second] == true){
                num[first] = true;
                num[second] = false;
            }
        }

        for(int i = 1; i <= 3; i++) {
            if(num[i] == true) {
                bw.write(Integer.toString(i));
                break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}