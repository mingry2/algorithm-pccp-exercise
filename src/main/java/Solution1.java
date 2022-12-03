import java.util.HashSet;

// 그리디 Lv1. 체육복
class Solution1 {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for (int i : reserve) {
            resSet.add(i);
        }

        for (int i : lost) {
            if (resSet.contains(i))
                resSet.remove(i);
            else
                lostSet.add(i);
        }

        for (int i : resSet) {
            if (lostSet.contains(i - 1))
                lostSet.remove(i - 1);
            else if (lostSet.contains(i + 1))
                lostSet.remove(i + 1);
        }

        return n - lostSet.size();
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = new int[]{2,4};
        int[] reserve = new int[]{1,3,5};

        Solution1 sl = new Solution1();
        System.out.print(sl.solution(n, lost, reserve));
    }
}