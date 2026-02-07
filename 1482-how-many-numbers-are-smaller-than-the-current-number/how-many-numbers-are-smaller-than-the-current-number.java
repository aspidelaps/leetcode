class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result.add(count);
        }
        int[] array = result.stream().mapToInt(i -> i).toArray();
        return array;
    }
}