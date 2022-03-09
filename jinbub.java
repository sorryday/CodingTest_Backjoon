import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jinbub {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		String num = st.nextToken();
		int jinbub = Integer.parseInt(st.nextToken());

		int result = 0;
		int flag = 0;

		for(int i = num.length() - 1; i >= 0; i--) {
			char c = num.charAt(i);
			if(c >= '0' && c <= '9') {
				result += (c - '0')  * Math.pow(jinbub, flag);
				flag += 1;
			}

			else {
				result += (c - 55) * Math.pow(jinbub, flag);
				flag += 1;
			}
		}

		System.out.println(result);
		br.close();
	}
}