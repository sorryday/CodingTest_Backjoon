import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class stack_seven {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String str = br.readLine();
      StringTokenizer st = new StringTokenizer(str);

      int people = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int cnt = people;

      Queue<Integer> yu = new LinkedList<Integer>();
      Queue<Integer> qu = new LinkedList<Integer>();
      for(int i = 1; i <= people; i++){
         qu.add(i);
      }

      while(people > 0){
         for(int j = 0; j < k; j++){
            if(j == k - 1){
               int t1 = qu.poll();
               yu.add(t1);
               people -= 1;
            }
            else {
               int input = qu.poll();
               qu.add(input);
            }
         } 
      }

      System.out.print("<");

      for(int i = 0; i < cnt - 1; i++){
         int t2 = yu.poll();
         System.out.print(t2 + ", ");
      }
      System.out.print(yu.poll());
      System.out.print(">");

      br.close();
   }
}