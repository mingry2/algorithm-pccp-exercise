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
}