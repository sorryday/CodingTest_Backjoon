import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class jinbub2 {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int num = Integer.parseInt(st.nextToken());
		int jinbub = Integer.parseInt(st.nextToken());

		StringBuffer sb = new StringBuffer();
		while(num != 0) {
			int result = num % jinbub;
			if(result < 10) {
				sb.append(result);
			}

			else {
				char c = (char) (result + 55);
				sb.append(c);
			}
			
			num /= jinbub;
		}

		sb.reverse();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}