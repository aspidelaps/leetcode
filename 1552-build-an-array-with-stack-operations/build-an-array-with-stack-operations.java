class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> result = new ArrayList<>();

        String push = "Push";
        String pop = "Pop";

        int k = 0;
        for (int i = 1; i <= n; i++) {
            if (target[k] == i) {
                result.add(push);
                k++;
            } else {
                result.add(push);
                result.add(pop);
            }
            if (k > target.length - 1) {
                break;
            }
        }

        return result;
    }
}