import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.IOException;

public class subString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		String[] result = new String[input.length()];

		for(int i = 0; i < input.length(); i++) {
			String temp = input.substring(i);
			result[i] = temp;
		}
	
		Arrays.sort(result);

		for(int i = 0; i < result.length ; i++) {
			bw.write(result[i] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}