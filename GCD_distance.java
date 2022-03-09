import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD_distance {  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int num = Integer.parseInt(st.nextToken());	  // 동생 수
		long cen = Integer.parseInt(st.nextToken());   // 내 현재 위치

		long[] num_lo = new long[num];   // 동생들 위치 저장 배열
		long[] num_LCM = new long[num];    // 동생들과 내위치의 LCM 저장 배열

		String location = br.readLine();

		st = new StringTokenizer(location);
		for(int i = 0; i < num_lo.length; i++) {
			num_lo[i] = Long.parseLong(st.nextToken());
		}

		for(int i = 0; i < num; i++) {
			if(cen > num_lo[i]) {
				num_LCM[i] = cen - num_lo[i];
			}
			else {
				num_LCM[i] = num_lo[i] - cen;
			}
		}

		long result = num_LCM[0];

		for(int i = 1; i < num; i++) {
			result = gcd(result, num_LCM[i]);
		}

		System.out.print(result);
	}

	public static long gcd(long n1, long n2) {
		if(n2 == 0) {
			return n1;
		}

		else {
			return gcd(n2, n1 % n2);
		}
	}
}