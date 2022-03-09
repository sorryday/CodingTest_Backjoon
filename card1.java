import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class card1 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int card_cnt = Integer.parseInt(br.readLine());
        Queue<Integer> qu = new LinkedList<Integer>();
        Queue<Integer> st = new LinkedList<Integer>();

        for(int i = 1; i <= card_cnt; i++) {
            qu.add(i);
        }

        while(qu.size() > 1) {
            st.add(qu.poll());  // 맨 위의 카드를 바닥에 버린다(= Stack에 집어 넣는다)
            qu.add(qu.poll());   // 맨 위의 카드를 카드 뭉치의 바닥에 놓는다.
        }

        st.add(qu.poll());

        while(!st.isEmpty()) {
            bw.write(Integer.toString(st.poll()) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}