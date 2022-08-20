package kmp;

import java.io.*;

public class String_part {
    static String S;
    static String pattern;
    static int[] pi;

    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        pattern = br.readLine();
        pi = new int[pattern.length()];

        getPi();
        kmp();

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void kmp() {
        // 패턴 내 일치체크 idx
        int j = 0;
        // 전체 문자열 돌기
        for (int i = 0; i < S.length(); i++) {
            // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
            while(j > 0 && S.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            // 맞는 경우 패턴의 끝까지 확인했으면 정답
            if(S.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1) {
                    result = 1;
                    break;
                    //패턴이 있는지가 아닌 몇개 있는지 찾는거면
                    // answer++; : 개수증가
                    // j = pi[j]; : j 초기화
                    // 아니면 패턴의 다음 문자를 확인
                }else{
                    j++;
                }
            }
        }
    }

    public static void getPi(){
        // j = 접두사, i 접미사
        int j = 0;
        // 패턴을 돌면서 체크
        for(int i = 1; i < pattern.length(); i++){
            // 처음 접두사가 아니면서 일치하지 않으면, 반복되는 패턴의 앞부분으로 변경
            // 만약 반복되는 패턴이 없으면, j = 0까지 돌아갈거임
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j - 1];
            }
            // 일치할때, 접두사의 길이(경계) 저장
            // 현재 맞은 idx의 +1은 길이이자, 다음 체크할 idx가 됨
            if(pattern.charAt(i) == pattern.charAt(j)){
                pi[i] = ++j;
            }
        }
    }
}