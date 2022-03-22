import javax.lang.model.SourceVersion;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Remocon {
    static boolean[] broke = new boolean[10];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 목표 채널
        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        if(cnt != 0) { // 0인 경우는 3번째 줄이 안 주어지기 때문에!!
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt; i++) {
                int temp = Integer.parseInt(st.nextToken());
                broke[temp] = true;
            }
        }

        int result = Math.abs(N - 100);
        for(int i = 0; i <= 999999; i++) {  // 9번만 안 고장나고 나머지가 고장났을 때는 9번만으로도 하는 경우도 있으니 999999까지 봐야됨
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j < len; j++) {
                if(broke[str.charAt(j) - '0']) { //고장난 버튼을 눌렀을 경우
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak) { //i를 누를때 고장난 버튼을 누르지 않았을 경우
                int min = Math.abs(N - i) + len;  // Math.abs(N - i) : i번 버튼을 눌렀을 때 목표까지 도달하기 위해 +을 누르는 횟수
                // len : 버튼의 자리수만큼 누른 것이 되므로 더해줌
                result = Math.min(min, result);
            }
        }
        System.out.print(result);
    }
}