import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class soinsu {
    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int flag = num;

		boolean[] prime = new boolean[num + 1];
		prime[0] = true;
		prime[1] = true;

		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) {
				continue;
			}
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
		int k = 2;

		while(num != 0) {
			if(k == flag + 1) {
				break;
			}

			if(prime[k] == false && num % k == 0) {
				while(num % k == 0) {
					num = num / k;
					System.out.println(k);
				}
			}
			k += 1;
		}
    }
}