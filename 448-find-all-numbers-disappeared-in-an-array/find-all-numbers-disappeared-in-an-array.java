class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        for (int j = 1; j <= nums.length; j++) {
            if (map.get(j) == null) {
                result.add(j);
            }
        }
        return result;
    }
}