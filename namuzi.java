import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class namuzi {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] input_it = new int[3];

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		for(int i = 0; i < 3; i++) {
			input_it[i] = Integer.parseInt(st.nextToken());
		}

		bw.write((input_it[0] + input_it[1]) % input_it[2] + "\n");
		bw.write(((input_it[0] % input_it[2]) + (input_it[1] % input_it[2])) % input_it[2] + "\n");
		bw.write((input_it[0] * input_it[1]) % input_it[2] + "\n");
		bw.write(((input_it[0] % input_it[2]) * (input_it[1] % input_it[2])) % input_it[2] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}