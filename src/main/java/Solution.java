import java.util.HashMap;

//해시 Lv1 완주하지못한선수
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 1. Hash map을 만들어 participant, completion을 넣어준다
        // -> 순서 x 중복 o
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant)
            // value -> 이전에 있던 값에서 하나를 더 증가해서 넣어주고싶음
            // 중복이 있을 수 있기 때문 이 때, getOrDefault 사용
            map.put(player, map.getOrDefault(player, 0) + 1);
//        System.out.println(map);
        // 2. Hash map을 뺀다(completion)
        for (String player : completion)
            // player에 넣을 때 값이 있으면 그 값을 가져오는게 아니라 값에서 -1 한 값을 가져온다.
            // getOrDefault까지 쓰는게 아니라 get만 사용해서 값에 -1 값 가져오기
            map.put(player, map.get(player) - 1);
        // 3. value가 '0'이 아닌 마지막 주자를 찾는다.
        // .keySet 은 map이 가지고 있는 값들을 하나씩 빼서 map 에 담아주는것
//        System.out.println(map.keySet());
        for (String key : map.keySet())
            if (map.get(key) != 0) {
                answer = key;
                // 굳이 끝까지 돌필요없으니까 0인 값이 나오면 끝내버리기 위해 break를 사용
                break;
            }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden"}; // 마라톤 참가 선수
        String[] completion = new String[]{"eden", "kiki"}; // 마라톤 완주한 선수

        Solution sl = new Solution();
        System.out.println(sl.solution(participant, completion));
    }
}