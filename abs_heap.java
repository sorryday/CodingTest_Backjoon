import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class abs_heap {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(heap.isEmpty() && min_heap.isEmpty()) {
                    bw.write(0 + "\n");
                    continue;
                }
                else if(heap.isEmpty() && !min_heap.isEmpty()){
                    bw.write(-min_heap.poll() + "\n");
                    continue;
                }
                else if(!heap.isEmpty() && min_heap.isEmpty()){
                    bw.write(heap.poll() + "\n");
                    continue;
                }
                // 둘 다 값이 있다면
                if(Math.abs(min_heap.peek()) <= heap.peek()) {
                    bw.write(-min_heap.poll() + "\n");
                }
                else {
                    bw.write(heap.poll() + "\n");
                }
            }

            else {
                if(input > 0) {
                    heap.add(input);
                }
                else {
                    min_heap.add(input);
                }
            }
        }
        System.out.println();
        bw.flush();
        bw.close();
        br.close();
    }
}