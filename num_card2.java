import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_card2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int M = Integer.parseInt(br.readLine());
        int[] num_have = new int[M];                // 내 카드
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            num_have[i] = Integer.parseInt(st.nextToken());
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Arrays.sort(num_have);
      
        for(int j = 0; j < N; j++) {
            int num_key = Integer.parseInt(st.nextToken());
            sb.append(upper_bound(num_have, num_key) - lowwer_bound(num_have, num_key) + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    // 상한 (num_key 값보다 큰 값이 처음 나올 때의 인덱스를 이용하여 탐색)
    static int upper_bound(int[] num_have, int num_key) {
        int start = 0;
        int end = num_have.length;

        while(start < end) {
            int mid = (start + end) / 2;

            if(num_key < num_have[mid]){
                end = mid;
            }

            else {
                start = mid + 1;
            }
        }
        return start;
    }

    // 하한 (num_key 값 보다 작거나 같은 값이 처음 나올 때의 인덱스를 이용하여 탐색)
    static int lowwer_bound(int[] num_have, int num_key) {
        int start = 0;
        int end = num_have.length;

        while(start < end) {
            int mid = (start + end) / 2;

            if(num_key <= num_have[mid]){
                end = mid;
            }

            else {
                start = mid + 1;
            }
        }
        return start;
    }
}