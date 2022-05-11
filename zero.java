import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class zero {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> num = new Stack<>();

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            if(t != 0) {
                num.push(t);
            } else {
                num.pop();
            }
        }

        int result = 0;
        while(!num.isEmpty()) {
            result += num.pop();
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
