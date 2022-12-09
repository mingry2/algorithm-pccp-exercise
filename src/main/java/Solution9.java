import java.util.HashSet;
import java.util.Iterator;

// 완전탐색 Lv2.소수찾기
class Solution9 {
    HashSet<Integer> numberSet = new HashSet<>();
    public boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다.
        if (num == 0 || num == 1)
            return false;
        // 2. 에라토스테네스의 체 limit을 계산한다.
        // num의 제곱근까지만 배수를 확인하면됨
        int lim = (int)Math.sqrt(num);
        // 3. 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public void recursive(String comb, String others){
        // comb : 현재까지 조합한 숫자 , others : 조합하지 않은 남은 숫자
        // 1. 현재 조합을 set에 추가
        // Integer 형태로 바꿔줌
        if (!comb.equals("")) // comb 맨처음에 들어왔을 땐 빈스트링이기 때문에 예외처리를 해줌
            numberSet.add(Integer.valueOf(comb)); // valueOf > Integer로 변경

        // 2. 남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i)
                    , others.substring(0,i) + others.substring(i+1));

        }
    }
    public int solution(String numbers) {
        int count = 0;
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);
//        System.out.println(numberSet);
        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()){
            // numberSet에서 하나씩 꺼내서 달라
            int number = it.next();
            if (isPrime(number))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution9 sl = new Solution9();
        String nums = "17";
        System.out.println(sl.solution(nums));

    }
}
