import java.util.HashSet;

// 해시 Lv2 전화번호 목록
public class Solution7 {
    public boolean solution(String[] phone_book) {
        // hashset 사용
        HashSet<String> hs = new HashSet<>();
        // 넘어온 phone_book을 hs에 하나씩 넣기
        for(String phone : phone_book) {
            hs.add(phone);
//            System.out.println(hs);
        }
        // phone_book을 하나씩 돌면서 subSequence 문자열 추출 (0부터 j까지) 문자열이 hs에 포함되어있는지 확인
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                // 포함되어있다면 false
                if (hs.contains(phone_book[i].subSequence(0,j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        Solution7 sl = new Solution7();
        sl.solution(phone_book);
    }

}
