import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class alphabet_cnt {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String Input = br.readLine();
		int[] result = new int[26];

		for(int i = 0; i < Input.length(); i++) {
			char c = Input.charAt(i);

			result[122 - c] += 1;
		}

		for(int k = 25; k >= 0; k--) {
			bw.write(result[k] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}