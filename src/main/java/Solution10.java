import java.util.PriorityQueue;

// Lv 2. 더 맵게
class Solution10 {
    public int solution(int[] scoville, int k) {
        int answer = 0;

        // 우선순위 Queue -> 우선순위 : 낮은 숫자
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 위에서 결정한 우선순위에 따라 heap에 넣어준다.
        for (Integer aScovile : scoville
             ) { heap.offer(aScovile);
            System.out.println(heap.peek());
        }

        // heap의 첫번째 값을 참조 -> .peek()
        // 그 값이 k 보다 작거나 같을 동안
        while (heap.peek() <= k) {
            // heap 길이가 1 이라면 섞어서 k 만큼 맵게 만들 음식이 하나 더 없기 때문에 -1를 그냥 반환시킨다
            if (heap.size() == 1) {
                return -1;
            }

            // 우선순위 큐는 우선순위를 먼저 결정하고 그 우선순위가 높은 엘리먼트가 먼저 나가는 구조임
            int a = heap.poll();
            int b = heap.poll();

            // result에 해당 값을 담고
            int result = a + (b * 2);

            // heap에 result 값을 넣는다 -> .offer()
            heap.offer(result);

            // 섞은 횟수를 알아야하기 때문에 위와같이 섞었으면 count를 올린다
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution10 sl = new Solution10();

        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 7;

        System.out.println(sl.solution(scoville, k));
    }
}
