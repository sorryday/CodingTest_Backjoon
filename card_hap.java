import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class card_hap {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 카드 개수
        int cnt = Integer.parseInt(st.nextToken()); // 합체 횟수
        
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            heap.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < cnt; i++) {
            long temp = heap.poll();
            temp += heap.poll();
            heap.add(temp);
            heap.add(temp);
        }
    
        long result = 0;
        while(!heap.isEmpty()) {
            result += heap.poll();
        }
        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}