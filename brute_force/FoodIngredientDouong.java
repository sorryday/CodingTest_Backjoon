package brute_force;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FoodIngredientDouong {

    static class FoodIngredient {
        int S = 0;
        int B = 0;

        public FoodIngredient(int s, int b) {
            S = s;
            B = b;
        }
    }

    static int min = Integer.MAX_VALUE;
    static int foodIngredientCnt;
    static List<FoodIngredient> foodIngredientList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        foodIngredientCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < foodIngredientCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            foodIngredientList.add(new FoodIngredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int input_cnt = 0;
        int s_mul = 1;
        int b_hap = 0;
        int idx = 0;

        setMinResult(input_cnt, idx, s_mul, b_hap);

        bw.write(Integer.toString(min) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setMinResult(int input_cnt, int idx, int s_mul, int b_hap) {
        if(idx == foodIngredientCnt) {
            if(input_cnt !=0) {
                min = Math.min(min, Math.abs(s_mul - b_hap));
            }
            return;
        }
        setMinResult(input_cnt, idx + 1, s_mul, b_hap); // 재료 넣지 않은 것
        setMinResult(input_cnt+1, idx + 1, s_mul * foodIngredientList.get(idx).S, b_hap + foodIngredientList.get(idx).B);
    }
}