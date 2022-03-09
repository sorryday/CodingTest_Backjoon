
import java.util.Arrays;
import java.util.Scanner;

public class dwarf
{
   public static void main(String[] args)
   {
       Scanner sc = new Scanner(System.in);
    
       int[] num = new int[9];
       int sum = 0;

       for(int i = 0; i < 9; i++)
       {
           num[i] = sc.nextInt();
           sum += num[i];
       }

       Arrays.sort(num);

       for(int k = 0; k < 9; k++)
       {
           for(int j = k + 1; j < 9; j++)
           {
               if(sum - num[k] - num[j] == 100)
               {
                    for(int q = 0; q < 9; q++)
                    {   
                        if(q == k || q == j)
                        {
                            continue;
                        }
                        System.out.println(num[q]);
                    }
                    System.exit(0);
               }
           }
       }
   }
}