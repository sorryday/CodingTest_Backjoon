import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class oct_to_bin {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringBuffer result = new StringBuffer();
		String[] bin = {"000", "001", "010", "011", "100", "101", "110", "111",
						"1000", "1001"};
	
		for(int i = 0; i < input.length(); i++) {
			if(i == 0 &&  input.charAt(i) - '0' <= 3) {
				if(input.charAt(i) - '0' < 2) {
					result.append(bin[input.charAt(i) - '0'].substring(2));
				}
				else {
					result.append(bin[input.charAt(i) - '0'].substring(1));
				}
			}
			else {
				result.append(bin[input.charAt(i) - '0']);
			}
		}

		bw.write(result.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}