public class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxStone = 0;
        for (int stone : stones) {
            maxStone = Math.max(maxStone, stone);
        }

        int[] bucket = new int[maxStone + 1];
        for (int stone : stones) {
            bucket[stone]++;
        }

        int first = maxStone, second = maxStone;
        while (first > 0) {
            if (bucket[first] % 2 == 0) {
                first--;
                continue;
            }

            int j = Math.min(first - 1, second);
            while (j > 0 && bucket[j] == 0) {
                j--;
            }

            if (j == 0) {
                return first;
            }

            second = j;
            bucket[first]--;
            bucket[second]--;
            bucket[first - second]++;
            first = Math.max(first - second, second);
        }

        return first;
    }
}