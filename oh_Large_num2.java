import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
 
public class oh_Large_num2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] result = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		int[] nums_count = new int[1000001];
		for(int i = 0; i < N; i++) {
			nums_count[seq[i]] += 1;
		}
			
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && nums_count[seq[stack.peek()]] < nums_count[seq[i]]) {
				result[stack.pop()] = seq[i];
			}
			
			stack.push(i);
		}

		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		for(int i = 0; i < N; i++) {
			bw.write(result[i] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}