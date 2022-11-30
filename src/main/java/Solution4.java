import java.util.ArrayList;
import java.util.Arrays;

// 완전탐색 Lv1. 모의고사
class Solution4 {
    public int[] solution(int[] answers) {
        int[] answer = {}; // 최대 점수를 받은 학생들 번호
        int[] first = {1,2,3,4,5}; // 1번 학생
        int[] second = {2,1,2,3,2,4,2,5}; // 2번 학생
        int[] third = {3,3,1,1,2,2,4,4,5,5}; // 3번 학생

        int[] score = {0,0,0}; // 1~3번 학생들의 점수

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i%5]) score[0]++;
            if(answers[i] == second[i%8]) score[1]++;
            if(answers[i] == third[i%10]) score[2]++;
        }
        int maxScore = Math.max(Math.max(score[0], score[1]),score[2]); // 구해진 1~3번 학생의 점수를 비교하여 최댓값 구하기
        ArrayList<Integer> scoreList = new ArrayList<Integer>();
        // maxScore 값과 1~3번 각 학생의 점수가 같으면 scoreList에 담아 1등인 학생을 구한다.
        if(maxScore==score[0]) scoreList.add(1);
        if(maxScore==score[1]) scoreList.add(2);
        if(maxScore==score[2]) scoreList.add(3);

        answer = new int[scoreList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = scoreList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution4 sl = new Solution4();
        int[] answers = new int[]{1,3,2,4,2};
        System.out.println(Arrays.toString(sl.solution(answers)));
    }
}
