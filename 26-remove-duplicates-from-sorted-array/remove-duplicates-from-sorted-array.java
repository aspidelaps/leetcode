class Solution {
    public static int removeDuplicates(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();
        int result = 0;
        queue.add(nums[0]);
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != queue.peekLast()) {
                queue.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i ++) {
            if (queue.peek() != null) {
                result++;
                nums[i] = queue.poll();
            } else {
                nums[i] = 0;
            }
        }

        return result;
    }
}