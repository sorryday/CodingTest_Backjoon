import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;
 
public class postifix_notation{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = Integer.parseInt(br.readLine());
		String me = br.readLine();
		Stack<Double> st = new Stack<Double>();

		Double t1;
		Double t2;
		Double t_result;

		HashMap<Character, Double> mp = new HashMap<Character, Double>();
		char temp = 'A';
		for(int i = 0; i < cnt; i++) {
			mp.put(temp, Double.parseDouble(br.readLine()));
			temp++;
		}

		for(int i = 0; i < me.length(); i++) {
			switch (me.charAt(i)) {
				case '+':
					t1 = st.pop();
					t2 = st.pop();

					t_result = t2 + t1;
					st.push(t_result);
				break;

				case '-':
					t1 = st.pop();
					t2 = st.pop();

					t_result = t2 - t1;
					st.push(t_result);
				break;

				case '*':
					t1 = st.pop();
					t2 = st.pop();

					t_result = t2 * t1;
					st.push(t_result);
				break;

				case '/':
					t1 = st.pop();
					t2 = st.pop();

					t_result = t2 / t1;
					st.push(t_result);
				break;
			
				default:
					st.push(mp.get(me.charAt(i)));
				break;
			}
		}

		
		Double result = st.pop();
		bw.write(String.format("%.2f", result));

		bw.flush();
		bw.close();
		br.close();
	}
}