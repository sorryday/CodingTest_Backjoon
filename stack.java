import java.io.*; 
import java.util.*; 

public class stack {
    public static void main(String[] args) throws IOException { 
        Scanner sc = new Scanner(System.in);

        String bracket = sc.next();

        Stack<Character> stack = new Stack<Character>(); 
        int cnt = 1; 
        int sum = 0; 

        for(int i = 0; i < bracket.length(); i++){ 
            if(bracket.charAt(i) =='('){ 
                cnt *= 2; 
                stack.push('('); 
            }

            else if(bracket.charAt(i) =='['){
                 cnt *= 3; 
                 stack.push('['); 
            }
            else if(!stack.isEmpty() && bracket.charAt(i) ==')'){ 
                if(i - 1 >= 0 && bracket.charAt(i-1) =='('){ 
                    sum += cnt;
                }
                else { 
                    if(stack.peek() != '('){ 
                        sum = 0; 
                        break; 
                    } 
                } 
                cnt /= 2; 
                stack.pop(); 
            }
            
            else if(!stack.isEmpty() && bracket.charAt(i) ==']'){ 
                if(i - 1 >= 0 && bracket.charAt(i-1) =='['){
                    sum += cnt; 
                }
                
                else{ 
                    if(stack.peek() != '['){ 
                        sum = 0; 
                        break; 
                    } 
                } 
                cnt /= 3; 
                stack.pop(); 
            }
            
            else{
                sum = 0; 
                break; 
            } 
        } 

        if(!stack.isEmpty()){
            System.out.println(0);
        }
            
        else{
            System.out.println(sum);
        }       
    } 
}