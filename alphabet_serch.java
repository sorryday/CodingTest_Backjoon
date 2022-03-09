import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class alphabet_serch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		int[] result = new int[26];
		for(int i = 0; i < 26; i++) {
			result[i] = -1;
		}

		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if(result[122 - c] == -1) {
				result[122 - c] = i;
			}
		}

		for(int i = 25; i >= 0; i--) {
			bw.write(result[i] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}