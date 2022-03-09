import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class ROT13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c == ' ' || c >= '0' && c <= '9') {
				bw.write(c);
			}

			else if((c >= 78 && c <= 90) || (c >= 110 && c <= 122)) {
				bw.write(c - 13);
			}

			else {
				bw.write(c + 13);
			}	
		}

		bw.flush();
		bw.close();
		br.close();
	}
}