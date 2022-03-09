import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySort
{
   public static void main(String[] args) throws IOException
   {  
      Scanner sc = new Scanner(System.in);

      int[] arr = new int[10];

      int testCase = sc.nextInt();

      int[] result = new int[testCase];
      
      for(int i = 0; i < testCase; i++)
      {
         for(int k = 0; k < 10; k++)
         {
            arr[k] =  sc.nextInt();
         }

         Arrays.sort(arr);
         result[i] = arr[7];
      }

      for(int j = 0; j < testCase; j++)
      {
         System.out.println(result[j]);
      }
   }
}