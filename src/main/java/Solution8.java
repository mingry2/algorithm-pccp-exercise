import java.util.HashSet;

// 해시 Lv2 폰켓몬
class Solution8 {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (Integer num : nums)
            hs.add(num);
        System.out.println(hs);

        int N = nums.length / 2;

        if (hs.size() < N)
            return hs.size();
        else
            return N;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,3,2,2,2};
        Solution8 sl = new Solution8();
        System.out.println(sl.solution(nums));
    }
}
