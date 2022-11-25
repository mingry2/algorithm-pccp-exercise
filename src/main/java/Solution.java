import java.util.Arrays;

// 이분탐색 Lv1. 비밀지도

// Integer.toString(정수, 바꿀 진수);를 하면 정수를 바꿀 진수 String 값으로 변환해준다.
// Integer.toBinaryString-> 2진수로 바꿔주는
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        // arr1 1번지도와 arr2 2번지도를 |(OR)연산을 통해 합쳐서 벽(#)이 아닌곳을 찾는다.
        for (int i = 0; i < n; i++) {
            String s = Integer.toString(arr1[i]|arr2[i], 2);
            // 만약 1|1 -> 이면 공백없이 # 한자리만 나옴 -> n의 자리수만큼 채워줘야함
            // ex 1|1 -> # , #      < 이렇게 되어야함
            // 문자열을 일정하게 반복할 수 있는 함수 .repeat() 를 사용
            String s1 = " ".repeat(n-s.length())+s;
            // 주어진 arr1,2의 정수를 2진수로 변환하여 해당 2진수 값을 공백은 " ", 벽은 "#"으로 바꿔준다.
            // ㄴ 바꿀String.replace("변경전String","변경후String") 사용
            s1 = s1.replace("1", "#").replace("0", " ");
            answer[i] = s1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};

        Solution sl = new Solution();
        System.out.print(Arrays.toString(sl.solution(n, arr1, arr2)));
//        sl.solution(n, arr1, arr2);
    }
}