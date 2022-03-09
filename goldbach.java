import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.IOException;

public class goldbach {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		boolean[] decimal = new boolean[1000001];

        for(int i = 2; i <= 1000000;i++) {
            decimal[i] = true;
        }

		for(int i = 2; i <= 1000000; i++) {
			if(!decimal[i]) {
				continue;
			}
			for(int j = 2 * i; j < 1000000; j += i) {
				decimal[j] = false;
			}
		}

		while(true) {
			String input = br.readLine();
			int input_In = Integer.parseInt(input);
			if(input_In == 0) {
				break;
			}

			int result = gold(input_In, decimal);
			if(result > 0) {
				bw.write(input_In + " = " + result + " + " + (input_In - result) + "\n");
			}

			else{
				bw.write("Goldbach's conjecture is wrong." + "\n");
			}	
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static int gold(int n, boolean[] decimal) {

		for(int i = 1; i <= n/2; i++){
            int a = i;
            int b = n - i;
            if(decimal[a] && decimal[b]) return a;
        }
        return -1;
	}
}