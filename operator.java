import java.util.Scanner;

public class operator {

   static int[] operator = new int[4];    // 연산자
   static int[] nums;
   static int num_cnt;

   static int max = -1000000000;
   static int min = 1000000000;
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      num_cnt = sc.nextInt();     // 배열 수
      nums = new int[num_cnt];  // 배열

      for(int i = 0; i < num_cnt; i++){
         nums[i] = sc.nextInt();
      }
      for(int k = 0; k < 4; k++){
         operator[k] = sc.nextInt();
      }

      operation(nums[0], 1);

      System.out.println(max);
      System.out.println(min);
    }

   public static void operation(int first, int index){
      if(index == num_cnt){
         max = Math.max(max, first);
         min = Math.min(min, first);
         return;
        }
      
      for(int i = 0; i < 4; i++){       // 백트래킹 연산 로직
         if(operator[i] > 0){
            operator[i]--;

            switch(i){
               case 0:
                  operation(first + nums[index], index + 1);
                  break;
               case 1:
                  operation(first - nums[index], index + 1);
                  break;
               case 2:
                  operation(first * nums[index], index + 1);
                  break;
               case 3:
                  operation(first / nums[index], index + 1);
                  break;
            }
            operator[i]++;
        }
      }
   }
}