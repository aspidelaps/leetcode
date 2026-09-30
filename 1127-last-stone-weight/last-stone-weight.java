class Solution {
    public static int lastStoneWeight(int[] stones) {
        int length = stones.length-1;
        if (length == 0) {
            return stones[0];
        }
        int[] arraySmashed = smash(stones, length);

        if (arraySmashed[length] == 0) {
            return 0;
        } else {
            return arraySmashed[length];
        }
    }

    private static int[] smash(int[] stones, int length) {
        int[] array = Arrays.stream(stones).sorted().toArray();
        if (array[length-1] == 0) {
            return array;
        }
        array[length] -= array[length - 1];
        array[length-1] = 0;
        return smash(array, length);
    }
}