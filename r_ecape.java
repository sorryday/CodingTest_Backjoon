import java.io.IOException;
import java.util.Scanner;
 
public class r_ecape {
	static int[] dp;
    public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);

		int han_x = sc.nextInt();
		int han_y = sc.nextInt();
		
		int Arr_x = sc.nextInt();
		int Arr_y = sc.nextInt();

		int xResult = 0;
		int yResult = 0;

		xResult = Math.min(han_x, Arr_x - han_x);
		yResult = Math.min(han_y, Arr_y - han_y);
		System.out.println(Math.min(xResult, yResult));
    }
}

