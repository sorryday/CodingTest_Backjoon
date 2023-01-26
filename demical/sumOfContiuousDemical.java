package demical;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class sumOfContiuousDemical {
    static boolean[] prime;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        prime = new boolean[N + 1];
        PrimeSetting();

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            int sum = 0;
            if (!prime[i]) {
                for (int j = i; j <= N; j++) {
                    if (!prime[j]) {
                        sum += j;
                        if (sum == N) {
                            cnt += 1;
                            break;
                        }
                        else if (sum > N) {
                            break;
                        }
                    }
                }
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    // 에라토스테네스의 체 : 구하고자 하는 범위의 수까지 소수가 되는 부분의 배수를 지운다.
    static void PrimeSetting() {
        for(int i = 2; i * i <= N; i++){
            if(!prime[i]){
                for(int j = i * i; j <= N; j += i){
                    prime[j] = true;
                }
            }
        }
    }
}
