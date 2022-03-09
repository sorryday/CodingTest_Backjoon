import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class min_heap {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(heap.isEmpty()) {
                    bw.write(0 + "\n");
                }
                else {
                    bw.write(heap.poll() + "\n");
                }
            }

            else {
                heap.add(input);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}