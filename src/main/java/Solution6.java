import java.util.Arrays;

// 정렬 Lv1 제일작은수제거
class Solution6 {
    public int[] solution(int[] arr) {

        // 배열의 길이가 1 인경우 -> -1 반환
        // 제일 작은 수를 구할 수 없기 때문
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }

        // 배열의 길이가 1보다 클때부터 작은수를 제거할 수 있다.
        // 원래의 길이보다 -1한 길이로 초기화를 해줌 -> arr.length < 이 배열로는 사용할 수 없음/배열 4인데 return해야하는 배열의수는 3이기때문
        int[] answer = new int[arr.length-1];

        // 기준값을 잡음
        int min = arr[0];

        // Math.in(a, b) -> 클래스를 사용하여 a, b 중에 작은수를 min에다가 대입
        for(int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        // 넘어온 배열에 제일작은수가 2개로 중복될경우를 위해 처리해줌
        int index = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) {
                continue;
            }

            // answer[0] 에다가 4를 먼저 대입하고 ++ 하여 answer[1] 만듦
            // 제일 작은 수 빼고 배열에 넣어 return
            answer[index++] = arr[i];
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1};
        Solution6 sl = new Solution6();
        System.out.println(Arrays.toString(sl.solution(arr)));
    }
}
