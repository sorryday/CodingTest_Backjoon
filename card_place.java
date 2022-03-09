import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class card_place {

    static HashSet<String> set = new HashSet<String>();    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int card_cnt = Integer.parseInt(br.readLine()); // 카드 개수
        int choice_cnt = Integer.parseInt(br.readLine()); // 뽑을 카드 수
        int[] card = new int[card_cnt];  // 카드 배열

        boolean[] visited = new boolean[card_cnt];
        int[] arr = new int[card_cnt];
        
        for(int i = 0; i < card_cnt; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }

        com(card, visited, arr, 0, card_cnt,choice_cnt);

        bw.write(Integer.toString(set.size()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void com(int[] card, boolean[] visited, int[] arr,int depth, int card_cnt, int choice_cnt) {
        if(depth == choice_cnt) {
			String str="";

			for(int i = 0; i < arr.length;i++)
				str += arr[i];
			
			set.add(str);
			return;
		}
		
		for(int i = 0; i < card_cnt; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				arr[depth] = card[i];

				com(card, visited, arr, depth + 1, card_cnt,choice_cnt);
				visited[i] = false;
			}
		}
    }
}