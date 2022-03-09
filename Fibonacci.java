import java.io.IOException;
import java.util.Scanner;

public class Fibonacci 
{
    public static void main(String[] args) throws IOException
    {
        int result = 0; 
        int minFirst = 0; 
        int minSecond = 1;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        switch(n)
        {
            case 0:
                System.out.println(0);
                break;

            case 1:
                System.out.println(1);
                break;

            case 2:
                System.out.println(1);
                break;

            default:
                for(int i = 0; i < n - 1; i++)   
                {     
                    result = minFirst + minSecond;
                    minFirst = minSecond;
                    minSecond = result;
                }
                System.out.println(result);
                break;
        }
    }
}
