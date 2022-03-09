import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class negative_bin {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		StringBuffer result = new StringBuffer();

		if(num == 0) {
			System.out.println("0");
			System.exit(0);
		}

		while(num != 0) {
			if(num % -2 == -1) {
				num = (num / -2) + 1;
				result.append("1"); 
			}

			else if(num % -2 == 1) {
				num = (num / -2);
				result.append("1");
			}

			else if(num % -2 == 0) {
				num = (num / -2);
				result.append("0");
			}

			else if(num / -2 == 0) {  
				num = 0;
				result.append("1");
			}
		}
		result.reverse();

		bw.write(result.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}