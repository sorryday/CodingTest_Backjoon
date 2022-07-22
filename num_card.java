import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_card {
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
        int[] num_compare = new int[N];             // 숫자 카드
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num_compare[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];

        // 이분탐색 알고리즘
        Arrays.sort(num_have);
      
        for(int j = 0; j < N; j++) {
            int start = 0, end = num_have.length - 1;
            int mid = (start + end) / 2;

            while(end - start >= 0) {
                mid = (start + end) / 2;
                if(num_have[mid] == num_compare[j]) {
                    result[j] = 1;
                    break;
                } 
    
                else if(num_have[mid] > num_compare[j]) {
                    end = mid - 1;
                }
    
                else if(num_have[mid] < num_compare[j]) {
                    start = mid + 1;
                }
                else {
                    result[j] = 0;
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            bw.write(Integer.toString(result[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}