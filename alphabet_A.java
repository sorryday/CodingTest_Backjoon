import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class alphabet_A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = new String();
		int[] result = new int[4];

		while((input = br.readLine()) != null){
			for(int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if(c >= 'a' && c <= 'z') {
					result[0] += 1;
				}
	
				else if(c >= 'A' && c <= 'Z') {
					result[1] += 1;				
				}
	
				else if(c == ' ') {
					result[3] += 1;			
				}
	
				else if(c >= '0' && c <= '9'){
					result[2] += 1;
				}
			}

			for(int i = 0; i < 4; i++) {
				bw.write(result[i] + " ");
			}
			bw.write("\n");
			bw.flush();

			for(int i = 0; i < 4; i++) {
				result[i] = 0;
			}
		}
	}
}