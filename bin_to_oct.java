import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bin_to_oct {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int temp_r = 0;
		int cnt = 0;
		int k = 0;
		
		String input = br.readLine();
		if(input.length() % 3 == 1) {
			input = "00" + input;
		}

		if(input.length() % 3 == 2) {
			input = "0" + input;
		}

		if(input.length() % 3 == 0) {
			int[] result = new int[input.length() / 3];

			for(int i = input.length() - 1; i >= 0; i--) {
				int c = input.charAt(i) - '0';    // char 문자를 숫자 변환

				if(i % 3 == 0) {
					temp_r += c * 4;
					cnt += 1;
				}
				if(i % 3 == 1) {
					temp_r += c * 2;
					cnt += 1;
				}
				if(i % 3 == 2) {
					temp_r += c * 1;
					cnt += 1;	
				}

				if(cnt == 3) {
					result[k] = temp_r;
					cnt = 0;
					temp_r = 0;
					k += 1;
				}
			}

			for(int j = (input.length() / 3) - 1; j >= 0; j--) {
				System.out.print(result[j]);
			}
		}
	}
}