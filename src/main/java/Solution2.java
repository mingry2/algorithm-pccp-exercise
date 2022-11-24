import java.util.Arrays;

// 해쉬 - 예산
class Solution2 {
    public int solution(int[] d, int budget) {
        // 배열을 정렬하는 함수(외우기)
        Arrays.sort(d);
//        System.out.println(Arrays.toString(d));
        // [1, 2, 3, 4, 5]
        int answer = 0; // 지원가능한 부서 개수 -> count
        int result = 0;
        for (int i = 0; i < d.length; i++) {
            result += d[i];
            if(budget - result >= 0)
                answer += 1;
            else
                break;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] d = new int[]{2, 2, 3, 3};
        int budget = 10;

        Solution2 sl = new Solution2();
        System.out.println(sl.solution(d, budget));
    }
}
