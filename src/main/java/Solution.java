import java.util.HashSet;

// Lv 2. 더 맵게
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        HashSet<Integer> mixScoville = new HashSet<>();

        for (int i = 0; i < scoville.length; i++) {
            if (scoville[i] < 7){
                mixScoville.add(scoville[i]);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();

        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 7;

        sl.solution(scoville, k);
    }
}
