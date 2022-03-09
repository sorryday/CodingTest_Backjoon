import java.util.Scanner;

public class binary_number {
    
// 이진수  
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++)
        {
            int num = sc.nextInt();
            String nString = Integer.toBinaryString(num);
            
            for(int j = nString.length() - 1; j >= 0 ; j--)
            {
                if(nString.charAt(j) == '1')
                {
                    System.out.print(nString.length() - 1 - j  + " ");
                }
            }
        }
    }
}
