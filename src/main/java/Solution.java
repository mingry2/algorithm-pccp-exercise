import java.util.HashSet;

// 완전탐색 Lv2.소수찾기
class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    public void recursive(String comb, String others){
        // 1. 현재 조합을 set에 추가
        // Integer 형태로 바꿔줌
        if (!comb.equals("")) // comb 맨처음에 들어왔을 땐 빈스트링이기 때문에 예외처리를 해줌
            numberSet.add(Integer.valueOf(comb));

        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i)
                    , others.substring(0,i) + others.substring(i+1));

        }
    }
    public int solution(String numbers) {
        int answer = 0;
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);
        System.out.println(numberSet);
        return answer;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String nums = "17";
        sl.solution(nums);

    }
}
